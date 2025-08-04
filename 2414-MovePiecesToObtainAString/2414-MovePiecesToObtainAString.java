// Last updated: 8/4/2025, 4:50:19 PM
class Solution {
    public boolean canChange(String start, String target) {
        Queue<Pair<Character, Integer>> startQueue = new LinkedList<>();

        Queue<Pair<Character, Integer>> targetQueue = new LinkedList<>();

        for (int i = 0 ; i < start.length() ; i++) {
            Character chStart = start.charAt(i);
            Character chTarget = target.charAt(i);

            if (chStart != '_') {
                startQueue.add(new Pair(chStart, i));
            }

            if (chTarget != '_') {
                targetQueue.add(new Pair(chTarget, i));
            }
        }

        if (startQueue.size() != targetQueue.size()) return false;

        // For each pair of pieces:
        // First, verify they are the same type (both 'L' or both 'R').
        // Then, depending on the piece type, check if their positions satisfy 
        // our movement constraints:
        // * 'L' pieces in the start must not be to the left of their target positions.
        // * 'R' pieces must not be to the right of their target positions.
        while (!startQueue.isEmpty()) {
            Pair<Character, Integer> startElem = startQueue.poll();
            Pair<Character, Integer> targetElem = targetQueue.poll();

            if (startElem.getKey() != targetElem.getKey()) return false;

            if (startElem.getKey() == 'L') {
                if (startElem.getValue() < targetElem.getValue())
                    return false;
            }
            if (startElem.getKey() == 'R') {
                if (startElem.getValue() > targetElem.getValue())
                    return false;
            }
        }

        return true;
    }
}