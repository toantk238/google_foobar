import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[]{7, 3, 5, 1})));
    }

    public static int[] solution(int h, int[] q) {
        ArrayList<Integer> results = new ArrayList<>();
        for (int x : q) {
            results.add((int) getParentIndex(h, x));
        }

        return results.stream().mapToInt(i -> i).toArray();
    }

    public static long getParentIndex(int h, int idx) {
        long max_idx = (long) Math.pow(2.0, h) - 1;
        if (max_idx < idx) {
            return -1;
        }

        long nodeOffset = 0;
        boolean continueFlag = true;
        long subtreeSize = max_idx;
        long result = -1;
        long leftNode;
        long rightNode;
        long myNode;

        while (continueFlag) {
            if (subtreeSize == 0) {
                continueFlag = false;
            }

            subtreeSize = subtreeSize >> 1;

            leftNode = nodeOffset + subtreeSize;
            rightNode = leftNode + subtreeSize;
            myNode = rightNode + 1;

            if (leftNode == idx || rightNode == idx) {
                result = myNode;
                continueFlag = false;
            }

            if (idx > leftNode) {
                nodeOffset = leftNode;
            }
        }

        return result;
    }

}

