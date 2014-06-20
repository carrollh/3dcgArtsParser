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
	public static ModelOLD model = null;
	public static MaterialOLD mtl = null;
	
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
		//String materialName = "Material";
		//materialName = "o " + material.getName().substring(0,extIndex) + "\n";
		
		file.print("mtllib material.mtl \n");
		
		file.print(gatherVertexData());
		file.print(gatherUVData());
		file.print("usemtl material \ns off \n");
		file.print(gatherFaceTextureNormalData());
		
		System.out.println("obj file exported successfully.");
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
			output += "vt " + (1.0f - uvs.get(i).getU()) + " " 
							+ (1.0f - uvs.get(i).getV()) + "\n"; 
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
		
		//int extIndex = mtl.getName().lastIndexOf(".");
		String materialName = "material\n";//mtl.getName().substring(0, extIndex); //= "Material";
		
		file.println("newmtl " + materialName);
		file.println("Ns " + mtl.getNs());
		file.println("Ka " + mtl.getKa());
		file.println("Kd " + mtl.getKd());
		file.println("Ks " + mtl.getKs());
		file.println("Ni " + mtl.getNi());
		file.println("d " + mtl.getD());
		file.println("illum " + mtl.getIllum());
		file.println("map_Kd " + mtl.getMap_Kd());
		
		System.out.println("mtl file exported successfully.");
	}
}
