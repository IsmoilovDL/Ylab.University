package fibonachi;

public class forAndRecursive {
    public static void main(String[] args) {
     System.out.println(fib(10));
     System.out.println(fibRecursive(10));
    }


    //находим число Фибоначчи циклом
    public static int fib(int n){
        if(n>47)
            throw new ArithmeticException("Переполнения тип данных int");
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n-1];
    }

    //находим число Фибоначи с помощью рекурсии
    public static int fibRecursive(int n){
        if(n>47)
            throw new ArithmeticException("Переполнения тип данных int");
        if(n==1)
            return 0;
        if(n==2)
            return 1;
        return fibRecursive(n-1)+fibRecursive(n-2);
    }
}
