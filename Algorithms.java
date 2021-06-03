import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] testArray = {1,5,6,2,3,72,2,5,3,1,123,12,11,10};
        int testSum = 13;
        findPairs(testArray, testSum);
    }

    /** Question 1: Create a function that accepts an array of integers and a target sum. 
     * The function will print all pairs of integers in the array whose sum is equal to the target sum.  
     * 
     * @param targetSum The target to find pairs that match
     * @param testArray The array of int to search for pairs which match the targetSum
     */ 
    private static void findPairs(int[] testArray, int targetSum) {
        // Creates a copy of the input array and sorts it, simplifying mulitple aspects of the algorithm
        int[] sortedArray = testArray;
        Arrays.sort(sortedArray);
        ArrayList<String> pairsArray = new ArrayList<>();

        int currentIndex = 0;
        for (int num1 : sortedArray) {
            // If the current number is higher than the target,
            // break, as the array is sorted and all subsequent numbers will also be higher
            if (num1 > targetSum) {
                break;
            }

            // Goes through the array looking for pairs. Looks for all number higher than the 
            // current one, as all previous numbers will have been tried and paired
            for (int loopingIndex = ++currentIndex; loopingIndex < sortedArray.length; loopingIndex++) {
                // Creates a pair which always starts with the smaller number, as the array is sorted
                String pair = "(" + num1 + ", " + sortedArray[loopingIndex] + ")";
                if (num1 + sortedArray[loopingIndex] == targetSum && !pairsArray.contains(pair)) {
                    pairsArray.add(pair);
                    System.out.println(pair);
                }
            }
        }
    }

    /** Question 2: Given two unsorted integer arrays, 
     * print out the numbers that are NOT contained in the other array
     * 
     * @param a First unsorted array
     * @param b Second unsorted array 
     */ 
    void reconcileHelper(int[] a, int[] b) {
        int[] sortedA = a;
        Arrays.sort(sortedA);
        int[] sortedB = b;
        Arrays.sort(sortedB);
        ArrayList<Integer> uniqueA = new ArrayList<>();
        ArrayList<Integer> uniqueB = new ArrayList<>();

        // 1,1,2,5,6,7,12
        // 1,4,5,5,6,13
        int index = 0;
        for (int number : sortedA) {
            if (number == sortedB[index]) {
                while (number == sortedB[index]) {
                    index++;
                }
            } 
            // if (!uniqueA.contains(number) && number < sortedB[index]) {
            //     uniqueA.add(number);
            // } else {
            //     while (number > sortedB[index]) {
            //         if (!uniqueA.contains(sortedB[index])) {
            //             uniqueB.add(sortedB[index]);
            //         }
            //         index++;
            //     }
            // }
        }

        String string = "";
        for (Integer number : uniqueA) {
            string += number + " ";
        }
        System.out.println("Numbers in array a that aren't in array b:\n" + string);
        string = "";
        for (Integer number : uniqueB) {
            string += number + " ";
        }
        System.out.println("Numbers in array b that aren't in array a:\n" + string);
    }
}