/** Parser.java
 * 
 * Abstract class used to extract all of the data from
 * the input string.
 * 
 */

package fileIO;
import java.io.IOException;
import java.util.LinkedList;

import model.Face;
import model.Material;
import model.Model;
import model.Point2D;
import model.Point3D;

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
						 parseNormals(),
						 parseVertices(),
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
	private static LinkedList<Face> parseFaces() {
		LinkedList<Face> output = new LinkedList<Face>();
		System.out.println("parsing face data...");	
		
		readhead = InputHandler.input.indexOf("faces") + 9;
		int matPtr = InputHandler.input.indexOf("materials") - 4;
		
		//System.out.println("readhead: " + readhead);
		//System.out.println("matPtr: " + matPtr);
		
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
	 * readhead, and call the appropriate helper method.
	 * @return
	 */
	private static Face parseSingleFace() {
		int[] vertIndices = null;
		
		if(facetype.equals("43") || facetype.equals("11")) 
			vertIndices = parseQuad();
		else if(facetype.equals("42") || facetype.equals("10"))
			vertIndices = parseTri();
		
		return new Face(vertIndices);
	}
	
	/**
	 * Extract a single Quad's vertex indices. 
	 * Helper method for parseFaces().
	 * @return
	 */
	private static int[] parseQuad() {
		int[] output = new int[4];
		output[0] = parseInt();
		output[1] = parseInt();
		output[2] = parseInt();
		output[3] = parseInt();
		
		if(facetype.equals("43")) readhead += 9;
		else if(facetype.equals("11")) readhead += 5;
	
		return output;
	}
	
	/**
	 * Extract a single Tri's vertex indices. 
	 * Helper method for parseFaces().
	 * @return
	 */
	private static int[] parseTri() {
		int[] output = new int[3];
		output[0] = parseInt();
		output[1] = parseInt();
		output[2] = parseInt();

		if(facetype.equals("42")) readhead += 7;
		else if(facetype.equals("10")) readhead += 4;
		
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
	private static LinkedList<Point3D> parseNormals() {
		LinkedList<Point3D> output = new LinkedList<Point3D>();
		System.out.println("parsing normals...");
		
		// normal data is stored in the faces data, so we don't
		// need to reload the data[] from input
		
		
		
		return output;
	}
	
	
	private static LinkedList<Point3D> parseVertices() {
		LinkedList<Point3D> output = new LinkedList<Point3D>();
		System.out.println("parsing vert data...");
		
		
		return output;
	}
	
	private static LinkedList<Point2D> parseUVs() {
		LinkedList<Point2D> output = new LinkedList<Point2D>();
		System.out.println("parsing uvs...");
		
		return output;
	}
	
	private static int parseInt() {
		return Integer.parseInt(data[readhead++]);
	} 
	
	private static Point3D parsePoint3D() {
		Point3D output = new Point3D(0f, 0f, 0f);
		
		return output;
	}
	
	private static Point2D parsePoint2D() {
		Point2D output = new Point2D(0f, 0f);
		
		return output;
	}
	
	private static LinkedList<Material> parseMaterials() {
		LinkedList<Material> output = new LinkedList<Material>();
		System.out.println("parsing materials...");
			
		
		return output;
	}
}
