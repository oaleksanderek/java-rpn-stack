package stack;

import java.util.Arrays;

public class Stack {
    public int len = 0;
    public String[] stack = new String[len + 1];

    public void push(String input){

            stack = updateStackPush(stack);
            stack[len] = input;
            len += 1;
    }

    public String pop(){
        if(len == 0){
            throw new ArrayIndexOutOfBoundsException("Stack underflow!");
        }
        String element = stack[len - 1];
        stack = updateStackPop(stack);
        len -= 1;
        return element;
    }

    public String peek(){
        if(len == 0){
            throw new ArrayIndexOutOfBoundsException("Stack is empty!");
        }
        return stack[len - 1];
    }

    public static String[] updateStackPush(String[] stack){
        return Arrays.copyOf(stack, stack.length + 1);
    }

    public static String[] updateStackPop(String[] stack){
        if(stack.length == 1){
            return new String[1];
        }
        return Arrays.copyOf(stack, stack.length - 1);
    }
}