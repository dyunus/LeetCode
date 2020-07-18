class Solution {
    public boolean isPowerOfThree(int n) {
        /*Recursive Solution
        if(n == 3 || n == 1) return true;
        if(n < 3) return false;
        if(n % 3  == 0) return isPowerOfThree(n/3);
        return false;
        */
        
        /*
        Changing Base Solution:
        conver the number to base 3, if the number is a 1 followed by all 0's, then the number is a power of 3
         return Integer.toString(n, 3).matches("^10*$");
        */
        
        
        /*
        Using Math
        log_3(MAX_VALUE) = log_3(2147483647) = 19.5588 -> 19
        3^19 = 1162261467
        since 3 is a prime number, the only divisors of 3^19 are other powers of 3
        therefore diving 3^19 by n and having a remainder of 0 means n is a power of 3
        */
        return n > 0 && 1162261467 % n == 0;
    }
}
