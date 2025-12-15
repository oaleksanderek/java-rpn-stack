package rpn.operators;

import stack.Stack;

public class Subtract implements Operator {
    public void apply(Stack stk) {
        String temp1 = stk.pop();
        String temp2 = stk.pop();

        int x = Integer.parseInt(temp1);
        int y = Integer.parseInt(temp2);

        stk.push(Integer.toString(y - x));
    }
}
