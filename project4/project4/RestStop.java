package project4;

/**
 * The Strings class represent a single rest stop
 * 
 * @author QiuanYu
 *
 */

import java.util.Objects;

public class RestStop  implements Comparable  {
    private char  element;  
    private int food;
    private int fallenTree;
    private int river;
    private int raft; 
    private int axe;  

    public char getElement() {
        return element;
    }

    public void setElement(char element) {
        this.element = element;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getFallenTree() {
        return fallenTree;
    }

    public void setFallenTree(int fallenTree) {
        this.fallenTree = fallenTree;
    }

    public int getRiver() {
        return river;
    }

    public void setRiver(int river) {
        this.river = river;
    }

    public int getRaft() {
        return raft;
    }

    public void setRaft(int raft) {
        this.raft = raft;
    }

    public int getAxe() {
        return axe;
    }

    public void setAxe(int axe) {
        this.axe = axe;
    }

    public RestStop(char element, int food, int fallenTree, int river, int raft, int axe) {
        this.element = element;
        this.food = food;
        this.fallenTree = fallenTree;
        this.river = river;
        this.raft = raft;
        this.axe = axe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestStop restStop = (RestStop) o;
        return element == restStop.element;
    }

    @Override
    public int hashCode() {
        return Objects.hash(element);
    }

    @Override
    public int compareTo(Object o) {
        RestStop restStop = (RestStop) o;
        return element-restStop.element;
    }

    @Override
    public String toString() {
        return element + "";
        // return "{" +
        //         "label=" + element +
        //         ", food=" + food +
        //         ", raft=" + raft +
        //         ", axe=" + axe +
        //         ", fallenTree=" + fallenTree +
        //         ", river=" + river +
        //         '}';
    }
}
