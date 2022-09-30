package HW_3_Expression_Tree_attached;

public class Converter {
    String str;
    Converter(String _str) {
        this.str = _str;
    }
    public String toPostFix(String _str) {
        ArrayStack<Character> as = new ArrayStack<Character>();
        int i, pre1, pre2;
        String result = "";
        for (i = 0; i < _str.length(); ++i) {
            char cr = _str.charAt(i);
            if (Character.isDigit(cr)) {
                String number = cr + "";
                for (int j = i + 1; j < this.str.length(); ++j) {
                    if (Character.isDigit(this.str.charAt(j))) {
                        number += this.str.charAt(j);
                        i = j;
                    }
                    else {
                        break;
                    }
                }
                result += number + " ";
            }
            else if (cr == '('){
                as.push(cr);
            }
            else if (cr == ')') {
                while (as.top() != '(')
                result = result + as.pop() + " ";
                as.pop();
            }
            else if (cr == '+' || cr == '-' || cr == '*' || cr == '/' || cr == '^') {
                while ((as.size() != 0) && as.top() != '(') {
                    pre1 = precedence(cr);
                    pre2 = precedence(as.top());
                    if (pre2 >= pre1){
                        result = result + as.pop() + " ";
                    }
                    else{
                        break;
                    }      
                }
                as.push(cr);
            }
        }
        while(as.size() != 0) {
            result += as.pop() + " ";
        }
        return result;
    }
      
    public int precedence(char cr) {
        if (cr == '+' || cr == '-'){
            return 0;
        }
        else if (cr == '*' || cr == '/'){
            return 1;
        }
        else if (cr == '^'){
            return 2;
        }
        else{
            return 0;
        }
    }
}