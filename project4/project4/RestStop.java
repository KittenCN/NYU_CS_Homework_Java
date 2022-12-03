package project4;

import java.util.*;

public class RestStop implements Comparable<RestStop>{
    private String strLabel;
    private ArrayList<String> alStrSupplies;
    private ArrayList<String> alStrObstacles;

    public RestStop (String strLabel, ArrayList<String> alStrSupplies, ArrayList<String> alStrObstacles){
        this.strLabel = strLabel;
        this.alStrSupplies = alStrSupplies;
        this.alStrObstacles = alStrObstacles;
    }

    public String strGetLabel(){
        return strLabel;
    }

    public ArrayList<String> alStrGetSupplies(){
        return alStrSupplies;
    }

    public ArrayList<String> alStrGetObstaclies(){
        return alStrObstacles;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(this.strLabel);
        for(int i = 0; i < alStrSupplies.size(); i++){
            sb.append(" ");
            sb.append(alStrSupplies.get(i));
        }
        for(int i = 0; i < alStrObstacles.size(); i++){
            sb.append(" ");
            sb.append(alStrObstacles.get(i));
        }
        return sb.toString();
    }

    @Override
    public int compareTo(RestStop rs) {
        String strLabel = rs.strGetLabel();
        return this.strLabel.compareTo(strLabel);
    }
}