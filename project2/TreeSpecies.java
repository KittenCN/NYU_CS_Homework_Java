package project2;

public class TreeSpecies{
    private String commonName;
    private String latinName;

    public TreeSpecies(String commonName, String latinName) {
        this.setLatinName(latinName);
		this.setCommonName(commonName);
    }

    public void setLatinName(String latinName) throws IllegalArgumentException{
		if(latinName==null){
			throw new IllegalArgumentException("Spc_latin cannot be null");
		}
	}

	public String getLatinName(){
		return this.latinName;
	}

    public void setCommonName(String commonName) throws IllegalArgumentException{
		if(commonName==null){
			throw new IllegalArgumentException("Spc_latin cannot be null");
		}
	}

	public String getCommonName(){
		return this.commonName;
	}

    @Override
	public boolean equals(Object obj) throws IllegalArgumentException {
		TreeSpecies tree = (TreeSpecies) obj;
		
		if (tree.commonName.equalsIgnoreCase(this.commonName)&&tree.latinName.equalsIgnoreCase(this.latinName)){
			return true;
		}
		else{
			return false;
		}
	}
}
