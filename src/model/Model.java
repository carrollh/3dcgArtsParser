/** Model.java (with nested Material class for fun) 
 * 
 * Class to hold data required to export any static
 * model type. 
 * 
 * @author Heath Carroll
 */

package model;

import java.util.LinkedList;

public class Model {
	
	public LinkedList<Face> faces;
	LinkedList<Point3D> vertices;
	LinkedList<Point3D> normals;
	LinkedList<Point2D> uvs;
	LinkedList<Material> materials;
	
	public Model(LinkedList<Face> faces,
				 LinkedList<Point3D> normals,
				 LinkedList<Point3D> vertices, 
				 LinkedList<Point2D> uvs,
				 LinkedList<Material> materials) {
		
		this.faces = faces;
		this.normals = normals;
		this.vertices = vertices;
		this.uvs = uvs;
		this.materials = materials;
	}

	@Override
	public String toString() {
		String output = "";
		
		for(int i = 0; i < faces.size(); i++) {
			output += "f " + faces.get(i) + "\n";
		}
		
		return output;
	}
	
}
