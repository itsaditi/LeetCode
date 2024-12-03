class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        String[] sortedStr = new String[strs.length];
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        int i = 0;
        for (String str: strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            sortedStr[i] = String.valueOf(ch);
            i++;
        }

        for (int j = 0 ; j < strs.length ; j++) {
            if (!map.containsKey(sortedStr[j])) {
                map.put(sortedStr[j], new ArrayList<>());
            }

            map.get(sortedStr[j]).add(strs[j]);
        }

        for (String key: map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }
}