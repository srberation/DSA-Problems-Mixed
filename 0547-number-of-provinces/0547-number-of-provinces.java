class Solution {
    public int findCircleNum(int[][] isConnected){
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i< n; i++){
            adj.add(new ArrayList<>())  ;          
        }
        for(int i =0;i<n;i++){
            for(int j=0 ;j <n;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                } 
            }
        }
        int[] vis = new int[n];
        int cnt =0;
        for(int i = 0 ;i<n;i++){
            if(vis[i] == 0){
                cnt++;
                dfs(adj,i,vis);
            }
        }
        return cnt;
    }
    public void dfs(List<List<Integer>> adj, int v, int[] vis){
        vis[v] = 1;

        for(int neigh:adj.get(v)){
            if(vis[neigh] ==0) dfs(adj,neigh,vis);
        }

    }
}


