package stacktest;

import org.junit.*;

import stack.Stack;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class StackTest {
    @Test
    public void testPushAndPeek(){
        Stack stk = new Stack();
        stk.push("1");
        assertEquals("1", stk.peek());
    }

    @Test
    public void testPop(){
        Stack stk = new Stack();
        stk.push("1");
        stk.push("2");
        stk.push("3");
        assertEquals("3", stk.pop());
    }

    @Test
    public void testPopWithEmptyStack(){
        Stack stk = new Stack();
        try{
            stk.pop();
        }catch(ArrayIndexOutOfBoundsException e){
            assertEquals("Stack underflow!", e.getMessage());
        }
    }

    @Test
    public void testPeekWithEmptyStack(){
        Stack stk = new Stack();
        try{
            stk.peek();
        }catch(ArrayIndexOutOfBoundsException e){
            assertEquals("Stack is empty!", e.getMessage());
        }
    }
}
