class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return new ArrayList<String>();
        }
        HashMap<Character, List<Character>> keyPad = new HashMap<Character, List<Character>>();
        keyPad.put('2', new ArrayList<Character>(Arrays.asList('a','b','c'))); 
        keyPad.put('3', new ArrayList<Character>(Arrays.asList('d','e','f'))); 
        keyPad.put('4', new ArrayList<Character>(Arrays.asList('g','h','i'))); 
        keyPad.put('5', new ArrayList<Character>(Arrays.asList('j','k','l'))); 
        keyPad.put('6', new ArrayList<Character>(Arrays.asList('m','n','o')));
        keyPad.put('7', new ArrayList<Character>(Arrays.asList('p','q','r','s')));
        keyPad.put('8', new ArrayList<Character>(Arrays.asList('t','u','v')));
        keyPad.put('9', new ArrayList<Character>(Arrays.asList('w','x','y','z')));
        return getCombinations(digits,keyPad);
    }
    
    //for every letter in keyset, add to beginning of substrings
    public List<String> getCombinations(String digits, HashMap<Character, List<Character>> keyPad){
        List<String> combinations = new ArrayList<String>();
        if(digits.length()<1){
            combinations.add("");
            return combinations;
        }
        for(Character ch : keyPad.get(digits.charAt(0))){
            List<String> subLists = getCombinations(digits.substring(1),keyPad);
            for(String sub : subLists){
                combinations.add(ch + sub);
            }
        }
        return combinations;
    }
}
