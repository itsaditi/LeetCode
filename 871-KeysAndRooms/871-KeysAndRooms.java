// Last updated: 8/4/2025, 4:50:50 PM
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashSet<Integer> availableKeys = new HashSet<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int visitedRoom = 1;

        for ( int index = 0 ; index < rooms.get(0).size() ; index ++) {
            availableKeys.add(rooms.get(0).get(index));
            queue.add(rooms.get(0).get(index));
        }
        System.out.print(queue);


        while(!queue.isEmpty()){
            int key = queue.poll();
            System.out.print(key);
            if (key == 0 ) {
                continue;
            }
            for(int i = 0 ; i < rooms.get(key).size(); i ++) {
                if (!availableKeys.contains(rooms.get(key).get(i))) {
                    availableKeys.add(rooms.get(key).get(i));

                    queue.add(rooms.get(key).get(i));
                }
            }
            
            visitedRoom++;
        }
        System.out.print("\n");

        System.out.print(visitedRoom);
        if (visitedRoom == rooms.size()) return true;

        return false;
    }
}