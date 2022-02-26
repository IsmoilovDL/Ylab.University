import fibonachi.forAndRecursive;
import org.junit.Assert;
import org.junit.Test;
public class forAndRecursiveTest {

    @Test
    public void fibonachiNumberTest(){
        //10 число Фибоначи циклом
        Assert.assertEquals(34, forAndRecursive.fib(10));

        // число Фибоначи циклом
        Assert.assertEquals(514229, forAndRecursive.fib(30));

    }

    @Test
    public void fibonachiRecursivTest(){
        //10 число Фибоначи рекурсией
        Assert.assertEquals(34, forAndRecursive.fibRecursive(10));

        // число Фибоначи рекурсией
        Assert.assertEquals(514229, forAndRecursive.fibRecursive(30));
    }

    @Test(expected = ArithmeticException.class)
    public void fibonachiNumberException(){
        forAndRecursive.fib(48);
    }
    @Test(expected = ArithmeticException.class)
    public void fibonachiRecursiveNumberException(){
        forAndRecursive.fibRecursive(48);
    }
}
