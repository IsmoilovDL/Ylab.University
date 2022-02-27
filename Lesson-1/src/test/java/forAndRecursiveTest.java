import fibonachi.forAndRecursive;
import org.junit.Assert;
import org.junit.Test;
public class forAndRecursiveTest {

    @Test
    public void fibonachiNumberTest(){
        forAndRecursive f=new forAndRecursive();
        //10 число Фибоначи циклом
        Assert.assertEquals(34, f.fib(10));

        // число Фибоначи циклом
        Assert.assertEquals(514229, f.fib(30));

    }

    @Test
    public void fibonachiRecursivTest(){
        forAndRecursive f=new forAndRecursive();

        //10 число Фибоначи рекурсией
        Assert.assertEquals(34, f.fibRecursive(10));

        // число Фибоначи рекурсией
        Assert.assertEquals(514229, f.fibRecursive(30));
    }

    @Test(expected = ArithmeticException.class)
    public void fibonachiNumberException(){
        forAndRecursive f=new forAndRecursive();
        f.fib(48);
    }
    @Test(expected = ArithmeticException.class)
    public void fibonachiRecursiveNumberException(){
        forAndRecursive f=new forAndRecursive();
        f.fibRecursive(48);
    }
}
