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
    public void fobonachiRecursivTest(){
        //10 число Фибоначи рекурсией
        Assert.assertEquals(34, forAndRecursive.fibRecursive(10));

        // число Фибоначи рекурсией
        Assert.assertEquals(514229, forAndRecursive.fibRecursive(30));
    }
}
