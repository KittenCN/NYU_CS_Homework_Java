package HW_2_Postfix_attached;
class Converter {
    char char_arrResult[];
    int int_size;
    int int_tos;
    Converter(int int_size) {
        char_arrResult = new char[int_size];
        this.int_size = int_size;
        this.int_tos = -1;
    }
    public int isFull() {
        if (this.int_tos == this.int_size - 1)
            return 1;
        else
            return 0;
    }
    public int isEmpty() {
        if (this.int_tos == -1)
            return 1;
        else
            return 0;
    }
    public void push(char x) {
        char_arrResult[++this.int_tos] = x;
    }
    public char pop() {
        return char_arrResult[this.int_tos--];
    }
    public char peek() {
        return char_arrResult[this.int_tos];
    }
    public int precedence(char ch) {
        int select = 0;
        switch (ch) {
            case '+':
                select = 0;
            case '-':
                select = 0;
            case '*':
                select = 1;
            case '/':
                select = 1;
            case '^':
                select = 2;
        }
        return select;
    }
    public String toPostFix(String str) {
        char cr = ' ';
        int i, int_pre1, int_pre2;
        String str_result = "";
        for (i = 0; i < int_size; i++) {
            cr = str.charAt(i);
            if (cr == '(')
                push(cr);
            else if (cr == ')') {
                while (peek() != '(')
                    str_result = str_result + pop() + " ";
                pop();
            }
            else if (cr == '+' || cr == '-' || cr == '*' || cr == '/' || cr == '^') {
                while (peek() != '(') {
                    int_pre1 = precedence(cr);
                    int_pre2 = precedence(peek());
                    if (int_pre2 >= int_pre1)
                        str_result = str_result + pop() + " ";
                    else
                        break;
                }
                push(cr);
            }
            else
                str_result = str_result + cr + " ";
        }
        return str_result;
    }
}

