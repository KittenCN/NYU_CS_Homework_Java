package project4;

import java.io.*;
import java.util.*;

public class MountainClimb {
    public static void main(String[] args){
        // args = new String[1];
        // args[0] = "D:\\workstation\\GitHub\\NYU_CS_Homework_Java\\project4\\project4\\inputs.txt";
        BSTMountain bstMountain = new BSTMountain();
        try {
            Scanner sc = new Scanner(new File(args[0]));

            while(sc.hasNext()){
                String strIn = sc.nextLine();
                String[] strListIn = strIn.split(" ");
                ArrayList<String> alStrSupplies = new ArrayList<>();
                ArrayList<String> alStrObstacles = new ArrayList<>();
                
                for (int i = 1; i < strListIn.length; i++){
                    if (strListIn[i].equals("axe") || strListIn[i].equals("raft") || strListIn[i].equals("food")){
                        alStrSupplies.add(strListIn[i]);
                    }
                    else if (strListIn[i].equals("river")){
                        alStrObstacles.add(strListIn[i]);
                    }
                    else if (strListIn[i].equals("fallen") && i != strListIn.length - 1 && strListIn[i + 1].equals("tree")){
                        alStrObstacles.add("fallen tree");
                    }
                }
                RestStop restStop = new RestStop(strListIn[0], alStrSupplies, alStrObstacles);
                bstMountain.addNode(restStop);
            }
        }
        catch (FileNotFoundException e){
            System.err.println("Invalid file");
        }

        bstMountain.printTree();

    }
}
 