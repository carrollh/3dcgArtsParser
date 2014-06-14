/** Program.java
 * 
 * Entry point class for the file parser.
 * 
 * @author Heath Carroll
 */

import fileIO.*;
import model.Model;

public class Program {
	public static void main(String[] args) {
		
		Model model = InputHandler.parse3dcgFile("data");
		OutputHandler.exportOBJ(model);
	}
}
