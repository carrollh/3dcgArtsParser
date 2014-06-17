/** Parser.java
 * 
 * Abstract class used to extract all of the data from
 * the input string.
 * 
 */

package model;
import java.io.IOException;
import java.util.LinkedList;

import fileIO.InputHandler;

public abstract class Parser {
	private static String[] data;
	private static int readhead = 0;
	private static String facetype;
	
	/**
	 * Primary hub method that calls all of the top level
	 * methods required to build a Model class instance.
	 * TODO: Replace with Factory design pattern if further 
	 * test cases handle the normal data differently.
	 * @return
	 */
	public static Model parseModel() {
		return new Model(parseFaces(),
						 parseNormalIndices(),
						 parseVertices(),
						 parseNormals(),
						 parseUVs(),
						 parseMaterials());
	}

	/**
	 * Extract all the faces from the input string.
	 * It first loads the data[] buffer with just the 
	 * relevant data, then calls helper methods based on
	 * which face type if finds in the first index location 
	 * of each face.
	 * @return
	 */
	private static LinkedList<IndexSet> parseFaces() {
		LinkedList<IndexSet> output = new LinkedList<IndexSet>();
		System.out.println("parsing face data...");	
		
		readhead = InputHandler.input.indexOf("faces") + 9;
		int matPtr = InputHandler.input.indexOf("materials") - 4;
		
		data = InputHandler.input.substring(readhead, matPtr).split(",");
		readhead = 0;

		while(readhead < data.length) {

			facetype = data[readhead++];
			output.add(parseSingleFace());
							
			if(data[readhead - 1].charAt(0) == '[') {
				// fix the first vert index in the next face list
				data[readhead - 1] = data[readhead - 1].substring(1);
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
		
		if(facetype.equals("43") || facetype.equals("11")) 
			vertIndices = parseQuad();
		else if(facetype.equals("42") || facetype.equals("10"))
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
		
		if(facetype.equals("43")) readhead += 9;
		else if(facetype.equals("11")) readhead += 5;
	
		return output;
	}
	
	/**
	 * Extract a single Tri's vertex indices or normals. 
	 * Helper method for parseFaces().
	 * @return
	 */
	private static int[] parseTri() {
		int[] output = parse3Ints();

		if(facetype.equals("42")) readhead += 7;
		else if(facetype.equals("10")) readhead += 4;
		
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
	 * Extract just the normal data from the input.
	 * This method needs to be called while the data[] 
	 * buffer is still full of the 'faces' data, since
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

		while(readhead < data.length) {

			facetype = data[readhead++];
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
		
		switch(facetype) {
		case "42":
				readhead += 3;
		case "10":
				readhead += 4;
				normalIndices = parse3Ints();
			break;
		case "43":
				readhead += 4;
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
		System.out.println("parsing vert data...");
		
		readhead = InputHandler.input.indexOf("vertices") + 12;
		int end = InputHandler.input.lastIndexOf("]]");
		data = InputHandler.input.substring(readhead, end).split(",");
		readhead = 0;

		while(readhead < data.length) {
			output.add(new Point3D(parseFloat(), parseFloat(), parseFloat()));
		}
		
		return output;
	}
	
	private static float parseFloat() {
		return Float.parseFloat(data[readhead++]);
	}
	
	private static LinkedList<Point3D> parseNormals() {
		
		return null;
	}
	
	private static LinkedList<Point2D> parseUVs() {
		LinkedList<Point2D> output = new LinkedList<Point2D>();
		System.out.println("parsing uvs...");
		
		readhead = InputHandler.input.indexOf("uvs") + 8;
		int end = InputHandler.input.lastIndexOf("]]]");
		data = InputHandler.input.substring(readhead, end).split(",");
		readhead = 0;
		
		while(readhead < data.length) {
			output.add(new Point2D(parseFloat(), parseFloat()));
		}
		
		return output;
	}
	
	private static int parseInt() {
		return Integer.parseInt(data[readhead++]);
	} 
	
	private static LinkedList<Material> parseMaterials() {
		LinkedList<Material> output = new LinkedList<Material>();
		System.out.println("parsing materials...");
			
		
		return output;
	}
}
