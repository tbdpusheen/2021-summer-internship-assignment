import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] testArray = {2};
        int testSum = 0;
        findPairs(testArray, testSum);

        int[] testA = {};
        int[] testB = {};
        reconcileHelper(testA, testB);
    }

    /** 
     * Question 1: Create a function that accepts an array of integers and a target sum. 
     * The function will print all pairs of integers in the array whose sum is equal to the target sum. 
     * 
     * <p> Algorithm:
     * <ul> 
     *      <li> Sort the input array 
     *      <li> Initial index = 0
     *      <li> Loop through the sorted array
     *      <ul>
     *          <li> If the current number is higher than the target, break
     *          <li> Loop through all numbers after the current number
     *          <ul>
     *              <li> If any of the numbers combine with the current number to match the target
     *                      and if the pair doesn't already exist, print the pair
     *          </ul>
     *      </ul>
     *      <li> Print a message if no pairs are found
     * </ul><p>
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

        if (pairsArray.isEmpty()) {
            System.out.println("No pairs found");
        }
    }

    /** 
     * Question 2: Given two unsorted integer arrays, 
     * print out the numbers that are NOT contained in the other array
     * 
     * <p> Algorithm:
     * <ul> 
     *      <li> Loop through array "a"
     *      <ul>
     *          <li> Add all non-duplicates to a new ArrayList that contains no duplicates
     *      </ul>
     *      <li> Loop through array "b"
     *      <ul> 
     *          <li> If the number is not a duplicate, add it to a new ArrayList 
     *                  that contains no duplicates
     *          <ul>
     *              <li> If the array "a" also contains the number, remove it 
     *                      as a unique number from array "a"
     *              <li> Otherwise, add it as a unique number for array "b"
     *          </ul>
     *      </ul>
     *      <li> Print the resulting unique numbers for each array
     * </ul><p>
     * 
     * @param a First unsorted array
     * @param b Second unsorted array 
     */ 
    private static void reconcileHelper(int[] a, int[] b) {
        // Adds all of array "a" to an ArrayList with no duplicates
        ArrayList<Integer> uniqueA = new ArrayList<>(); // Unique numbers for array "a"
        for (int number : a) {
            if (!uniqueA.contains(number)) {
                uniqueA.add(number);
            }
        }

        ArrayList<Integer> cleanedB = new ArrayList<>(); // No duplicates
        ArrayList<Integer> uniqueB = new ArrayList<>(); // Unique numbers for array "b"
        for (int number : b) {
            if (!cleanedB.contains(number)) {
                cleanedB.add(number);
                // Checks to see if the number is unique to array "b"
                if (uniqueA.contains(number)) {
                    // If it is not, remove that number from array "a" as that number is no longer unique
                    uniqueA.remove((Integer) number);
                } else { // Else, the number is unique
                    uniqueB.add(number);
                }
            }
        }

        String string = "";
        Collections.sort(uniqueA);
        for (Integer number : uniqueA) {
            string += number + " ";
        }
        System.out.println("Numbers in array a that aren't in array b:\n" 
            + (string != "" ? string : "None"));

        string = "";
        Collections.sort(uniqueB);
        for (Integer number : uniqueB) {
            string += number + " ";
        }
        System.out.println("Numbers in array b that aren't in array a:\n" 
            + (string != "" ? string : "None"));
    }
}