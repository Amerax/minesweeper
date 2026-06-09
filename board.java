public class board{
    private cell[][] grid;
    private int dimension;

    public board(int d){
        this.dimension = d;
        grid = new cell[d][d];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                grid[i][j] = new cell(false);
            }
        }
    }

    public cell getCell(int x, int y){
        return grid[x][y];
    }

    public void printBoard(){
        System.out.print("   ");
        for(int i = 0; i < grid.length; i++){
            System.out.print(i + " ");
        }
        System.out.println();

        for(int i = 0; i < grid.length; i++){
            System.out.print(i);
            for(int j = 0; j < grid[i].length; j++){
                System.out.print(" " + grid[i][j]);
            }
            System.out.println();
        }
    }
} 