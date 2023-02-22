public class GameBoard {
  // instance variables
  // top row
  private String l1; //left
  private String m1; //middle
  private String r1; //right
  // middle row
  private String l2; //left
  private String m2; //middle
  private String r2;
  // bottom row
  private String l3; //left
  private String m3; //middle
  private String r3; //right
  
  private String board;


  public GameBoard() {
    l1 = "1"; 
    m1 = "2"; 
    r1 = "3"; 
    l2 = "4"; 
    m2 = "5"; 
    r2 = "6";
    l3 = "7";
    m3 = "8";
    r3 = "9";
    board = "123456789";
  }
 /*
  public String setBoard() {
    board = 
  }
*/
  public boolean isOccupied(int num) {
    if(board.substring(num-1, num).equals("X") ||
       board.substring(num-1, num).equals("O")) {
      return true;
    } else {
      return false;
    }
  }
  public void update() {
    board = l1 + m1 + r1 + l2 + m2 + r2  + l3 + m3 + r3;
  }
  public void swap(int position, String turn) {
    switch(position) {
      case 1:
        l1 = turn;
        break;
      case 2:
        m1 = turn;
        break;
      case 3:
        r1 = turn;
        break;
      case 4:
        l2 = turn;
        break;
      case 5:
        m2 = turn;
        break;
      case 6:
        r2 = turn;
        break;
      case 7:
        l3 = turn;
        break;
      case 8:
        m3 = turn;
        break;
      case 9:
        r3 = turn;
        break;
      default:
        break;
    }
    update();
  }

  public String checkForWin() {
    String win = "No one has won";
    if(l1.equals("X") && m1.equals("X") && r1.equals("X")|| 
      l2.equals("X") && m2.equals("X") && r2.equals("X") ||
      l3.equals("X") && m3.equals("X") && r3.equals("X") ||
      l1.equals("X") && l2.equals("X") && l3.equals("X") ||
      m1.equals("X") && m2.equals("X") && m3.equals("X") ||
      r1.equals("X") && r2.equals("X") && r3.equals("X") ||
      l1.equals("X") && m2.equals("X") && r3.equals("X") ||
      r1.equals("X") && m2.equals("X") && l3.equals("X")) {
      win = "Player 1 Has Won";
    }
    else if(l1.equals("O") && m1.equals("O") && r1.equals("O")|| 
      l2.equals("O") && m2.equals("O") && r2.equals("O") ||
      l3.equals("O") && m3.equals("O") && r3.equals("O") ||
      l1.equals("O") && l2.equals("O") && l3.equals("O") ||
      m1.equals("O") && m2.equals("O") && m3.equals("O") ||
      r1.equals("O") && r2.equals("O") && r3.equals("O") ||
      l1.equals("O") && m2.equals("O") && r3.equals("O") ||
      r1.equals("O") && m2.equals("O") && l3.equals("O")) {
      win = "Player 2 Has Won";
    }
    return win;
  }
  public void restart() {
    l1 = "1"; 
    m1 = "2"; 
    r1 = "3"; 
    l2 = "4"; 
    m2 = "5"; 
    r2 = "6";
    l3 = "7";
    m3 = "8";
    r3 = "9";
    board = "123456789";
  }
  public String toString() {
   String square = "";
   for(int i = 0; i < 3; i++) {
     square += " _";
   }
   square += "\n";
   for(int i = 0; i < 3; i++) {
     square += "|";
     for(int j = 0; j < 3; j++) {
       square += board.substring(3*i+j, 3*i+j+1) + "|";
     }
     square += "\n";
     for(int k = 0; k < 3; k++) {
       square += " _";
     }
     square += "\n";
   }
   return square;
  }

}
