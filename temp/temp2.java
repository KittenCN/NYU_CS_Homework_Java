package temp;
import java.util.*;
public class temp2 {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        //入栈
        stack.push(1);
        stack.push(2);
        //返回栈顶数据
        System.out.println(stack.peek()); // 2
        //出栈
        if(!stack.isEmpty()){
            System.out.println(stack.pop()); // 2
        }

        Queue<Integer> queue = new LinkedList<>();
        //入队
        queue.offer(1);
        queue.add(2);
        //返回队头数据
        System.out.println(queue.peek()); // 1
        //出队
        if(!queue.isEmpty()){
            System.out.println(queue.poll()); // 1
        }
    }
}
