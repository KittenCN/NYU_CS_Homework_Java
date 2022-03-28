package HW_3_Expression_Tree_attached;

import java.util.*;

class ExpressionTree{
   boolean isOperator(String str){
       if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/") || str.equals("^")){
           return true;
       }   
       return false;
   }
  
   Node covert(String postfix){
       ArrayStack<Node> stk = new ArrayStack<>();
       String arr[] = postfix.split(" ",20);
       Node t = null;
      
       for(int i = 0; i < arr.length - 1; ++i){
           t = new Node(arr[i]);
           if(!isOperator(arr[i])){
               stk.push(t);
           }
           else{
               Node r = null, l = null;
               if(!stk.isEmpty()){
                   r = stk.pop();
               } 
               if(!stk.isEmpty()){
                   l = stk.pop();
               }               
               t.leftChild = l;
               t.rightChild = r;
               stk.push(t);
           }
       }
       return stk.pop();
   }

   void infix(Node root){
       if(root != null){
           if(root.leftChild == null && root.rightChild == null){
               System.out.print(root.element);
           }
           else{
               System.out.print ("(");
               infix(root.leftChild);
               System.out.print(root.element);
               infix(root.rightChild);
               System.out.print (")");
           }
       }
   }
  
   void postfix(Node root){
       if(root != null){
           postfix(root.leftChild);
           postfix(root.rightChild);
           System.out.print(root.element + " ");
       }
   }
  
   void prefix(Node root){
       if(root != null){
           System.out.print(root.element + " ");
           prefix(root.leftChild);
           prefix(root.rightChild);
       }
   }

   public static void main (String[] args){
       Scanner sc = new Scanner(System.in);
       System.out.println("Type the expression: ");
       String strinfix = sc.nextLine();
       Converter conv = new Converter(strinfix);
       String strpostfix = conv.toPostFix(strinfix);
       ExpressionTree etree = new ExpressionTree();
       Node root = etree.covert(strpostfix);
       System.out.print("Prefix: ");
       etree.prefix(root);
       System.out.println ();
       System.out.print("Infix: ");
       etree.infix(root);
       System.out.println ();
       System.out.print("Postfix: ");
       etree.postfix(root);
       System.out.println ();
       sc.close();
   }
}