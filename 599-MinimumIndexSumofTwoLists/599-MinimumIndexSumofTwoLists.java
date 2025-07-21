// Last updated: 7/21/2025, 7:57:02 PM
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> list1Map = new HashMap<>();
        HashMap<String, Integer> list2Map = new HashMap<>();

        for (int i = 0 ; i < list1.length ; i++) {
            list1Map.put(list1[i], i);
        }

        for (int i = 0 ; i < list2.length ; i++) {
            list2Map.put(list2[i], i);
        }

        int minIndex = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();

        for (String str: list1) {
            if (list2Map.containsKey(str)) {
                int index = list2Map.get(str) + list1Map.get(str);
                if (index < minIndex) {
                    minIndex = index;
                    res = new ArrayList<>();
                    res.add(str);
                } else if (index == minIndex) {
                    res.add(str);
                }

            }
        }

        return res.toArray(new String[res.size()]);
    }
}