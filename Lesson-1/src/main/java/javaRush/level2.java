package javaRush;

//Задачи уровня 2
public class level2 {
    public static void main(String[] args) {
        level2 l2=new level2();

        int[] array={-5,2,5,-4,5,10,3,-8,15};
        l2.max(array);
        l2.min(array);
    }

    ///метод находит максимальный элемент в массиве
    private void max(int[] array){
        int max=0;
        for (int i=0; i<array.length; i++)
        {
            if(array[i]>max) {
                max=array[i];
            }
        }
        System.out.println("Max element in array: "+max);
    }

    ///метод находит минимальный элемент в массиве
    private void min(int[] array){
        int min=0;
        for (int i=0; i<array.length; i++)
        {
            if(array[i]<min) {
                min=array[i];
            }
        }
        System.out.println("Max element in array: "+min);
    }
}
