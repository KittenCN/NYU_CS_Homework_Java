package project2;

import java.util.ArrayList;

public class TreeSpeciesList extends ArrayList<TreeSpecies>{
    public TreeSpeciesList getByCommonName(String keyWord){
        TreeSpeciesList commonNameList = new TreeSpeciesList();

        if (keyWord==null){
            throw new IllegalArgumentException("keyWord cannot be null");
        }

        for (int i=0; i<this.size();i++){
            if (this.get(i).getCommonName().equalsIgnoreCase(keyWord)){
                commonNameList.add(this.get(i));
            }
        }

        if(commonNameList.size()==0){
            return null;
        }

        return commonNameList;
    }
    public TreeSpeciesList getByLatinName(String keyWord){
        TreeSpeciesList latinNameList = new TreeSpeciesList();

        if (keyWord==null){
            throw new IllegalArgumentException("keyWord cannot be null");
        }

        for (int i=0; i<this.size();i++){
            if (this.get(i).getLatinName().equalsIgnoreCase(keyWord)){
                latinNameList.add(this.get(i));
            }
        }

        if(latinNameList.size()==0){
            return null;
        }

        return latinNameList;
    }
}