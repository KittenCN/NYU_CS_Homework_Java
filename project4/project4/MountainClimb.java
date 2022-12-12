package project4;

/**
* The MountainClimb class builds the main class.
 * 
 * @author QiuanYu
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MountainClimb {
    public static void main(String[] args) throws FileNotFoundException {
        // args = new String[1];
        // args[0] = "D:\\workstation\\GitHub\\NYU_CS_Homework_Java\\project4\\project4\\inputs.txt";
        Scanner scan = new Scanner(new File(args[0]));
        BSTMountain bst = build(scan);
        // System.out.println(bst.toStringTreeFormat());
        List<String> strings = bst.binaryTreePaths(bst.root);
        // System.out.println(strings);
        for(String str:strings){
            System.out.print('[');
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == ' ' && i != str.length() - 1){
                    System.out.print(", ");
                }else{
                    System.out.print(str.charAt(i));
                }
            }
            System.out.println(']');
        }

    }


    private static BSTMountain build(Scanner scan ){
        BSTMountain bst=new BSTMountain();
        while (scan.hasNextLine()) {
            String  line= scan.nextLine();
            Map<String, Integer> map = process(line);
            int food=map.getOrDefault("food",0);
            int fallenTree=map.getOrDefault("fallen",0);
            int river=map.getOrDefault("river",0);
            int raft=map.getOrDefault("raft",0);
            int axe=map.getOrDefault("axe",0);
            Character element=line.charAt(0);
            RestStop restStop=new RestStop(element,food,fallenTree,river,raft,axe);
            bst.add(restStop);
        }
        return bst;

    }
    private static Map<String,Integer> process(String line){
        Map<String,Integer> map=new HashMap<>();
        String[] split = line.split(" ");
        if (split.length>1){
            for (int i=1;i<split.length;i++){
                String supObst = split[i];
                map.put(supObst,map.getOrDefault(supObst,0)+1);
            }
        }
        return map;
    }
}
