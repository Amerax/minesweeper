import java.util.Scanner;
public class game{
    static Scanner sc = new Scanner(System.in);
    private board grid;
    private int mineCount;
    private int minesFound = 0;
    private int length;

    public void start(){
        System.out.println("Which difficulty would you like? Press:");
        System.out.println("1 - easy");
        System.out.println("2 - medium");
        System.out.println("3 - hard");

        int input = sc.nextInt();
        
        switch(input){
            case 1: 
            grid = new board(4);
            length = 4;
            mineCount = 2;
            break;

            case 2: 
            grid = new board(6);
            length = 6;
            mineCount = 4;
            break;

            case 3:
            grid = new board(8);
            length = 8;
            mineCount = 6;
            break;

            default:
                System.out.println("Invalid entry, defaulting to easy");
                grid = new board(4);
                mineCount = 2;
        }

        boolean playing = true;
        System.out.println("The game has started there are " + mineCount + " mines!");
        for(int i = 0; i < mineCount; i++) {
            int x = (int)(Math.random() * length);
            int y = (int)(Math.random() * length);
            grid.getCell(x, y).setIsMine();
        }
        setMinesNearBy();

        grid.printBoard();

        while(playing){
            System.out.println("Make a X input: ");
            int x = sc.nextInt();

            System.out.println("Make a Y input: ");
            int y = sc.nextInt();

            System.out.println("Would you like to flag? 0 for no, 1 for yes");
            int flagged = sc.nextInt();

            cell chosen = grid.getCell(x,y);

            if(flagged == 1){
                chosen.setIsRevealed();
                chosen.setIsFlagged();
                if(chosen.getIsMine()){
                    minesFound++;
                }
            }
            else{
                if(chosen.getIsMine()){
                    System.out.println("YOU STEPPED ON A MINE! GAME OVER");
                    chosen.setIsRevealed();
                    grid.printBoard();
                    playing = false; 
                
                }
                else{
                    chosen.setIsRevealed();
                }
            }
            if(checkWin()){
                playing = false; 
                System.out.println("Congrats you found all the mines!");
            }

            grid.printBoard();
        }
    }

    public boolean checkWin(){
        return minesFound == mineCount;
    }

    public void setMinesNearBy(){
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                cell chosen = grid.getCell(i,j);
                if(chosen.getIsMine()){continue;}

                int near = 0;

                for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
                for (int colOffset = -1; colOffset <= 1; colOffset++) {int neighborRow = i + rowOffset; int neighborCol = j + colOffset;

                    if (neighborRow >= 0 && neighborRow < length && neighborCol >= 0 && neighborCol < length) {
                        if (grid.getCell(neighborRow, neighborCol).getIsMine()) {
                            near++;
                        }
                    }
                }
            }
                chosen.setNear(near);
            }
        }
    }
}
