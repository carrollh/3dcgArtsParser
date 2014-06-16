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

import model.*;

public class InputHandler implements IFileIO {
	
	//private static Scanner fileScanner;
	private static BufferedReader bufferedReader;
	public static String input = "";
	
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
			
			int foundData = 0; // place holder for String.indexOF() 
			
			if(input != null) foundData = input.indexOf("var m");
			
			if(foundData != -1) {
				System.out.println("Found a valid line of data in input stream");
				foundValidInput = true;
				return Parser.parseModel();
			}
		}
		
		System.out.println("Could not find any line containing the model data, aborting");
		
		return null;
	}
}
