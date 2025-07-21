// Last updated: 7/21/2025, 7:03:52 PM
class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> map = new HashMap<>();

        for (List<String> path: paths) {
            if (!map.containsKey(path.get(0))) {
                map.put(path.get(0), null);
            }

            if (!map.containsKey(path.get(1))) {
                map.put(path.get(1), null);
            }

            map.put(path.get(0), path.get(1));
        }

        for (Map.Entry<String, String> mapSet: map.entrySet()) {
            if (mapSet.getValue() == null) {
                return mapSet.getKey();
            }
        }

        return "";
    }
}