class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> map = new HashMap<String,Boolean>(); //create a map to store substring results
        HashSet<String> set = new HashSet<String>(wordDict); //convert list to set 
        if(set.contains(s)) //check if string as a whole is already part of set 
            return true;
        return search(s,set,map);
    }
    
    public boolean search(String s, HashSet<String> set, HashMap<String,Boolean> map){
        if(s.equals("")) //empty string is trivially true
            return true;
        if(map.containsKey(s)){ //check memoization for string result
            return map.get(s);
        }
        for(int i=1; i<= s.length(); i++){ //loop through all possible substrings
            if(set.contains(s.substring(0,i)) && search(s.substring(i,s.length()),set,map)){// check if set contains a particular substring, then recurisvely search the remaining part of the substring
                map.put(s.substring(0,i),true); //memoize true
                return true;
            }
        }
        map.put(s,false); //memoize false 
        return false;
    }
}
