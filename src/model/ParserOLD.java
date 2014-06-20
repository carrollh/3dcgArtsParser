/** Parser.java
 * 
 * Abstract class used to extract all of the objData from
 * the input string.
 * 
 */

package model;
import java.io.IOException;
import java.util.LinkedList;

import fileIO.InputHandler;

public abstract class ParserOLD {
	private static String[] objData;
	private static int readhead = 0;
	private static String modeltype;
	private static String mtlData = "";
	
	/**
	 * Primary hub method that calls all of the top level
	 * methods required to build a Model class instance.
	 * TODO: Replace with Factory design pattern if further 
	 * test cases handle the normal objData differently.
	 * @return
	 */
	public static ModelOLD parseModel() {
		return new ModelOLD(parseFaces(),
						 parseNormalIndices(),
						 parseVertices(),
						 parseNormals(),
						 parseUVs(),
						 parseMaterials());
	}

	/**
	 * Extract all the faces from the input string.
	 * It first loads the objData[] buffer with just the 
	 * relevant objData, then calls helper methods based on
	 * which face type if finds in the first index location 
	 * of each face.
	 * @return
	 */
	private static LinkedList<IndexSet> parseFaces() {
		LinkedList<IndexSet> output = new LinkedList<IndexSet>();
		System.out.println("parsing face objData...");	
		
		readhead = InputHandler.input.indexOf("faces") + 9;
		int matPtr = InputHandler.input.indexOf("materials") - 4;
		
		objData = InputHandler.input.substring(readhead, matPtr).split(",");
		readhead = 0;

		while(readhead < objData.length) {

			modeltype = objData[readhead++];
			output.add(parseSingleFace());
							
			if(objData[readhead - 1].charAt(0) == '[') {
				// fix the first vert index in the next face list
				objData[readhead - 1] = objData[readhead - 1].substring(1);
			}
		}
		
		return output;
	}
	
	/**
	 * Determine which type of face currently at the 
	 * readhead, and call the appropriate helper method
	 * to read 3 or 4 face vertex indices.
	 * @return
	 */
	private static IndexSet parseSingleFace() {
		int[] vertIndices = null;
		
		if(modeltype.equals("43") || modeltype.equals("11")) 
			vertIndices = parseQuad();
		else if(modeltype.equals("42") || modeltype.equals("10"))
			vertIndices = parseTri();
		
		return new IndexSet(vertIndices);
	}
	
	/**
	 * Extract a single Quad's vertex indices or normals. 
	 * Helper method for parseFaces().
	 * @return
	 */
	private static int[] parseQuad() {
		int[] output = parse4Ints();
		
		if(modeltype.equals("43")) readhead += 9;
		else if(modeltype.equals("11")) readhead += 5;
	
		return output;
	}
	
	/**
	 * Extract a single Tri's vertex indices or normals. 
	 * Helper method for parseFaces().
	 * @return
	 */
	private static int[] parseTri() {
		int[] output = parse3Ints();

		if(modeltype.equals("42")) readhead += 7;
		else if(modeltype.equals("10")) readhead += 4;
		
		return output;
	}
	
	private static int[] parse4Ints() {
		int[] output = { parseInt(), parseInt(), parseInt(), parseInt()};
		return output;
	}
	
	private static int[] parse3Ints() {
		int[] output = { parseInt(), parseInt(), parseInt() };
		return output;
	}
	
	/**
	 * Extract just the normal objData from the input.
	 * This method needs to be called while the objData[] 
	 * buffer is still full of the 'faces' objData, since
	 * they are stored together for this input model format.
	 * 
	 * TODO: verify that the other model types for the 
	 * web site do not change this. Modify code as necessary.
	 * 
	 * @return
	 */
	private static LinkedList<IndexSet> parseNormalIndices() {
		LinkedList<IndexSet> output = new LinkedList<IndexSet>();
		System.out.println("parsing normal indices...");	
		
		readhead = 0;

		while(readhead < objData.length) {

			modeltype = objData[readhead++];
			output.add(parseSingleNormalSet());
		}
		
		return output;
	}
	
	/**
	 * Determine which type of face currently at the 
	 * readhead, and call the appropriate helper method 
	 * to read 3 or 4 normal indices.
	 * @return
	 */
	private static IndexSet parseSingleNormalSet() {
		IndexSet output = null;
		int[] normalIndices = null;
		
		switch(modeltype) {
		case "42":
				//readhead += 3;
			readhead += 4;
			normalIndices = parse3Ints();
			readhead += 3;
			break;
		case "10":
				readhead += 4;
				normalIndices = parse3Ints();
			break;
		case "43":
				//readhead += 4;
			readhead += 5;
			normalIndices = parse4Ints();
			readhead += 4;
			break;
		case "11": 
				readhead += 5;
				normalIndices = parse4Ints();
			break;
		}
		
		output = new IndexSet(normalIndices);
		
		return output;
	}

	
	private static LinkedList<Point3D> parseVertices() {
		LinkedList<Point3D> output = new LinkedList<Point3D>();
		System.out.println("parsing vert objData...");
		
		readhead = InputHandler.input.indexOf("vertices") + 12;
		int end = InputHandler.input.lastIndexOf("]]");
		objData = InputHandler.input.substring(readhead, end).split(",");
		readhead = 0;

		while(readhead < objData.length) {
			output.add(new Point3D(parseFloat(), parseFloat(), parseFloat()));
		}
		
		return output;
	}
	
	private static float parseFloat() {
		return Float.parseFloat(objData[readhead++]);
	}
	
	private static LinkedList<Point3D> parseNormals() {
		
		return null;
	}
	
	private static LinkedList<Point2D> parseUVs() {
		LinkedList<Point2D> output = new LinkedList<Point2D>();
		System.out.println("parsing uvs...");
		
		readhead = InputHandler.input.indexOf("uvs") + 8;
		int end = InputHandler.input.lastIndexOf("]]]");
		objData = InputHandler.input.substring(readhead, end).split(",");
		readhead = 0;
		
		while(readhead < objData.length) {
			output.add(new Point2D(parseFloat(), parseFloat()));
		}
		
		return output;
	}
	
	private static int parseInt() {
		int output = 0;
		try {
			output = Integer.parseInt(objData[readhead]);
			readhead++;
		}
		catch(NumberFormatException e) {
			if(objData[readhead].charAt(0) == '[') 
				objData[readhead] = objData[readhead].substring(1);
			return parseInt();
		}
		
		return output;
	} 
	
	private static LinkedList<MaterialOLD> parseMaterials() {
		LinkedList<MaterialOLD> output = new LinkedList<MaterialOLD>();
		System.out.println("parsing materials...");
			
		
		return output;
	}
	
	public static MaterialOLD parseMTL() {
		
		int start = InputHandler.input.indexOf("materials") + 13;
		int end = InputHandler.input.indexOf("morphColors") - 4;
		mtlData = InputHandler.input.substring(start, end);
		
		return new MaterialOLD(parseString("DbgName\":\""), 
							parseFloat("specularCoef\":"),
							parsePoint3D("colorAmbient\":["),
							parsePoint3D("colorDiffuse\":["),
							parsePoint3D("colorSpecular\":["),
							parseFloat("opticalDensity\":"),
							parseFloat("transparency\":"),
							(byte)parseInt("illumination\":"),
							parseString("mapAlpha\":\""));
	}
	
	private static String parseString(String query) {
		String temp = "";
		
		int start = mtlData.indexOf(query);
		if(start > 0) temp = mtlData.substring(start);
		int end = temp.indexOf("\",");
		if(end > 0)	return temp.substring(query.length(), end);
		return "";
	}
	
	private static float parseFloat(String query) {
		int start = mtlData.indexOf(query);
		//System.out.println("trying to find: " + query);
		String temp = mtlData.substring(start);
		int end = temp.indexOf(",");
		if(end < 0) end = temp.length() - 1;
		
		return Float.parseFloat(temp.substring(query.length(), end));
	}
	
	private static Point3D parsePoint3D(String query) {
		int start = mtlData.indexOf(query);
		String temp = mtlData.substring(start);
		int end = temp.indexOf(",");
		float x = Float.parseFloat(temp.substring(query.length(), end));
		
		temp = temp.substring(end + 1);
		end = temp.indexOf(",");
		float y = Float.parseFloat(temp.substring(0, end));
		
		temp = temp.substring(end + 1);
		end = temp.indexOf("]");
		float z = Float.parseFloat(temp.substring(0, end));
		
		return new Point3D(x, y, z);
	}
	
	private static int parseInt(String query) {
		int start = mtlData.indexOf(query);
		String temp = mtlData.substring(start);
		int end = temp.indexOf(",");
		if(end < 0) end = temp.length() - 1;
		
		return Integer.parseInt(temp.substring(query.length(), end));
	}
}
