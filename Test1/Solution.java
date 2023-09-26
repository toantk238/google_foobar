public class Solution {
    
  public static void main(String[] args) {
    String input = "abcabcabcabc";
    int result = solution(input);
    System.out.println("result = " + result);

  }
    public static int solution(String x) {
        int i = 1;
        int sizeOfCake= x.length();
        while (i <= sizeOfCake/2){
            if (checkStartWith(x.substring(i, sizeOfCake), x.substring(0,i))){
                return sizeOfCake/i;
            }
            i++;
        }
        return 1;
    	//Your code here
    }
    
    static boolean checkStartWith(String remainSequence, String slice){
        int sizeOfRemain = remainSequence.length();
        int sizeOfSlice = slice.length();
        if (sizeOfRemain >= sizeOfSlice){
            return remainSequence.substring(0, sizeOfSlice).equals(slice) && 
            checkStartWith(remainSequence.substring(sizeOfSlice, sizeOfRemain), slice);
        }
        return true;
    }
}
