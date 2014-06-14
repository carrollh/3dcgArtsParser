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
import java.util.Scanner;

import model.Model;

public abstract class OutputHandler implements IFileIO {
	
	private static Scanner fileScanner;
	
	@Override
	public void openFile(String filepath) throws FileNotFoundException {
		
	}

	@Override
	public void closeFileStream() {
		
	}

	public static void exportOBJ(Model model) {
		
	}
	
}
