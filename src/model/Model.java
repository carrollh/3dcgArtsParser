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
	
	LinkedList<IndexSet> faces;
	LinkedList<IndexSet> normalIndices;
	LinkedList<Point3D> vertices;
	LinkedList<Point3D> normals;
	LinkedList<Point2D> uvs;
	LinkedList<Material> materials;
	
	public LinkedList<IndexSet> getFaces() {
		return faces;
	}

	public LinkedList<IndexSet> getNormalIndices() {
		return normalIndices;
	}

	public LinkedList<Point3D> getVertices() {
		return vertices;
	}

	public LinkedList<Point3D> getNormals() {
		return normals;
	}

	public LinkedList<Point2D> getUVs() {
		return uvs;
	}

	public LinkedList<Material> getMaterials() {
		return materials;
	}

	public Model(LinkedList<IndexSet> faces,
				 LinkedList<IndexSet> normalIndices,
				 LinkedList<Point3D> vertices, 
				 LinkedList<Point3D> normals,
				 LinkedList<Point2D> uvs,
				 LinkedList<Material> materials) {
		
		this.faces = faces;
		this.normalIndices = normalIndices;
		this.vertices = vertices;
		this.normals = normals;
		this.uvs = uvs;
		this.materials = materials;
	}
}
