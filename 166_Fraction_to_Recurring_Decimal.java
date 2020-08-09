class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0"; //0 divided by anything is 0
        StringBuilder ans = new StringBuilder();
        if( (numerator < 0) ^ (denominator < 0) ) ans.append('-'); //append a negative sign if only one of numerator/denominator is negative
        
        long longNum = Math.abs((long) numerator); //handle overflow and remove negative sign
        long longDen = Math.abs((long) denominator); //handle overflow and remove negative sign 
        
        //append the integral part
        long integral = longNum / longDen;
        ans.append(integral);
        
        //check if a fractional part is needed, if not: return
        long remainder = longNum % longDen;
        if(remainder == 0){
            return ans.toString();
        }
        
        //the fractional part
        ans.append('.');
        //map used to keep track if a repeating decimal exists
        HashMap<Long,Integer> map = new HashMap();
        map.put(remainder, ans.length()); //store the current remainder to see if it appears again
        /*
        Example: 4/333
        ans        rem    len
        0.          4      2    -> the remainder was first 4 when the length was 2
        0.0         40     3
        0.01        67     4
        0.012       4      5    -> the remainder became 4 again, wrap from index 2 - len in parens and return
        */
        
         while(remainder != 0){ //if the remainder is 0, the divison succeeded without repeats
            remainder = remainder * 10; //shift the remainder to make it greater than the denominator
            long quotient = remainder / longDen;
            ans.append(quotient);
            remainder = remainder % longDen;

            if(map.containsKey(remainder)){ //if the new remainder has already been encountered:
                //wrap from the first occurence till end in parens and return since it is going to repeat
                int index = map.get(remainder);
                ans.insert(index,'(');
                ans.append(')');
                return ans.toString();
            }
            map.put(remainder,ans.length()); //store the remainder in the map incase it repeats
        }
        return ans.toString();
    }
}
