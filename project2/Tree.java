package project2;

public class Tree implements Comparable<Tree> {
	private int tree_id;
	private String status;
	private String health;
	private String spc_latin;
	private String spc_common;
	private int zipcode;
	private String boroname;
	private double x_sp;
	private double y_sp;

	public Tree(int treeID, TreeSpecies species){
		this.setTreeID(treeID);
		this.setSpc_latin(species.getLatinName());
		this.setSpc_common(species.getCommonName());
	}

	public Tree (int tree_id, String status, String health, String spc_latin, String spc_common, int Zipcode, String boroname, double x_sp, double y_sp){
		this.setTreeID(tree_id);
		this.setStatus(status);
		this.setHealth(health);
		this.setSpc_latin(spc_latin);
		this.setSpc_common(spc_common);
		this.setZipcode(Zipcode);
		this.setBoroname(boroname);
		this.setX_sp(x_sp);
		this.setY_sp(y_sp);
	}
	public void setTreeID (int tree_id) throws IllegalArgumentException{
		if (tree_id<0){
			throw new IllegalArgumentException("Invalid tree tree_id");
		}
		else{
			this.tree_id = tree_id; 
		}
	}
	public int getTreeID(){
		return this.tree_id;
	}
	public void setSpc_latin(String spc_latin) throws IllegalArgumentException{
		if(spc_latin==null){
			throw new IllegalArgumentException("Spc_latin cannot be null");
		}
	}
	public String getSpc_latin(){
		return this.spc_latin;
	}
	public void setStatus(String status) throws IllegalArgumentException{
		if(status==null){
			this.status=null;
		}
		else if (status.equalsIgnoreCase("Alive")||status.equalsIgnoreCase("Dead")||status.equalsIgnoreCase("Stump")||status.equals("")){
			this.status = status;
		}
		else{
			throw new IllegalArgumentException("Tree status unidentified");
		}
	}
	public String getStatus(){
		return this.status;
	}
	public void setHealth (String health) throws IllegalArgumentException{
		if(health==null){
			this.health = null;
		}
		else if (health.equalsIgnoreCase("Good")||health.equalsIgnoreCase("Fair")||health.equalsIgnoreCase("Poor")||health.equals("")){
			this.health = health;
		}
		else{
			throw new IllegalArgumentException("Tree health unidentified");
		}
	}
	public String getHealth(){
		return this.health;
	}
	public void setSpc_common(String spc_common) throws IllegalArgumentException{
		if (spc_common == null){
			throw new IllegalArgumentException("Spc_common cannot be null");
		}
	}
	public String getSpc_common(){
		return this.spc_common;
	}
	public void setZipcode(int Zipcode) throws IllegalArgumentException{
		if (Zipcode<0 ||Zipcode>99999){
			throw new IllegalArgumentException("Invalid zipcode, tree not registered");
		}
		else{
			this.zipcode = Zipcode;
		}
	}
	public int getZipcode(){
		return this.zipcode;
	}
	public void setBoroname (String boroname) throws IllegalArgumentException{
		if (boroname.equalsIgnoreCase("Manhattan")||boroname.equalsIgnoreCase("Bronx")||boroname.equalsIgnoreCase("Brooklyn")||boroname.equalsIgnoreCase("Queens")||boroname.equalsIgnoreCase("Staten Island")){
			this.boroname = boroname;
		}
		else{
			throw new IllegalArgumentException("Invalid borough name");
		}
	}
	public String getBoroname(){
		return this.boroname;
	}
	public void setX_sp(double x_sp){
		this.x_sp = x_sp;
	}
	public double getX_sp(){
		return this.x_sp;
	}
	public void setY_sp(double y_sp){
		this.y_sp = y_sp;
	}
	public double getY_sp(){
		return this.y_sp;
	}

	@Override
	public boolean equals(Object obj) throws IllegalArgumentException {
		Tree tree = (Tree) obj;
		if (tree.getClass()!=this.getClass()){
			return false;
		}
		else if (tree.tree_id!=this.tree_id||!(tree.spc_common.equalsIgnoreCase(this.spc_common))||!(tree.spc_latin.equalsIgnoreCase(this.spc_latin))){
			return false;
		}
		else{
			return true;
		}
	}
	
	@Override
	public int compareTo(Tree tree){
		if (!(tree.spc_common.equalsIgnoreCase(this.spc_common))){
				return (tree.spc_common).compareTo(this.spc_common);
			}
		else if (tree.spc_common.equalsIgnoreCase(this.spc_common)){
			if (this.tree_id < tree.tree_id){
				return 1;
			}
			else if(this.tree_id > tree.tree_id){
				return -1;
			}
		}
		return 0;
	}
	
	@Override
	public String toString(){
		return "Tree tree_id: " + this.tree_id + "/nSpecies: " + this.spc_common + "/nZipcode: " + String.format("%05d", this.zipcode) + "/nBorough: " + this.boroname;
	}
	
}
