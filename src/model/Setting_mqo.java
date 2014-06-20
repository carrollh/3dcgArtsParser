
package model;

import java.util.List;

public class Setting_mqo {
   	private Number mqoDiffuseCoef;
   	private Number mqoEmissive;
   	private String mqoMapAlpha;
   	private String mqoMapBump;
   	private Number mqoShader;

 	public Number getMqoDiffuseCoef(){
		return this.mqoDiffuseCoef;
	}
	public void setMqoDiffuseCoef(Number mqoDiffuseCoef){
		this.mqoDiffuseCoef = mqoDiffuseCoef;
	}
 	public Number getMqoEmissive(){
		return this.mqoEmissive;
	}
	public void setMqoEmissive(Number mqoEmissive){
		this.mqoEmissive = mqoEmissive;
	}
 	public String getMqoMapAlpha(){
		return this.mqoMapAlpha;
	}
	public void setMqoMapAlpha(String mqoMapAlpha){
		this.mqoMapAlpha = mqoMapAlpha;
	}
 	public String getMqoMapBump(){
		return this.mqoMapBump;
	}
	public void setMqoMapBump(String mqoMapBump){
		this.mqoMapBump = mqoMapBump;
	}
 	public Number getMqoShader(){
		return this.mqoShader;
	}
	public void setMqoShader(Number mqoShader){
		this.mqoShader = mqoShader;
	}
}
