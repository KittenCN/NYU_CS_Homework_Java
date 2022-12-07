package project4;

/**
 * The BSTMountain class builds the logic of the mountain that inherits from BST<RestStop>.
 * 
 * @author QiuanYu
 *
 */

import java.util.ArrayList;
import java.util.List;

public class BSTMountain extends BST<RestStop>{

    public List<String> binaryTreePaths(Node root) {
        List<String> paths = new ArrayList<String>();
        int treeHeight = height();
        constructPaths(root, "", paths,new Hiker(true),treeHeight);
        return paths;
    }

    public void constructPaths(Node root, String path, List<String> paths,Hiker hiker,int height) {
        if (root != null) {
            int treeHeight = height();
            StringBuffer pathSB = new StringBuffer(path);
            RestStop restStop = (RestStop) root.element;
            pathSB.append(restStop.getElement());
            if(height<treeHeight && height>1){
                if (hiker.getFood()<0) {
                    hiker.setAlive(false);
                    return;
                }
            }
            hiker.setFood(restStop.getFood()+hiker.getFood());
            hiker.setAxe(restStop.getAxe()+ hiker.getAxe());
            hiker.setRaft(restStop.getRaft()+hiker.getRaft());
            if (restStop.getRiver()==1){
                if (hiker.getRaft()<=0) {
                    hiker.setAlive(false);
                    return;
                }else {
                    hiker.setRaft(hiker.getRaft()-1);
                }
            }
            if (restStop.getFallenTree()==1){
                if (hiker.getAxe()<=0) {
                    hiker.setAlive(false);
                    return;
                }else {
                    hiker.setAxe(hiker.getAxe()-1);
                }
            }
            
            if (height==1 && root.left == null && root.right == null) { 
                paths.add(pathSB.toString());  
            } else {
                pathSB.append(" ");  
                int food = hiker.getFood();
                hiker.setFood(food-1);
                constructPaths(root.left, pathSB.toString(), paths,hiker,height-1);
                hiker.setFood(food-1);
                constructPaths(root.right, pathSB.toString(), paths,hiker,height-1);
            }
        }
    }




}
