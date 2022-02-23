public class Board{
    public int[n][n] board;
    string[][] winner;

    initialize(){
        board = new int[n][n];
    }

    getBoard();
    getWinner();
    getCurrentPlayer();

    
    /** 
        function move:::
        makes a move on the board and return winner if this is a winning move
        @param player : is either 0 or 1
        @param row: is move's row index
        @param col: is move's col index
        @return winner : +1 if first player wins, -1 if second player wins and 0 for draw/undecided
        @throws IllegalArgumentException if the move is an illegal move

        logic: if the player==0, fill that cell with +1 and if any row/col/diag/redDiag == +1, player 0 wins the game 
               if the player==1, fill that cell with -1 and if any row/col/diag/redDiag == -1, player 1 wins the game 
        
    **/
    public int makeMove(Move m){
        int row = m.row;
        int col = m.col;
        int player = m.player;

        if(m.row < 0 || m.col < 0 || m.row >= n || m.col >= n)
            throw new IllegalArgumentException("move out of board boundary");
        else if(board[m.row][m.col] != 0)
            throw new IllegalArgumentException("Cell is already occupied!");
        else if(player !=0 || player != 1)
            throw new IllegalArgumentException("Invalid player");
        else{
            int val;
            val = player == 0 ? +1 : -1;
            board[row][col] = val; //fill that cell with +1/-1 depending on which player it is then check if the move was winning move below

            //rows
            //check if row of that cell have all same val = +1 and belong to player 0
            //or check if row of that cell have all same val = -1 and belong to player 1
            boolean winRow = true;
            for(int i=0;i<col;i++){
                if(board[row][i] != val)
                winRow = flase;
                    break;
            }
            if(winRow)
                return player;

            //cols
            //check if col of that cell have all same val = +1 and belong to player 0
            //or check if col of that cell have all same val = -1 and belong to player 1
            boolean winCol = true;
            for(int i=0;i<row;i++){
                if(board[i][col] != val)
                    winCol = flase;
                    break;
            }
            if(winCol)
                return player;

            //diag
            //check if diag of that cell have all same val = +1 and belong to player 0
            //or check if diag of that cell have all same val = -1 and belong to player 1
            boolean winDiag = true;
            if(row==col){
                for(int i=0;i<n;i++){
                    if(board[i][i] != val)
                        winDiag = flase;
                        break;
                }
                if(winDiag)
                    return player;
            }

            //revDiag
            //check if rev diag of that cell have all same val = +1 and belong to player 0
            //or check if rev diag of that cell have all same val = -1 and belong to player 1
            winRevDiag = true;
            if(row = n-1-col){
                for(int i=0;i<n;i++){
                    if(board[i][n-1-i] != val)
                        winRevDiag = flase;
                        break;
                }
                if(winRevDiag)
                    return player;
            }

            if(winRow || winCol || winDiag || winRevDiag) 
                return player;
        }
    }
    return 0;
}

public class Move{
    int player;
    int row;
    int col;
    public int getPlayer()
        return player;
    public void setPlayer(int p)
        this.player = p;

    public int getRow()
        return row;
    public void setRow(int r)
        this.row = r;

    public int getCol()
        return col;
    public void setCol(int c)
        this.col = c;
}

public class User{
    int userId;
    getStat(userId);
    updateStat(userId);
}

public class Stat{
    int no_of_wins;
    int no_of_loss;
    string oponent_name;
}

public class Game{
    int game_Id;
    int userId1;
    int UserId2;
    List<Move m>;

    initialise();
    undo();
} 

public class TicTacToe{
    Board board = new Board();
    Move m = new Move();

    board.initialise();
    board.makeMove(m);
    
}