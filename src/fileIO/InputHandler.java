/** InputHandler.java
 * 
 * Abstract class used to parse model data from 
 * supplied data. 
 * 
 * @author Heath Carroll
 * 
 */

package fileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;


import model.*;

public class InputHandler implements IFileIO {
	
	//private static Scanner fileScanner;
	private static BufferedReader bufferedReader;
	private static int readhead = 0;
	private static String input = "";
	private static String[] data;
	private static String type;
	
	@Override
	public void openFile(String address) throws IOException {
		//URL url = new URL(address);
		//bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
		bufferedReader = new BufferedReader(new FileReader(address));
	}
	
	@Override
	public void closeFileStream() throws IOException {
		bufferedReader.close();
	}
	
	
	public Model parse3dcgFile() throws IOException {
		
		System.out.println("downloading...");
		
		boolean foundValidInput = false;
		while(!foundValidInput && input != null) {
			input = bufferedReader.readLine();
			
			int foundData = 0;
			
			if(input != null) foundData = input.indexOf("var m");
			
			if(foundData != -1) foundValidInput = true;
		}
		
		return new Model(parseFaces(),
						 parseVertices(),
						 parseNormals(),
						 parseUVs(),
						 parseMaterials());
	}
	
	private LinkedList<Face> parseFaces() {
		LinkedList<Face> output = new LinkedList<Face>();
		System.out.println("parsing face data...");	
		
		readhead = input.indexOf("faces") + 9;
		int matPtr = input.indexOf("materials") - 4;
		
		System.out.println("readhead: " + readhead);
		System.out.println("matPtr: " + matPtr);
		
		data = input.substring(readhead, matPtr).split(",");
		readhead = 0;

		LinkedList<Face> faces = new LinkedList<Face>();
		
		while(readhead < data.length) {
			output.add(parseSingleFace(data[readhead++]));
							
			if(data[readhead - 1].charAt(0) == '[') {
				// fix the first vert index in the next face list
				data[readhead - 1] = data[readhead - 1].substring(1);
			}
		}
		
		return output;
	}
	
	private Face parseSingleFace(String facetype) {
		int[] vertIndices = null;
		type = facetype;
		
		if(facetype.equals("43") || facetype.equals("11")) 
			vertIndices = parseQuad();
		else if(facetype.equals("42") || facetype.equals("10"))
			vertIndices = parseTri();
		
		return new Face(vertIndices);
	}
	
	private int[] parseQuad() {
		int[] output = new int[4];
		output[0] = parseInt();
		output[1] = parseInt();
		output[2] = parseInt();
		output[3] = parseInt();
		
		if(type.equals("43")) readhead += 9;
		else if(type.equals("11")) readhead += 5;
	
		return output;
	}
	
	private int[] parseTri() {
		int[] output = new int[3];
		output[0] = parseInt();
		output[1] = parseInt();
		output[2] = parseInt();

		if(type.equals("42")) readhead += 7;
		else if(type.equals("10")) readhead += 4;
		
		return output;
	}
	
	private LinkedList<Point3D> parseVertices() {
		LinkedList<Point3D> output = new LinkedList<Point3D>();
		System.out.println("parsing vert data...");
		
		
		return output;
	}
	
	private LinkedList<Point3D> parseNormals() {
		LinkedList<Point3D> output = new LinkedList<Point3D>();
		System.out.println("parsing normals...");
		
		
		return output;
	}
	
	private LinkedList<Point2D> parseUVs() {
		LinkedList<Point2D> output = new LinkedList<Point2D>();
		System.out.println("parsing uvs...");
		
		return output;
	}
	
	private int parseInt() {
		return Integer.parseInt(data[readhead++]);
	} 
	
	private Point3D parsePoint3D() {
		Point3D output = new Point3D(0f, 0f, 0f);
		
		return output;
	}
	
	private Point2D parsePoint2D() {
		Point2D output = new Point2D(0f, 0f);
		
		return output;
	}
	
	
	private LinkedList<Material> parseMaterials() {
		LinkedList<Material> output = new LinkedList<Material>();
		System.out.println("parsing materials...");
			
		
		return output;
	}
}
