package fibonachi;

import java.util.Arrays;

//находим число Фибоначчи циклом
public class withFor {
    public static void main(String[] args) {
     System.out.println(fib(47));
    }
    private static int fib(int n){
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; ++i) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n-1];
    }
}
