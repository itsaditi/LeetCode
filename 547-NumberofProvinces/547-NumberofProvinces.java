// Last updated: 5/5/2025, 7:29:33 PM
class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public int findCircleNum(int[][] isConnected) {

        int connections = isConnected.length;
        int numOfCities = isConnected[0].length;

        for (int i = 0 ; i < connections ; i ++) {
            for (int j = 0 ; j < numOfCities ; j ++) {
                if (i != j && isConnected[i][j] == 1) {
                    if (!map.containsKey(i)) map.put(i, new ArrayList<>());

                    if (!map.containsKey(j)) map.put(j, new ArrayList<>());

                    map.get(i).add(j);
                    map.get(j).add(i);

                }
            }
        }
        System.out.println(map);
        
        if (map.isEmpty()) {
            return numOfCities;
        }

        int numOfProvinces = 0;
        int unConnectedCity = 0;

        for (int i = 0 ; i < numOfCities ; i ++) {
            if (map.containsKey(i)) {
                findConnectedCities(i);
                numOfProvinces++;
            } else if (!visited.contains(i)) {
                unConnectedCity++;
            }
        }
        System.out.println(map + " " + numOfProvinces + " " + unConnectedCity);

        return numOfProvinces + unConnectedCity;
    }

    private void findConnectedCities(int city) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(city);

        while(!queue.isEmpty()) {
            int poppedCity = queue.poll();
            visited.add(poppedCity);
            
            if (!map.containsKey(poppedCity)) continue;
            
            List<Integer> connectedCity = map.get(poppedCity);
            queue.addAll(connectedCity);

            map.remove(Integer.valueOf(poppedCity));
        }
    }
}