package rpntest;


import org.junit.*;
import rpn.RPN;
import rpn.operators.*;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class RPNTest{

    private final HashMap<String, Operator> hashMap = new HashMap<>();
    @Before
    public void prepare(){
        this.hashMap.put("+", new Add());
        this.hashMap.put("*", new Multiply());
        this.hashMap.put("-", new Subtract());
    }

    @Test
    public void testNormal1(){
        RPN r = new RPN("2 3 * 5 + 3 -", hashMap);

        assertEquals("2*3+5-3=8",8, r.calculate());
    }

    @Test
    public void testNormal2(){
        RPN r = new RPN("2 4 + 4 * 2 - 1 +", hashMap);

        assertEquals("(2+4)*4-2+1=23",23, r.calculate());
    }

    @Test
    public void testNormal3(){
        RPN r = new RPN("2 3 4 + - 5 *", hashMap);

        assertEquals("[(3+4)-2]*5=-25",-25, r.calculate());
    }

    @Test
    public void testNormal4(){
        RPN r = new RPN("5 1 2 + 4 * + 3 -", hashMap);

        assertEquals("[(1+2)*4]+5-3=14",14, r.calculate());
    }

    @Test
    public void testNormal5(){
        RPN r = new RPN("20 5 + 14 * 2 4 * -", hashMap);

        assertEquals("[(20+5)*14]-(2*4)=342",342, r.calculate());
    }

    @Test
    public void testNoOperator(){
        RPN r = new RPN("20 5 % 1 -", hashMap);

        try{
            r.calculate();
        }catch (ArithmeticException e){
            assertEquals("Operation not known!", e.getMessage());
        }
    }

    @Test
    public void testAddedANewOperatorOnTheWay(){
        hashMap.put("/", new Divide());
        RPN r = new RPN("5 5 / 1 +", hashMap);

        assertEquals("5/5 + 1 = 2",2, r.calculate());
    }

    @Test
    public void testNewOperatorOnTheGoException(){
        hashMap.put("/", new Divide());
        RPN r = new RPN("5 0 /", hashMap);

        try{
            r.calculate();
        }catch (ArithmeticException e){
            assertEquals("/ by zero", e.getMessage());
        }
    }
}

