package model;
import java.util.List;

public class Model_3dcg{
   	private List colors;
   	private List edges;
   	private List faces;
   	private List materials;
   	private List morphColors;
   	private List morphTargets;
   	private List normals;
   	private Number scale;
   	private List uvs;
   	private Number version;
   	private List vertices;

 	public List getColors(){
		return this.colors;
	}
	public void setColors(List colors){
		this.colors = colors;
	}
 	public List getEdges(){
		return this.edges;
	}
	public void setEdges(List edges){
		this.edges = edges;
	}
 	public List getFaces(){
		return this.faces;
	}
	public void setFaces(List faces){
		this.faces = faces;
	}
 	public List getMaterials(){
		return this.materials;
	}
	public void setMaterials(List materials){
		this.materials = materials;
	}
 	public List getMorphColors(){
		return this.morphColors;
	}
	public void setMorphColors(List morphColors){
		this.morphColors = morphColors;
	}
 	public List getMorphTargets(){
		return this.morphTargets;
	}
	public void setMorphTargets(List morphTargets){
		this.morphTargets = morphTargets;
	}
 	public List getNormals(){
		return this.normals;
	}
	public void setNormals(List normals){
		this.normals = normals;
	}
 	public Number getScale(){
		return this.scale;
	}
	public void setScale(Number scale){
		this.scale = scale;
	}
 	public List getUvs(){
		return this.uvs;
	}
	public void setUvs(List uvs){
		this.uvs = uvs;
	}
 	public Number getVersion(){
		return this.version;
	}
	public void setVersion(Number version){
		this.version = version;
	}
 	public List getVertices(){
		return this.vertices;
	}
	public void setVertices(List vertices){
		this.vertices = vertices;
	}
	@Override
	public String toString() {
		return "Model ["
				+ "colors" + "(" + colors.size() + ")" + "= " //+ colors + "\n" 
				+ "edges" + "(" + edges.size() + ")" + "= " //+ edges + "\n"  
				+ "faces" + "(" + faces.size() + ")" + "= " //+ faces + "\n"  
				+ "materials" + "(" + materials.size() + ")" + "=  " //+ materials + "\n" 
				+ "morphColors" + "(" + morphColors.size() + ")" + "= " //+ morphColors + "\n" 
				+ "morphTargets" + "(" + morphTargets.size() + ")" + "= " //+ morphTargets + "\n"  
				+ "normals" + "(" + normals.size() + ")" + "= " //+ normals + "\n"  
				+ "scale=" + scale + "\n" 
				+ "uvs" + "(" + uvs.size() + ")" + "=  " //+ uvs + "\n"  
				+ "version=" + version + "\n" 
				+ "vertices" + "(" + vertices.size() + ")" + "=  ";// + vertices + "]";
	}
	
	
}
