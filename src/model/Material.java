package model;

import java.util.List;

public class Material {
	private List colorAmbient;
   	private List colorDiffuse;
   	private List colorSpecular;
   	private String mapDiffuse;
   	private Number specularCoef;
   	private Number transparency;
   	
   	public List getColorAmbient(){
		return this.colorAmbient;
	}
	public void setColorAmbient(List colorAmbient){
		this.colorAmbient = colorAmbient;
	}
 	public List getColorDiffuse(){
		return this.colorDiffuse;
	}
	public void setColorDiffuse(List colorDiffuse){
		this.colorDiffuse = colorDiffuse;
	}
 	public List getColorSpecular(){
		return this.colorSpecular;
	}
	public void setColorSpecular(List colorSpecular){
		this.colorSpecular = colorSpecular;
	}
 	public String getMapDiffuse(){
		return this.mapDiffuse;
	}
	public void setMapDiffuse(String mapDiffuse){
		this.mapDiffuse = mapDiffuse;
	}
	public Number getSpecularCoef(){
		return this.specularCoef;
	}
	public void setSpecularCoef(Number specularCoef){
		this.specularCoef = specularCoef;
	}
 	public Number getTransparency(){
		return this.transparency;
	}
	public void setTransparency(Number transparency){
		this.transparency = transparency;
	}
}
