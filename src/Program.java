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
			
			//inputHandler.openFile("http://www.3dcg-arts.net/api/model/get/three_format/5696 or 2827");
			inputHandler.openFile("usc.htm");
			Model model = inputHandler.parse3dcgFile();
			inputHandler.closeFileStream();
			
			OutputHandler.exportOBJ(model);
		
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
