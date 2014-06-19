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
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

import model.*;

public class OutputHandler implements IFileIO {
	
	private static PrintWriter file;
	private static String output = "";
	public static Model model = null;
	public static Material mtl = null;
	
	@Override
	public void openFile(String filepath) throws FileNotFoundException {
		file = new PrintWriter(filepath);
	}

	@Override
	public void closeFileStream() {
		file.close();
	}

	public static void exportOBJ() {
		System.out.println("Exporting obj file...");
		
		//int extIndex = material.getName().lastIndexOf(".");
		String materialName = "Material";
		//materialName = "o " + material.getName().substring(0,extIndex) + "\n";
		
		file.print("mtllib " + materialName + "\n");
		
		file.print(gatherVertexData());
		file.print(gatherUVData());
		file.print("usemtl " + materialName + "\ns off \n");
		file.print(gatherFaceTextureNormalData());
	}

	private static String gatherVertexData() {
		String output = "";
		LinkedList<Point3D> verts = model.getVertices();
		
		for(int i = 0; i < verts.size(); i++) {
			output += "v " + verts.get(i) + "\n"; 
		}
		
		return output;
	}
	
	private static String gatherUVData() {
		output = "";
		
		LinkedList<Point2D> uvs = model.getUVs();
		
		for(int i = 0; i < uvs.size(); i++) {
			output += "vt " + uvs.get(i) + "\n"; 
		}
		
		return output;
	}
	
	private static String gatherFaceTextureNormalData() {
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
	
	public static void exportMTL() {
		System.out.println("Exporting mtl file...");
		
		int extIndex = mtl.getName().lastIndexOf(".");
		String materialName = mtl.getName().substring(0, extIndex); //= "Material";
		
		System.out.println("newmtl " + materialName);
		System.out.println("Ns " + mtl.getNs());
		System.out.println("Ka " + mtl.getKa());
		System.out.println("Kd " + mtl.getKd());
		System.out.println("Ks " + mtl.getKs());
		System.out.println("Ni " + mtl.getNi());
		System.out.println("d " + mtl.getD());
		System.out.println("illum " + mtl.getIllum());
		System.out.println("map_Kd " + mtl.getMap_Kd());
	}
}
