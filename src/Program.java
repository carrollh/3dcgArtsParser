/** Program.java
 * 
 * Entry point class for the file parser.
 * 
 * @author Heath Carroll
 */

import java.io.FileNotFoundException;
import java.io.IOException;

import fileIO.*;
import model.Model;

public class Program {
	public static void main(String[] args) {
		
		InputHandler inputHandler = new InputHandler();
		
		try {
			
			inputHandler.openFile("http://www.3dcg-arts.net/api/model/get/three_format/450");
			//inputHandler.openFile("usc.htm");
			inputHandler.parse3dcgFile();
			inputHandler.closeFileStream();
			
			if(OutputHandler.model != null) {
				OutputHandler outputHandler = new OutputHandler();
				outputHandler.openFile("out.obj");
				
				OutputHandler.exportOBJ();
				if(OutputHandler.mtl != null) {
					//OutputHandler.exportMTL();
				}
				
				outputHandler.closeFileStream();
			}
			else {
				System.out.println("Error processing file.");
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
