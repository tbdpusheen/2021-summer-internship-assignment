import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] testArray = {1,5,6,2,3,72,2,5,3,1,123,12,11,10};
        int testSum = 13;
        findPairs(testArray, testSum);
    }

    private static void findPairs(int[] testArray, int targetSum) {
        // Creates a copy of the input array and sorts it, simplifying mulitple aspects of the algorithm
        int[] sortedArray = testArray;
        Arrays.sort(sortedArray);
        ArrayList<String> pairsArray = new ArrayList<>();

        int currentIndex = 0;
        for (int num1 : sortedArray) {
            // Goes through the array looking for pairs. If the current number is higher than the target,
            // break, as the array is sorted and all subsequent numbers will also be higher
            if (num1 <= targetSum) {
                // Looks for all number higher than the current one, as all previous numbers will have
                // been tried and paired
                for (int loopingIndex = ++currentIndex; loopingIndex < sortedArray.length; loopingIndex++) {
                    // Creates a pair which always starts with the smaller number, as the array is sorted
                    String pair = "(" + num1 + ", " + sortedArray[loopingIndex] + ")";
                    if (num1 + sortedArray[loopingIndex] == targetSum && !pairsArray.contains(pair)) {
                        pairsArray.add(pair);
                        System.out.println(pair);
                    }
                }
            } else {
                break;
            }
        }
    }
}