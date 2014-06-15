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
	
	public LinkedList<Face> facesList;
	LinkedList<Point3D> vertices;
	LinkedList<Point3D> normals;
	LinkedList<Point2D> uvs;
	LinkedList<Material> materials;
	
	public Model(LinkedList<Face> facesList,
				 LinkedList<Point3D> vertices,
				 LinkedList<Point3D> normals,
				 LinkedList<Point2D> uvs,
				 LinkedList<Material> materials) {
		
		this.facesList = facesList;
		this.vertices = vertices;
		this.normals = normals;
		this.uvs = uvs;
		this.materials = materials;

	}
	
}
