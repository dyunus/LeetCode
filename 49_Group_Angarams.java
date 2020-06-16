class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List>  map = new HashMap(); // (count of each char a-z) -> (list of anagrams with corresponding count )
        for(String str : strs){
            //count each char a-z in the string
            char[] arr = new char[26]; 
            for(char c : str.toCharArray()){ 
                arr[c-'a']++;
            }
            String key = String.valueOf(arr); //convert the count array into a key 
            if(!map.containsKey(key)){map.put(key, new ArrayList());} //create list for corresponding key
            map.get(key).add(str); //add new anagram to key's list 
        }
        return new ArrayList(map.values());
    }
}

//Time Complexity: O(NK) where N is the length of strs, and K is the maximum length of a string in strs. Counting each string is linear in the size of the string, and we count every string.
//Space Complexity: O(NK), the total information content stored in the map.
