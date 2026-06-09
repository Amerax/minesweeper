import java.util.Scanner;
public class main{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        while(true){
            game player = new game();

            player.start();
            
            System.out.println("\n Would you like to play again? y/n");

            String input = sc.nextLine();

            if(input.equals("y")){
                continue;
            }
            else{
                break;
            }
        }
    }
}