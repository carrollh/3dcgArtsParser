package model;
import java.util.List;

public class Material_obj extends Material {
   	private Number dbgColor;
   	private Number dbgIndex;
   	private String dbgName;
   	private Number opticalDensity;
   
 	public Number getDbgColor(){
		return this.dbgColor;
	}
	public void setDbgColor(Number dbgColor){
		this.dbgColor = dbgColor;
	}
 	public Number getDbgIndex(){
		return this.dbgIndex;
	}
	public void setDbgIndex(Number dbgIndex){
		this.dbgIndex = dbgIndex;
	}
 	public String getDbgName(){
		return this.dbgName;
	}
	public void setDbgName(String dbgName){
		this.dbgName = dbgName;
	}
 	public Number getOpticalDensity(){
		return this.opticalDensity;
	}
	public void setOpticalDensity(Number opticalDensity){
		this.opticalDensity = opticalDensity;
	}
}
