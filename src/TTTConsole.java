import java.util.Scanner;
/**
 * Tic-Tac-Toe: Two-player console, non-graphics
 * @author Ellsworth Evarts IV
 * @date 1/31/2020
 */
public class TTTConsole  {
                                                     
   public static Scanner in = new Scanner(System.in); // the input Scanner
 
   public static TicTacToe TTTboard = new TicTacToe();
   /** The entry main method (the program starts here) */
   public static void main(String[] args) {
	   
	   int currentState = TicTacToe.PLAYING;
	   String userInput;//should this be an int?
	   //game loop
	   do {   
         TTTboard.printBoard();
         // Print message if game-over
         currentState = TTTboard.checkForWinner();
         /**
          * get player input here and call setMove(). user should input a number between 0-8
          */
         
         userInput = in.next();
        
         int uInput = Integer.parseInt(userInput);
         if(TTTboard.isEmpty(uInput)) {
        	 TTTboard.setMove(1, uInput);
        	 }
         else {
        	 TTTConsole.main(args);//call back to main method if position entered is occupied
         }
         
         currentState = TTTboard.checkForWinner();
         
         
         if (currentState == ITicTacToe.CROSS_WON) {
            System.out.println("'X' won! Bye!");
            break;
         } else if (currentState == ITicTacToe.NOUGHT_WON) {
            System.out.println("'O' won! Bye!");
            break;
         } else if (currentState == ITicTacToe.TIE) {
            System.out.println("It's a TIE! Bye!");
            break;
         }
         //////////////////uncomment for user vs user play////////////////////////////
         //userInput = in.next();
         //int uInput2 = Integer.parseInt(userInput);
         //TTTboard.setMove(2, uInput2);
         //////////////////uncomment for user vs user play////////////////////////////
         
         
         
         TTTboard.setMove(2,  TTTboard.getComputerMove());//A.I. generated play
         
         currentState = TTTboard.checkForWinner();
         
         if (currentState == ITicTacToe.CROSS_WON) {
             System.out.println("'X' won! Bye!");
             break;
          } else if (currentState == ITicTacToe.NOUGHT_WON) {
             System.out.println("'O' won! Bye!");
             break;
          } else if (currentState == ITicTacToe.TIE) {
             System.out.println("It's a TIE! Bye!");
             break;
          }
           
      } while ((currentState == ITicTacToe.PLAYING) && (!userInput.equals("q"))); // repeat if not game-over
   }
 
     
}