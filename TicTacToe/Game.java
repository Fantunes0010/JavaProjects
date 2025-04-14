import java.util.Scanner;


public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    private Scanner scanner;

    private int player1Move;
    private int player2Move;
    private int playermove;


    public Game() {
        board = new Board();
        scanner = new Scanner(System.in);
    }

    public void Start(){

        //Player names and Marks

        System.out.println("Player 1 Enter Your name: \n");
        player1 = new Player(scanner.nextLine() , 'O');

        System.out.println("Player 2 Enter Your name: \n");
        player2 = new Player(scanner.nextLine() , 'X');

        //display board

        board.DisplayBoard();
        makeMove();
    }

    public void makeMove(){

        playermove=0;

        int row = 0;
        int col = 0;

        //check amount of plays
        Player currentPlayer;

        while (true) {
            
    
        if(player1Move <= player2Move){
            currentPlayer = player1;
        } else {
            currentPlayer = player2;
        }
        System.out.println(currentPlayer.getName() + " play your move! \n");
        playermove = scanner.nextInt();
        scanner.nextLine(); // Clear newline character after nextInt()

        if (playermove < 1 || playermove > 9) {
            System.out.println("Invalid move. Please enter a number between 1 and 9.");
        } else {
            // Calculate the row and column based on the move
            row = (playermove - 1) / 3;
            col = (playermove - 1) % 3;
        }

        // place mark 
        if (board.Mark(row, col, currentPlayer.getMark())) {
            board.updateBoard(row, col, currentPlayer.getMark());
            board.DisplayBoard();
            if (currentPlayer == player1) {
                player1Move++;
            } else {
                player2Move++;
            }
            if (board.checkWinner(currentPlayer.getMark())) {
                // Clear the screen
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(" -------------\n");
                System.out.println("  "+ currentPlayer.getName() + " wins! \n");
                System.out.println(" -------------");
                break;
            }
        }else{
            System.out.println("Invalid Move play Again! \n");
        }

        //check draw
        if (board.checkDraw()) {
            System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println(" -------------");
            System.out.println("It's a draw!");
            System.out.println(" -------------");
            break;
        }
    }
    
}


public static void main(String[] args) {
    Game game = new Game();    
    game.Start();

    
}
}
