// Last updated: 7/20/2025, 9:34:11 PM
class Solution {
    public int compress(char[] chars) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        String res = "";

        while (!queue.isEmpty()) {
            int index = queue.poll();
            char ch = chars[index];
            int occ = 1;

            for (int i = index + 1 ; i < chars.length ; i++) {
                if (chars[i] == ch) {
                    occ++;
                } else {
                    queue.add(i);
                    break;
                }
            }

            System.out.println(ch + " " + occ);
            if (occ > 1) {
                res += Character.toString(ch) + Integer.toString(occ);
            } else {
                res += ch;
            }

        }

        // for (Character key: map.keySet()) {
        //     char ch = key;
        //     Integer val = map.get(key);

        //     if (val > 1) {
        //         res += Character.toString(ch) + Integer.toString(val);
        //     } else {
        //         res += ch;
        //     }
        // }

        int i = 0;
        for (char ch: res.toCharArray()) {
            chars[i] = ch;
            i++;
        }



        return res.length();

        
    }
}