class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for(int i =0; i<n;i++){
            for(int j = 0; j<m;j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for(int r: rows){
            for(int j =0; j<m;j++) matrix[r][j] = 0;
        }

        for (int col : cols) {
            for (int i = 0; i < n; i++)    matrix[i][col] = 0;
            
        }

    }
}