public class Board {
    
    private char[][] board;

    public Board(){
        board = new char[3][3];
        Initiate();
    }

    public void Initiate(){
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                board[i][j] = (char) ('0' + (i * 3 + j + 1)); 
                }
            }
    }

    public void DisplayBoard(){

        System.out.println("Current State of the board: \n");
        for (int i=0; i<3;i++){
            System.out.println(" -------------");
            System.out.println(" | " + board[i][0]+ " | " + board[i][1]  + " | "+ board[i][2] + " | ");
        }
        System.out.println(" -------------");
    }

    public boolean Mark(int row, int col, char mark){
        if(col <= 2 && col >= 0 && row <= 2 && row >= 0 && board[row][col] != 'O' && board[row][col] != 'X' ){
            return true;
        }else{
            return false;
        }
    }

    public boolean checkWinner(char mark){
        // Check rows, columns and diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == mark && board[i][1] == mark && board[i][2] == mark) ||
                (board[0][i] == mark && board[1][i] == mark && board[2][i] == mark)) {
                return true;
            }
        }
            return (board[0][0] == mark && board[1][1] == mark && board[2][2] == mark) ||
            (board[0][2] == mark && board[1][1] == mark && board[2][0] == mark);   //Checks if there is a game winner in the diagonal and returns a bool 
 }

    public boolean checkDraw(){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if(board[i][j]!='X' && board[i][j]!='O'){
                    return false;
                }
            }
        }return true;
    }

    public void updateBoard(int row, int col, char mark){

        board[row][col] = mark;

    }
        
    }

