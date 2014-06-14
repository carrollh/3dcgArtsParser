/** InputHandler.java
 * 
 * Abstract class used to parse model data from 
 * supplied data. 
 * 
 * @author Heath Carroll
 * 
 */

package fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Model;

public abstract class InputHandler implements IFileIO {
	
	private static Scanner fileScanner;
	
	@Override
	public void openFile(String filepath) throws FileNotFoundException {
		
	}
	
	@Override
	public void closeFileStream() {
		
	}
	
	
	public static Model parse3dcgFile(String filepath) {
		Model output = new Model();
		
		
		return output;
	}
	
}
