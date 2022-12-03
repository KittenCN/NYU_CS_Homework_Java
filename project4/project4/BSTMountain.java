package project4;

public class BSTMountain {
    private BSTNode root;
    private boolean boolIsAdd;
    public int intDepth;
    private int intCurrDepth;

    public BSTMountain(){
        root = null;
        boolIsAdd = true;
        intDepth = 0;
        intCurrDepth = 0;
    }

    public boolean addNode(RestStop data){
        if (data == null){
            return false;
        }
        root = bstnProAdd(data, root);
        intCurrDepth = 0;
        return boolIsAdd;
    }

    private BSTNode bstnProAdd(RestStop data, BSTNode node){
        if (node == null){
            boolIsAdd = true;
            if (intCurrDepth > intDepth){
                intDepth = intCurrDepth;
            }
            BSTNode newNode = new BSTNode(data);
            return newNode;
        }
        else if (data.compareTo(node.data) < 0){
            intCurrDepth++;
            node.l = bstnProAdd(data, node.l);
            return node;
        }
        else if (data.compareTo(node.data) > 0){
            intCurrDepth++;
            node.r = bstnProAdd(data, node.r);
            return node;
        }
        else {
            boolIsAdd = false;
            return node;
        }
    }

    public void printTree(){
        Hiker newHiker = new Hiker();
        BSTNode bstnCurrNode = root;
        int intHikerDepth = 0;
        voidPrintTree(newHiker, bstnCurrNode, intHikerDepth, "");
    }

    public void voidPrintTree(Hiker newHiker, BSTNode bstnCurrNode, int intHikerDepth, String strSolutions){
        if (bstnCurrNode == null){
            return;
        }
        if (bstnCurrNode.l == null && bstnCurrNode.r == null && intHikerDepth == intDepth){
            strSolutions = strSolutions + bstnCurrNode.data.strGetLabel();
            System.out.println(strSolutions);
        }
        else if (newHiker.processRestStop(bstnCurrNode.data)){
            strSolutions = strSolutions + bstnCurrNode.data.strGetLabel() + " ";
            Hiker hikerTMP = new Hiker(newHiker);
            voidPrintTree(hikerTMP, bstnCurrNode.l, intHikerDepth + 1, strSolutions);
            hikerTMP = new Hiker(newHiker);
            voidPrintTree(hikerTMP, bstnCurrNode.r, intHikerDepth + 1, strSolutions);
        }

    }

    private class BSTNode implements Comparable<RestStop>{
        private RestStop data;
        BSTNode l;
        BSTNode r;

        public BSTNode(RestStop data){
            this.data = data;
            this.l = null;
            this.r = null;
        }
        
        @Override
        public int compareTo(RestStop o) {
            return this.data.compareTo(o);
        }
    }
}
 