package rpn;

import stack.Stack;
import rpn.operators.*;
import java.util.HashMap;

public class RPN {
    private final String[] calculation;
    private final Stack stk;
    private final HashMap<String, Operator> hashMap;

    public RPN(String calculation, HashMap<String, Operator> hashMap) {
        this.stk = new Stack();
        this.calculation = calculation.split(" ");
        this.hashMap = hashMap;
    }

    public int calculate(){

        for(String str : calculation){
            if(isDigit(str)) {
                stk.push(str);
            } else if (hashMap.containsKey(str)) {
                Operator operator = hashMap.get(str);
                operator.apply(stk);
            }
            else{
                throw new ArithmeticException("Operation not known!");
            }
        }
        return Integer.parseInt(stk.pop());
    }

    public boolean isDigit(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}

