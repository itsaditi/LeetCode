// Last updated: 8/4/2025, 4:51:13 PM
class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        Queue<Integer> iter = new LinkedList<Integer>();
        Queue<String> q = new LinkedList<String>();

        for(String s : bank)
        {
            map.put(s,0);
        }

        q.offer(startGene);
        iter.offer(0);
        
        while( q.peek() != null )
        {
            String gene = q.poll();
            int count = iter.poll();

            if( endGene.equals(gene))
                return count;

            for(String b : bank)
            {
                if( mutates(gene, b) && map.get(b) == 0)
                {
                    q.offer(b);
                    iter.offer(count + 1);
                    map.put(b,1);
                }
            }
        }

        return -1;
    }

    public static boolean mutates(String a, String b)
    {
        int c = 0;
        for(int i=0;i<8;i++)
        {
            if( a.charAt(i) != b.charAt(i) )
                c += 1;
        }
        return c == 1;
    }
}