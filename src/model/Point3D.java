/** Point3D.java
 * 
 * Basically a simplified Vector3 class.
 * 
 * @author Heath Carroll
 * 
 */

package model;

public class Point3D extends Point2D {

	private float z;
	
	protected float getX() { return getU(); }
	protected float getY() { return getV(); }
	protected float getZ() { return z; }
	
	public Point3D(float x, float y, float z) 
	{
		super(x, y);
		this.z = z;
	}
	
	@Override
	public String toString() {
		return getX() + " " + getY() + " "+ z;
	}
}
