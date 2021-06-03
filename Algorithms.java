import java.util.*;

class Main {
    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4,3,2,4,1,2,5,6,2,4,2,1};
        int testSum = 6;
        findPairs(testArray, testSum);
    }

    private static void findPairs(int[] testArray, int targetSum) {
        ArrayList<Integer> numbersArray = new ArrayList<>();
        ArrayList<String> pairsArray = new ArrayList<>();

        for (int num1 : testArray) {
            for (Integer num2 : numbersArray) {
                String pair = "(" + num1 + ", " + num2 + ")";
                if (num1 + num2 == targetSum 
                    && !pairsArray.contains(pair) 
                    && !pairsArray.contains("(" + num2 + ", " + num1 + ")")) {
                    pairsArray.add(pair);
                    System.out.println(pair);
                }
            }
            numbersArray.add(num1);
        }
    }
}