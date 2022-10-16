package project2;

import java.util.ArrayList;

public class TreeList{
	class Node{
		Tree tree;
		Node left;
		Node right;
		public Node(Tree tree){
			this.tree = tree;
			this.left = null;
			this.right = null;
		}
	}
	Node root;
	ArrayList<Node> nodes;
	public TreeList(){
		this.root = null;
		this.nodes = new ArrayList<Node>();
	}
	public void add(Tree tree){
		Node node = new Node(tree);
		if (this.root==null){
			this.root = node;
			this.nodes.add(node);
		}
		else{
			Node current = this.root;
			while(true){
				if (node.tree.getTreeID()<current.tree.getTreeID()){
					if (current.left==null){
						current.left = node;
						this.nodes.add(node);
						break;
					}
					else{
						current = current.left;
					}
				}
				else{
					if (current.right==null){
						current.right = node;
						this.nodes.add(node);
						break;
					}
					else{
						current = current.right;
					}
				}
			}
		}
	}
	public int getTotalNumberOfTrees(){
		return this.nodes.size();
	}
	public int getCountByCommonName(String SpeciesName){
		int count = 0;
		for (int i=0; i<this.nodes.size();i++){
			if(this.nodes.get(i).tree.getSpc_common().toLowerCase().contains(SpeciesName.toLowerCase())){
				count++;
			}
		}
		return count;
	}
	public int getCountByLatinName(String SpeciesName){
		int count = 0;
		for (int i=0; i<this.nodes.size();i++){
			if(this.nodes.get(i).tree.getSpc_latin().toLowerCase().contains(SpeciesName.toLowerCase())){
				count++;
			}
		}
		return count;
	}
	public int getCountByBorough(String BoroughName){
		int count = 0;
		for (int i=0; i<this.nodes.size();i++){
			if (this.nodes.get(i).tree.getBoroname().toLowerCase().equalsIgnoreCase(BoroughName.toLowerCase())){
				count++;
			}
		}
		return count;
	}
	public int getCountByCommonNameBorough(String SpeciesName, String BoroughName){
		int count = 0;
		for (int i=0; i<this.nodes.size();i++){
			if(this.nodes.get(i).tree.getSpc_common().toLowerCase().contains(SpeciesName.toLowerCase()) && this.nodes.get(i).tree.getBoroname().toLowerCase().equalsIgnoreCase(BoroughName.toLowerCase())){
				count++;
			}
		}
		return count;
	}
	public int getCountByLatinNameBorough(String SpeciesName, String BoroughName){
		int count = 0;
		for (int i=0; i<this.nodes.size();i++){
			if(this.nodes.get(i).tree.getSpc_latin().toLowerCase().contains(SpeciesName.toLowerCase()) && this.nodes.get(i).tree.getBoroname().toLowerCase().equalsIgnoreCase(BoroughName.toLowerCase())){
				count++;
			}
		}
		return count;
	}
	public ArrayList<String> getMatchingCommon(String commonName){
		ArrayList<String> matchList = new ArrayList<String>();
		for (int i =0;i<this.nodes.size();i++){
			String thisSpc = this.nodes.get(i).tree.getSpc_common();
			if(thisSpc != null){
				String thisSpcLower = thisSpc.toLowerCase();
				if (thisSpcLower.contains(commonName.toLowerCase())){
					if (!(matchList.contains(thisSpc))){
						matchList.add(thisSpc);
					}
				}
			}
		}
		if(matchList.size()==0){
			return null;
		}
		else{
			return matchList;
		}
	}
	public ArrayList<String> getMatchingLatin(String latinName){
		ArrayList<String> matchList = new ArrayList<String>();
		for (int i =0;i<this.nodes.size();i++){
			String thisSpc = this.nodes.get(i).tree.getSpc_latin();
			if(thisSpc != null){
				String thisSpcLower = thisSpc.toLowerCase();
				if (thisSpcLower.contains(latinName.toLowerCase())){
					if (!(matchList.contains(thisSpc))){
						matchList.add(thisSpc);
					}
				}
			}
		}
		if(matchList.size()==0){
			return null;
		}
		else{
			return matchList;
		}
	}
	@Override
	public String toString(){
		String output = "";
		for (int i=0; i<this.nodes.size();i++){
			output += this.nodes.get(i).tree.toString() + " ";
		}
		return output;
	}
}
