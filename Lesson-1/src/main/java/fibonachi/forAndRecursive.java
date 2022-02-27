package fibonachi;

public class forAndRecursive {
    public static void main(String[] args) {

    forAndRecursive f=new forAndRecursive();
        System.out.println("Фибоначи циклом");
        System.out.println(f.fib(46));

        System.out.println("\nВремя работы простой рекурсии");
        long simpleRecursiveTime = System.currentTimeMillis();
        System.out.println(f.fibRecursive(46));
        System.out.println(System.currentTimeMillis() - simpleRecursiveTime);


        System.out.println("\nВремя работы рекурсии с массивом");
        long RecursiveWithArrayTime = System.currentTimeMillis();
        System.out.println(f.fibRecursive2(46));
        System.out.println(System.currentTimeMillis() - RecursiveWithArrayTime);

    }


    //находим число Фибоначчи циклом
    public int fib(int n){
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
    public int fibRecursive(int n){
        if(n>47)
            throw new ArithmeticException("Переполнения тип данных int");
        if(n==1)
            return 0;
        if(n==2)
            return 1;
        return fibRecursive(n-1)+fibRecursive(n-2);
    }

    //находим число Фибоначи с помощью рекурсии
    int[] array=new int[46];

    public int fibRecursive2(int n){

        if(n==1) {
            array[n - 1] = 0;
            return 0;
        }
        if(n==2) {
            array[n-1]=1;
            return 1;
        }
        if(array[n-1]!=0)
            return array[n-1];
        int f=fibRecursive2(n-1)+fibRecursive2(n-2);
        array[n-1]=f;
        return f;
    }
}
