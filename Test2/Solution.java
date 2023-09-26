public class Solution {
    public static String solution(long x, long y) {
        long result = (x + y -1) * (x + y -2 ) /2 + x;
        //Your code here
        return String.valueOf(result);
    }
    
    public static void main(String[] args){
      String result = solution(3,4);
      System.out.println("result = " + result);
    }
  }
