package Project_2_Trees_on_NYC_Streets;

import java.util.ArrayList;

public class TreeList extends ArrayList<Tree>{
	
	/**
	 * Default constructor 
	 * @param no param 
	 * @return an empty list for tree objects 
	 */
	public TreeList(){
		//TreeList treeList = new TreeList();
		//ArrayList<Tree> treeList = new ArrayList<Tree>();
	}
	
	/**
	 * Returns total number of Tree objects in the list 
	 * @param no param 
	 * @return integer, total number of tree objects  
	 */
	public int getTotalNumberofTrees(){
		int totalNumTree = this.size();
		return totalNumTree;
	}

	/**
	 * Get number of tree objects based on species name 
	 * @param String, the species name 
	 * @return integer, total number of trees with that species name
	 */
	public int getCountByTreeSpecies(String speciesName){
		int speciesCount = 0;
		for (int i=0;i<this.size();i++){
			if (this.get(i).getSpecies().toLowerCase().contains(speciesName.toLowerCase())){
				speciesCount+=1;
			}
		}
		return speciesCount;
	}
	
	/**
	 * Get number of trees by borough name 
	 * @param String, borough name
	 * @return integer, total number of trees in that borough 
	 */
	public int getCountByBorough(String boroName){
		int boroCount = 0;
		for (int i=0; i<this.size();i++){
			if(this.get(i).getBoro().equalsIgnoreCase(boroName)){
				boroCount+=1;
			}
		}
		return boroCount;
	}
	
	/**
	 * Gets number of trees within a specified borough
	 * @param String, species name
	 * @param String, borough name
	 * @return integer, total number of trees  
	 */
	public int getCountByTreeSpeciesBorough(String speciesName, String boroName){
		int speciesBoroCount = 0; 
		for (int i =0; i<this.size();i++){
			if(this.get(i).getSpecies().toLowerCase().contains(speciesName.toLowerCase())&&this.get(i).getBoro().equalsIgnoreCase(boroName)){
				speciesBoroCount+=1;
			}
		}
		return speciesBoroCount;
	}
	
	/**
	 * Returns a list of species 
	 * @param String, species name 
	 * @return an arraylist of string representation of the trees 
	 */
	public ArrayList<String> getMatchingSpecies(String speciesName){
		ArrayList<String> matchList = new ArrayList<String>();
		for (int i =0;i<this.size();i++){
			String thisSpc = this.get(i).getSpecies();
			String thisSpcLower = thisSpc.toLowerCase();
			
			if (thisSpcLower.contains(speciesName.toLowerCase())){
				if (!(matchList.contains(thisSpc))){
					matchList.add(thisSpc);
				}
			}
		}
		return matchList;
	}
	
	@Override 
	/**
	 * Overrides toString method  
	 * @return String, object representation 
	 */
	public String toString(){
		String allTrees = "";
		for (int i=0; i<this.size();i++){
			allTrees+=this.get(i).toString();
		}
		return allTrees;
	}
}
