import java.lang.reflect.Array;
import java.util.*;

public class Lab3 {
    // function that will create children
    static int[] children(int[] array1, int[] array2, int cPoint){
        int[] child = new int[20];
        for (int i=0; i < cPoint; i++){
            child[i] = array1[i];
        }
        for (int i=cPoint; i < array2.length; i++){
            child[i] = array2[i];
        }
        return child;
    }
    //function to find the index of a particular element
    public static int findIndex(int arr[], int t)
    {

        if (arr == null) {
            return -1;
        }

        int len = arr.length;
        int i = 0;

        while (i < len) {
            if (arr[i] == t) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
    // function that will return the sum of an array
    static int sums(int[] array){
        int sum=0;
        for(int i=0; i < array.length;i++){
            sum += array[i];
        }
        return sum;
    }
    // function to find the best gene
    static String bestGene(int[][] array){
        int[] sumArray = new int[21];
        for(int i=0; i < array.length;i++){
            sumArray[i] = sums(array[i]);
        }
        int max = 0;
        for(int i=0; i < sumArray.length;i++){
            if(sumArray[i] > max){
                max = sumArray[i];
            }

        }
        int indexOfMax = findIndex(sumArray, max);
        return Arrays.toString(array[indexOfMax]) + ", " + max;
    }
    //function to generate a random number
    static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    // function to mutate genes
    static int[] mutate(int[] array, int first, int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = array[second];
        return array;
    }

    public static void main(String[] args){
        int[] parent1 = {7, 4, 5, 2, 6 ,3, 2, 6, 8, 3, 5, 1, 7, 3, 7, 2, 8, 5, 2, 6};
        int[] parent2 = {9, 4, 6, 1, 7, 2, 8, 3, 5, 1, 6, 8, 6, 9, 4, 5, 8, 2, 9, 1};

        System.out.println("Here are the 20 children arrays: ");
        System.out.println("=================================");

        int[][] child = new int[20][20];
        for(int i=0; i < 10; i++){
            int rand = (int )(Math.random() * 19 + 1);
            child[i] = children(parent1, parent2, rand);
            System.out.println(Arrays.toString(child[i]));
        }
        for(int i=10; i < 20; i++){
            int rand = (int )(Math.random() * 19 + 1);
            child[i] = children(parent2, parent1, rand);
            System.out.println(Arrays.toString(child[i]));
        }


        System.out.println("=================================");
        System.out.println("Here is a child array: ");
        System.out.println(Arrays.toString(child[9]));
        System.out.println("=================================");

        System.out.println("Here is the sum of that above child Array: ");
        System.out.println(sums(child[9]));

        System.out.println("=================================");
        System.out.println("Mutation");
        System.out.println("Before Mutation");
        System.out.println(Arrays.toString(child[13]));

        int[] mutatedArray = mutate(child[13], 0, 1);

        System.out.println("After Mutation");
        System.out.println(Arrays.toString(mutatedArray));
        System.out.println("As you can see, the first item got overwritten by the second item.");


        System.out.println("=================================");
        System.out.println("IF YOU GET AN ERROR WHILST TRYING TO GET THE BEST GENE, JUST KEEP TRYING, IT'LL COME.");
        System.out.println("Here is the best gene: ");
        System.out.println(bestGene(child));
        

    }
}
