/** Model.java (with nested Material class for fun) 
 * 
 * Class to hold data required to export any static
 * model type. 
 * 
 * @author Heath Carroll
 */

package model;

import java.util.List;

public class Model {
	
	List<Mesh> meshes;
	List<Material> materials;
	
	/** Material
	 * 
	 * Struct-like class to hold all material 
	 * attributes for a mesh. Things like the 
	 * specularity, ambient light, and texture maps 
	 * to use are stored in here.
	 * 
	 * @author carrollh
	 *
	 */
	class Material {
		
	};
	
}
