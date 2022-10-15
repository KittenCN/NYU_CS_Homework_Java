package Project_2_Trees_on_NYC_Streets;

public class Tree implements Comparable<Tree> {
	
	//All data fields for the tree 
	private int TREE_ID;
	private int TREE_DBH;
	private String STATUS;
	private String HEALTH;
	private String SPC_COMMON;
	private int ZIPCODE;
	private String BORONAME;
	private double X_SP;
	private double Y_SP;

	/**
	 * Tree constructor; creates a tree object
	 * @param id, diam, status, health, spc, zip, boro, x and y
	 */
	public Tree (int id, int diam, String status, String health, String spc, int zip, String boro, double x, double y){
		this.setTreeID(id);
		this.setTreeDBH(diam);
		this.setStatus(status);
		this.setHealth(health);
		this.setSpecies(spc);
		this.setZIP(zip);
		this.setBoro(boro);
		this.setX(x);
		this.setY(y);
	}
	
	/**
	 * Setter for tree ID 
	 * @param integer for ID 
	 */
	public void setTreeID (int id) throws IllegalArgumentException{
		if (id<0){
			throw new IllegalArgumentException("Invalid tree ID");
		}
		else{
			this.TREE_ID = id; 
		}
	}
	
	/**
	 * Getter for tree ID
	 * @return integer, tree ID 
	 */
	public int getTreeID(){
		return this.TREE_ID;
	}
	
	/**
	 * Setter for tree diameter  
	 * @param integer for tree diameter
	 */
	public void setTreeDBH(int diam) throws IllegalArgumentException{
		if (diam<0){
			throw new IllegalArgumentException("Invalid tree diameter");
		}
		else{
			this.TREE_DBH = diam;
		}
	}
	
	/**
	 * Getter for tree diameter 
	 * @return integer for tree diameter 
	 */
	public int getTreeDBH(){
		return this.TREE_DBH;
	}
	
	/**
	 * Setter for tree status
	 * Takes null as a status 
	 * @param string for tree status 
	 */
	public void setStatus(String status) throws IllegalArgumentException{
		if(status==null){
			this.STATUS=null;
		}
		else if (status.equalsIgnoreCase("Alive")||status.equalsIgnoreCase("Dead")||status.equalsIgnoreCase("Stump")||status.equals("")){
			this.STATUS = status;
		}
		else{
			throw new IllegalArgumentException("Tree status unidentified");
		}
	}
	
	/**
	 * Getter for tree status 
	 * @return String for tree status 
	 */
	public String getStatus(){
		return this.STATUS;
	}
	
	/**
	 * Setter for tree health
	 * Takes null as a parameter 
	 * @param string for tree health status 
	 */
	public void setHealth (String health) throws IllegalArgumentException{
		if(health==null){
			this.HEALTH = null;
		}
		else if (health.equalsIgnoreCase("Good")||health.equalsIgnoreCase("Fair")||health.equalsIgnoreCase("Poor")||health.equals("")){
			this.HEALTH = health;
		}
		else{
			throw new IllegalArgumentException("Tree health unidentified");
		}
	}
	
	/**
	 * Getter for tree health 
	 * @return String for tree health 
	 */
	public String getHealth(){
		return this.HEALTH;
	}
	
	/**
	 * Setter for tree common species 
	 * @param String of species name; can be empty string, but cannot be null 
	 */
	public void setSpecies(String spc_common) throws IllegalArgumentException{
		if (spc_common == null){
			throw new IllegalArgumentException("Species cannot be null");
		}
	}
	
	/**
	 * Getter for tree common species 
	 * @return String for tree species 
	 */
	public String getSpecies(){
		return this.SPC_COMMON;
	}
	
	/**
	 * Setter for zipcode 
	 * @param 5 digit integer for zipcode 
	 */
	public void setZIP(int zip) throws IllegalArgumentException{
		if (zip<0 ||zip>99999){
			throw new IllegalArgumentException("Invalid zipcode, tree not registered");
		}
		else{
			this.ZIPCODE = zip;
		}
	}
	
	/**
	 * Getter for zipcode 
	 * @return integers, zipcode of tree 
	 */
	public int getZIP(){
		return this.ZIPCODE;
	}
	
	/**
	 * Setter for borough
	 * @param String for borough name
	 */
	public void setBoro (String boroname) throws IllegalArgumentException{
		if (boroname.equalsIgnoreCase("Manhattan")||boroname.equalsIgnoreCase("Bronx")||boroname.equalsIgnoreCase("Brooklyn")||boroname.equalsIgnoreCase("Queens")||boroname.equalsIgnoreCase("Staten Island")){
			this.BORONAME = boroname;
		}
		else{
			throw new IllegalArgumentException("Invalid borough name");
		}
	}
	
	/**
	 * Getter for borough 
	 * @return String for tree borough 
	 */
	public String getBoro(){
		return this.BORONAME;
	}
	
	/**
	 * Setter for x  
	 * @param double for x 
	 */
	public void setX(double x){
		this.X_SP = x;
	}
	
	/**
	 * Getter for x 
	 * @return double, x value 
	 */
	public double getX(){
		return this.X_SP;
	}
	
	/**
	 * Setter for y 
	 * @param double for y 
	 */
	public void setY(double y){
		this.Y_SP = y;
	}
	
	/**
	 * Getter for y 
	 * @return double, y value 
	 */
	public double getY(){
		return this.Y_SP;
	}
	
	@Override
	/**
	 * Equal method to see if the 2 trees are the same 
	 * @param a tree object  
	 * @return boolean if the trees are the same/equal each other
	 */
	public boolean equals(Object t) throws IllegalArgumentException {
		Tree tree = (Tree) t;
		if (tree.getClass()!=this.getClass()){
			return false;
		}
		else if (tree.TREE_ID!=this.TREE_ID||!(tree.SPC_COMMON.equalsIgnoreCase(this.SPC_COMMON))){
			return false;
		}
		else if (tree.TREE_ID==this.TREE_ID&&!(tree.SPC_COMMON.equalsIgnoreCase(this.SPC_COMMON))){
			throw new IllegalArgumentException("Invalid comparison");
		}
		else{
			return true;
		}
	}
	
	@Override
	/**
	 * Comparable method 
	 * @param another tree object 
	 * @return integer 
	 */
	public int compareTo(Tree anotherTree){
		if (!(anotherTree.SPC_COMMON.equalsIgnoreCase(this.SPC_COMMON))){
				return (anotherTree.SPC_COMMON).compareTo(this.SPC_COMMON);
			}
		else if (anotherTree.SPC_COMMON.equalsIgnoreCase(this.SPC_COMMON)){
			if (this.TREE_ID < anotherTree.TREE_ID){
				return 1;
			}
			else if(this.TREE_ID > anotherTree.TREE_ID){
				return -1;
			}
		}
		return 0;
	}
	
	@Override
	/**
	 * Overrides Java's toString method; representation of the object
	 * @return String object that represents the object 
	 */
	public String toString(){
		String treeObj = ("Tree ID: " + this.TREE_ID + "/nSpecies: " + this.SPC_COMMON + "/nZipcode: " + String.format("%05d", this.ZIPCODE) + "/nBorough: " + this.BORONAME);
		return treeObj;
	}
	
}
