/** Program.java
 * 
 * Entry point class for the file parser.
 * 
 * @author Heath Carroll
 */

import java.io.FileNotFoundException;
import java.io.IOException;

import fileIO.*;
import model.ModelOLD;

public class Program {
	public static void main(String[] args) {
		
		// Open the stream catch some exceptions
		
		
		
		
		
		
		
		InputHandler inputHandler = new InputHandler();
		
		try {
			
			//inputHandler.openFile("http://www.3dcg-arts.net/api/model/get/three_format/");
			inputHandler.openFile("cube.htm");
			inputHandler.parse3dcgFile();
			inputHandler.closeFileStream();
			
			if(OutputHandler.model != null) {
				OutputHandler outputHandler = new OutputHandler();
				outputHandler.openFile("out.obj");
				OutputHandler.exportOBJ();
				outputHandler.closeFileStream();
				
				if(OutputHandler.mtl != null) {
					outputHandler.openFile("out.mtl");
					OutputHandler.exportMTL();
					outputHandler.closeFileStream();
					
					//outputHandler.openFile(OutputHandler.mtl.getMap_Kd());
					
					
				}
				else System.out.println("mtl data is null");
				
				outputHandler.closeFileStream();
			}
			else {
				System.out.println("Error processing file. Please verify a model exists at this location.");
			}
		}
		catch (IOException e) {
			System.out.println("Error opening stream. Please check your internet connection.");
			e.printStackTrace();
		}
	}
}
