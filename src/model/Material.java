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

package model;

public class Material {
	private String name = "";
	private float ns;
	private Point3D ka;
	private Point3D kd;
	private Point3D ks;
	private float ni;
	private float d;
	private byte illum;
	private String map_Kd;
	public String getName() {
		return name;
	}
	public float getNs() {
		return ns;
	}
	public Point3D getKa() {
		return ka;
	}
	public Point3D getKd() {
		return kd;
	}
	public Point3D getKs() {
		return ks;
	}
	public float getNi() {
		return ni;
	}
	public float getD() {
		return d;
	}
	public byte getIllum() {
		return illum;
	}
	public String getMap_Kd() {
		return map_Kd;
	}
	
	public Material(String name, float ns, Point3D ka, Point3D kd, Point3D ks,
					float ni, float d, byte illum, String map_Kd) {
		this.name = name;
		this.ns = ns;
		this.ka = ka;
		this.kd = kd;
		this.ks = ks;
		this.ni = ni;
		this.d = d;
		this.illum = illum;
		this.map_Kd = map_Kd;
	}
}