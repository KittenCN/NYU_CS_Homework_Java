package project2;

import java.util.ArrayList;

public class TreeSpeciesList extends ArrayList<TreeSpecies>{
    public TreeSpeciesList getByCommonName(String keyword){
        TreeSpeciesList commonNameList = new TreeSpeciesList();
        if (keyword==null){
            throw new IllegalArgumentException("Keyword cannot be null");
        }
        for (int i=0; i<this.size();i++){
            if (this.get(i).getCommonName().equalsIgnoreCase(keyword)){
                commonNameList.add(this.get(i));
            }
        }
        if(commonNameList.size()==0){
            return null;
        }
        return commonNameList;
    }
    public TreeSpeciesList getByLatinName(String keyword){
        TreeSpeciesList latinNameList = new TreeSpeciesList();
        if (keyword==null){
            throw new IllegalArgumentException("Keyword cannot be null");
        }
        for (int i=0; i<this.size();i++){
            if (this.get(i).getLatinName().equalsIgnoreCase(keyword)){
                latinNameList.add(this.get(i));
            }
        }
        if(latinNameList.size()==0){
            return null;
        }
        return latinNameList;
    }
}