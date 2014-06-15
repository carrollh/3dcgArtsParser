/** Point2D.java
 * 
 * Basically a simplified Vector2 class.
 * 
 * @author Heath Carroll
 * 
 */

package model;

public class Point2D {
	private float u;
	private float v;
	
	protected float getU() { return u; }
	protected float getV() { return v; }
	
	public Point2D(float u, float v) 
	{
		this.u = u;
		this.v = v;
	}
}
