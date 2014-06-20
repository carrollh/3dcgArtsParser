
package model;

import java.util.List;

public class Material_mqo extends Material {
   		
   	private List mapDiffuseWrap;
   	private Setting_mqo setting;
   	private String shading;


 	
 	public List getMapDiffuseWrap(){
		return this.mapDiffuseWrap;
	}
	public void setMapDiffuseWrap(List mapDiffuseWrap){
		this.mapDiffuseWrap = mapDiffuseWrap;
	}
 	public Setting_mqo getSetting(){
		return this.setting;
	}
	public void setSetting(Setting_mqo setting){
		this.setting = setting;
	}
 	public String getShading(){
		return this.shading;
	}
	public void setShading(String shading){
		this.shading = shading;
	}
 	
}
