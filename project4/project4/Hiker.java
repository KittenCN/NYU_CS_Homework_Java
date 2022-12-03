package project4;

import java.util.*;

public class Hiker {
    private int intFood;
    private int intRafts;
    private int intAxes;

    public Hiker(){
        this.intFood = 0;
        this.intRafts = 0;
        this.intAxes = 0;
    }

    public Hiker(Hiker hikerModel){
        this.intFood = hikerModel.intFood;
        this.intAxes = hikerModel.intAxes;
        this.intRafts = hikerModel.intRafts;
    }

    public boolean processRestStop(RestStop restStop){
        if (restStop == null){
            return false;
        }
        ArrayList<String> alStrSupplies = restStop.alStrGetSupplies();
        for (int i = 0; i < alStrSupplies.size(); i++){
            String strSupply = alStrSupplies.get(i);
            if (strSupply.equals("food")){
                this.intFood++;
            }
            else if (strSupply.equals("raft")){
                this.intRafts++;
            }
            else if (strSupply.equals("axe")){
                this.intAxes++;
            }
        }
        ArrayList<String> alStrObstacles = restStop.alStrGetObstaclies();
        for (int i = 0; i < alStrObstacles.size(); i++){
            String strObstacle = alStrObstacles.get(i);
            if (strObstacle.equals("river")){
                if (this.intRafts > 0){
                    this.intRafts--;
                }
                else {
                    return false;
                }
            }
            else if (strObstacle.equals("fallen tree")){
                if (this.intAxes > 0){
                    this.intAxes--;
                }
                else {
                    return false;
                }
            }
        }
        this.intFood--;
        if (intFood < 0){
            return false;
        }
        else{
            return true;
        }
    }
}