/** OutputHandler.java
 * 
 * Abstract class used to generate model files
 * from supplied Model instances. 
 * 
 * @author Heath Carroll
 * 
 */

package fileIO;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

import model.*;

public abstract class OutputHandler implements IFileIO {
	
	private static Scanner fileScanner;
	private static String output = "";
	
	@Override
	public void openFile(String filepath) throws FileNotFoundException {
		fileScanner = new Scanner(filepath);
	}

	@Override
	public void closeFileStream() {
		fileScanner.close();
	}

	public static void exportOBJ(Model model) {
		System.out.println("Exporting to files...");
		
		//int extIndex = material.getName().lastIndexOf(".");
		String materialName = "Material";
		//materialName = "o " + material.getName().substring(0,extIndex) + "\n";
		
		System.out.print("mtllib <materialName + .mtl>\n");
		
		System.out.print(gatherVertexData(model));
		System.out.print(gatherUVData(model));
		System.out.print("usemtl " + materialName + "\ns off \n");
		System.out.print(gatherFaceTextureNormalData(model));
	}

	private static String gatherVertexData(Model model) {
		String output = "";
		LinkedList<Point3D> verts = model.getVertices();
		
		for(int i = 0; i < verts.size(); i++) {
			output += "v " + verts.get(i) + "\n"; 
		}
		
		return output;
	}
	
	private static String gatherUVData(Model model) {
		output = "";
		
		LinkedList<Point2D> uvs = model.getUVs();
		
		for(int i = 0; i < uvs.size(); i++) {
			output += "vt " + uvs.get(i) + "\n"; 
		}
		
		return output;
	}
	
	private static String gatherFaceTextureNormalData(Model model) {
		output = "";
		LinkedList<IndexSet> faces = model.getFaces();
		LinkedList<IndexSet> normalSet = model.getNormalIndices();
		
		int[] faceIndices, normalIndices;
		
		for(int i = 0; i < faces.size(); i++) {
			faceIndices = faces.get(i).getIndices();
			normalIndices = normalSet.get(i).getIndices();
			
			output += "f ";
			for(int j = 0; j < faceIndices.length; j++) {
				output += (faceIndices[j] + 1) + "/" + (normalIndices[j] + 1) + " ";
			}
			output += "\n";
		}
		
		return output;
	}
}
