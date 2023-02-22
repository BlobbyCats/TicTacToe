import java.util.*;

public class TicTacToe {
  private GameBoard ticTacToeBoard;
  private boolean player1Turn;
  private boolean player2Turn;
  private int moveNumber;
  private boolean over;

  public TicTacToe() {
    ticTacToeBoard = new GameBoard();
    over = false;
  }
  public void start() {
    Scanner obj = new Scanner(System.in);
    int pos;
    moveNumber = 1;
    player1Turn = true;
    player2Turn = false;
    System.out.println("Welcome to tic tac toe, two player style!");
    while(moveNumber <= 9 && over == false) {
      System.out.println("This is move " + moveNumber);
      pos = 0;
      System.out.println("Here is the current board:\n" + ticTacToeBoard);
      if(player1Turn) {
        System.out.println("It is player one's turn. Please select a position from 1-9 of the value you would like to take.");
      }
      else {
        System.out.println("It is player two's turn. Please select a position from 1-9 of the value you would like to take.");
      }
      while(!obj.hasNextInt()) {
        System.out.println("That is not a valid position. Please enter a position from 1 to 9 that is not taken.");
        obj.next();
      }
      pos = obj.nextInt();
      while(pos < 1 || pos > 9  || ticTacToeBoard.isOccupied(pos))  {
        System.out.println("That is not a valid position. Please enter a position from 1 to 9 that is not taken.");
        while(!obj.hasNextInt()) {
        System.out.println("That is not a valid position. Please enter a position from 1 to 9 that is not taken.");
        obj.next();
      }
        pos = obj.nextInt();
      }
      if(player1Turn) {
        ticTacToeBoard.swap(pos, "X");
      } else {
        ticTacToeBoard.swap(pos, "O");
      }
      player1Turn = !player1Turn;
      moveNumber++;
      if(!ticTacToeBoard.checkForWin().equals("No one has won") && moveNumber < 9) {
        System.out.println(ticTacToeBoard);
        System.out.println(ticTacToeBoard.checkForWin());
        System.out.println("Game over. Would you like to play again? (y/n)");
        String s = "";
        s = obj.next();
        while(!s.equals("y") && !s.equals("n")) {
          System.out.println("That is not a valid value. Please write y if you want to continue and n if you would like to stop.");
          s = obj.next();
        }
        if(s.equals("y")) {
          moveNumber = 1;
          ticTacToeBoard.restart();
          player1Turn = true;
          System.out.println("\n\nA new game has started!");
        } else {
          over = true;
          System.out.println("Thank you for playing!");
        
      }
      }
      
      
      if(moveNumber > 9) {
        System.out.println(ticTacToeBoard);
        System.out.println(ticTacToeBoard.checkForWin());
        System.out.println("Game over. Would you like to play again? (y/n)");
        String s = "";
        s = obj.next();
        while(!s.equals("y") && !s.equals("n")) {
          System.out.println("That is not a valid value. Please write y if you want to continue and n if you would like to stop.");
          s = obj.next();
        }
        if(s.equals("y")) {
          moveNumber = 1;
          ticTacToeBoard.restart();
          player1Turn = true;
          System.out.println("\n\nA new game has started!");
        } else if(s.equals("n")) {
          over = true;
          System.out.println("Thank you for playing!");
        }  
      }
    }
      
    }
}
