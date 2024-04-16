class Solution {
    public int numIslands(char[][] grid) {
        //Verificamos que el Array no venga vacio
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int numRows = grid.length;
        int numCols = grid[0].length;
        int numIslands = 0;
        
        // Iterar a través de cada celda en la cuadrícula
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                // Si la celda es tierra, marcar como visitada y explorar la isla
                if (grid[i][j] == '1') {
                    numIslands++;
                    exploreIsland(grid, i, j);
                }
            }
        }

        return numIslands;
    }
    
    private void exploreIsland(char[][] grid, int row, int col) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        // Marcar la celda actual como visitada
        grid[row][col] = '0';

        // Verificar celdas adyacentes
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols && grid[newRow][newCol] ==                 '1') {
                exploreIsland(grid, newRow, newCol);
            }
        }
    }
}