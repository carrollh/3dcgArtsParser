/** IFileIO.java
 * 
 * Interface used for enforcing the required methods
 * for handling file streams.
 * 
 * @author Heath Carroll
 * 
 */

package fileIO;

import java.io.IOException;

public interface IFileIO {

	// Enforce the other programmers to catch this exception
	public abstract void openFile(String filepath) throws IOException;
	// Make sure the other programmers to close their data streams. 
	public abstract void closeFileStream() throws IOException;
}
