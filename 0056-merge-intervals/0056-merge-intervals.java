class Solution {
    public int[][] merge(int[][] in) {
        List<int[]> res = new ArrayList();
        if(in.length == 0) return res.toArray(new int[0][]);

        Arrays.sort(in,Comparator.comparingInt(a->a[0]));
        int start = in[0][0];
        int end = in[0][1];

        for(int i=1;i<in.length;i++){
            if(in[i][0] <= end) end = Math.max(end,in[i][1]); //merge ends

            else{
                res.add(new int[]{start, end});
                start = in[i][0];
                end = in[i][1];
            }
        }

        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}