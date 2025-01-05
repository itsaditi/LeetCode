class Solution {
    HashMap<Integer, Character[]> numberLetterMap = new HashMap<>();
 
    public List<String> letterCombinations(String digits) {
        List<String> permutation = new ArrayList<>();

        if (digits.equals("")) return permutation;

        numberLetterMap.put(2, new Character[]{'a', 'b', 'c'});
        numberLetterMap.put(3, new Character[]{'d', 'e', 'f'});
        numberLetterMap.put(4, new Character[]{'g', 'h', 'i'});
        numberLetterMap.put(5, new Character[]{'j', 'k', 'l'});
        numberLetterMap.put(6, new Character[]{'m', 'n', 'o'});
        numberLetterMap.put(7, new Character[]{'p', 'q', 'r', 's'});
        numberLetterMap.put(8, new Character[]{'t', 'u', 'v'});
        numberLetterMap.put(9, new Character[]{'w', 'x', 'y', 'z'});
        

        List<List<Character>> letterArr = new ArrayList<>();
    

        for (Character ch: digits.toCharArray()) {
            if (!numberLetterMap.containsKey(ch - '0')) {
                continue;
            }
            letterArr.add(Arrays.asList(numberLetterMap.get(ch - '0')));
        }

        generatePermutations(letterArr, permutation, 0, "");

        return permutation;
    }

    private void generatePermutations(
        List<List<Character>> lists, 
        List<String> result, 
        int depth, 
        String current
    ) {
        if (current.length() == lists.size()) {
            result.add(current);
            return;
        }

        for (int i = 0; i < lists.get(depth).size(); i++) {
            generatePermutations(lists, result, depth + 1, current + lists.get(depth).get(i));
        }
    }
}