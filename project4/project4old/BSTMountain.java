package project4;

public class BSTMountain {
    private Node root;
    private boolean boolIsAdd;
    public int intDepth;
    private int intCurrDepth;

    public BSTMountain(){
        root = null;
        boolIsAdd = true;
        intDepth = 0;
        intCurrDepth = 0;
    }

    public boolean add(RestStop data){
        if (data == null){
            return false;
        }
        root = bstnProAdd(data, root);
        intCurrDepth = 0;
        return boolIsAdd;
    }

    private Node bstnProAdd(RestStop data, Node node){
        if (node == null){
            boolIsAdd = true;
            if (intCurrDepth > intDepth){
                intDepth = intCurrDepth;
            }
            Node newNode = new Node(data);
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
        Node bstnCurrNode = root;
        int intHikerDepth = 0;
        voidPrintTree(newHiker, bstnCurrNode, intHikerDepth, "");
    }

    public void voidPrintTree(Hiker newHiker, Node bstnCurrNode, int intHikerDepth, String strSolutions){
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

    public void clear(){
        root = null;
        boolIsAdd = true;
        intDepth = 0;
        intCurrDepth = 0;
    }

    public boolean contains(RestStop data){
        Node node = root;
        while (node != null){
            if (data.compareTo(node.data) == 0){
                return true;
            }
            else if (data.compareTo(node.data) < 0){
                node = node.l;
            }
            else if (data.compareTo(node.data) > 0){
                node = node.r;
            }
        }
        return false;
    }

    public RestStop ceiling(RestStop data){
        Node node = root;
        while (node != null){
            if (data.compareTo(node.data) == 0){
                return data;
            }
            else if (data.compareTo(node.data) < 0){
                return data;
            }
            else{
                node = node.r;
            }
        }
        return null;
    }

    public RestStop floor(RestStop data){
        Node node = root;
        while (node != null){
            if (data.compareTo(node.data) == 0){
                return data;
            }
            else if (data.compareTo(node.data) > 0){
                return data;
            }
            else{
                node = node.l;    
            }
        }
        return null;
    }

    public RestStop first(){
        Node node = root;
        while(node.l != null){
            node = node.l;
        }
        return node.data;
    }

    public RestStop get(int index){
        Node node = root;
        int intIndex = 0;
        while (node != null){
            if (intIndex == index){
                return node.data;
            }
            else if (intIndex < index){
                node = node.r;
                intIndex++;
            }
            else if (intIndex > index){
                node = node.l;
                intIndex--;
            }
        }
        return null;
    }

    public int height(){
        return intDepth;
    }

    public RestStop higher(RestStop data){
        Node node = root;
        while (node != null){
            if (data.compareTo(node.data) == 0){
                return node.r.data;
            }
            else if (data.compareTo(node.data) < 0){
                return node.data;
            }
            else{
                node = node.r;
            }
        }
        return null;
    }

    public boolean isEmpty(){
        if (root == null){
            return true;
        }
        return false;
    }

    public RestStop last(){
        Node node = root;
        while(node.r != null){
            node = node.r;
        }
        return node.data;
    }

    public RestStop lower(RestStop data){
        Node node = root;
        while (node != null){
            if (data.compareTo(node.data) == 0){
                return node.l.data;
            }
            else if (data.compareTo(node.data) > 0){
                return node.data;
            }
            else{
                node = node.l;
            }
        }
        return null;
    }

    public boolean remove(RestStop data){
        if (data == null){
            return false;
        }
        root = bstnProRemove(data, root);
        return true;
    }

    public Node bstnProRemove(RestStop data, Node node){
        if (node == null){
            return null;
        }
        else if (data.compareTo(node.data) < 0){
            node.l = bstnProRemove(data, node.l);
            return node;
        }
        else if (data.compareTo(node.data) > 0){
            node.r = bstnProRemove(data, node.r);
            return node;
        }
        else {
            if (node.l == null && node.r == null){
                return null;
            }
            else if (node.l == null){
                return node.r;
            }
            else if (node.r == null){
                return node.l;
            }
            else {
                Node nodeTMP = node.r;
                while (nodeTMP.l != null){
                    nodeTMP = nodeTMP.l;
                }
                node.data = nodeTMP.data;
                node.r = bstnProRemove(nodeTMP.data, node.r);
                return node;
            }
        }
    }

    public int size(){
        Node node = root;
        return intTreeWalk(node);
    }

    public int intTreeWalk(Node node){
        int intSize = 0;
        if (node != null){
            if (node.l != null){
                intSize++;
                intTreeWalk(node.l);
            }
            if (node.r != null){
                intSize++;
                intTreeWalk(node.r);
            }
        }
        return intSize;
    }

    public String toString(){
        Hiker newHiker = new Hiker();
        Node bstnCurrNode = root;
        int intHikerDepth = 0;
        return '[' + strToString(newHiker, bstnCurrNode, intHikerDepth, "") + ']';
    }

    public String strToString(Hiker newHiker, Node bstnCurrNode, int intHikerDepth, String strSolutions){
        if (bstnCurrNode == null){
            return strSolutions;
        }
        else if (newHiker.processRestStop(bstnCurrNode.data)){
            strSolutions = strSolutions + bstnCurrNode.data.strGetLabel() + ",";
            Hiker hikerTMP = new Hiker(newHiker);
            strToString(hikerTMP, bstnCurrNode.l, intHikerDepth + 1, strSolutions);
            hikerTMP = new Hiker(newHiker);
            strToString(hikerTMP, bstnCurrNode.r, intHikerDepth + 1, strSolutions);
        }
        return strSolutions;
    }

    private class Node implements Comparable<RestStop>{
        private RestStop data;
        Node l;
        Node r;

        public Node(RestStop data){
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
 