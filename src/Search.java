import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Search {

    public static void bubbleSort(int[] mas){       //  сортировка Пузырьком
        boolean needIteration = true;
        while (needIteration){
            needIteration = false;
            for(int i = 1; i<mas.length; i++){
                    if (mas[i] < mas[i - 1]) {
                        swap(mas, i, i - 1);
                        needIteration = true;
                    }
            }
        }
    }

    private static void swap(int[] mas, int first, int second) {
        int temp = mas[first];
        mas[first] = mas[second];
        mas[second] = temp;
    }

    public static int linearSearch(int[] mas, int a) {
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] == a) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] mas, int a) {
        int firstInd = 0;
        int lastInd = mas.length - 1;

        while(firstInd <= lastInd) {
            int middleInd = (firstInd+lastInd) / 2;
            if(mas[middleInd] == a) {
                return middleInd;
            }
            else if(mas[middleInd] < a) {
                firstInd = middleInd + 1;
            }
            else if(mas[middleInd] > a) {
                lastInd = middleInd - 1;
            }
        }
        return -1;
    }


    private static Random rand = new Random();

    public static int getRandom(int lo, int hi) {
        return lo + rand.nextInt(hi - lo + 1);
    }

    public static void fullMas(int[]mas){       //  массив заполняется числами от 0 до 100
        for(int i = 0; i < mas.length; i++){
            mas[i] = getRandom(0,100);
        }
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = 30;
        int[] mas = new int[N];
        fullMas(mas);
        bubbleSort(mas);
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(mas));
        System.out.println("Введите значение которе хотите найти");
        int a = scanner.nextInt();
        System.out.println(linearSearch(mas,a));
        System.out.println(binarySearch(mas,a));

    }
}
