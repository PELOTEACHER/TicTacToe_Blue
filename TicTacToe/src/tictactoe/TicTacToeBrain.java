package tictactoe;

/**
 * The Tic Tac Toe artificial intelligence holds the board in a double array:
 * int[3][3]
 * 
 * The tokens used are 1 for the first player and 2 for the second player.
 * 
 * Use the inverse() to change players. 
 * Use the method setBoarValue(i,j) to set a players token.
 * 
 */
public class TicTacToeBrain implements TicTacToeAble {
        /* empty */
    public static final int EMPTY = 0;
    /* player one */
    public static final int ONE = 1;
    /* player two */
    public static final int TWO = 2;
    
    //this is a change :P
    /* the board */
 private int board[][];
  
 public TicTacToeBrain() {
  board = new int[3][3];
 }

 /* get the board value for position (i,j) */
    /**
     * This method gets the boar value for the specified position.
     * 
     * @param i int the i index of the position you want
     * @param j int the j index of the position you want.
     * @return the token on the specified position.
     */
    @Override
 public int getBoardValue(int i,int j) {
  if(i < 0 || i >= 3) return EMPTY;
  if(j < 0 || j >= 3) return EMPTY;
  return board[i][j];
    }

 
    /**
     * This method sets the board value for position (i,j) 
     * @param i
     * @param j
     * @param token
     */
    @Override
 public void setBoardValue(int i,int j,int token) {
  if(i < 0 || i >= 3) return;
  if(j < 0 || j >= 3) return;
  board[i][j] = token;
    }

 /* calculate the winning move for current token */
    /**
     * This method calculate the winning move for current token
     * @param token
     * @return
     */
    @Override
 public int []nextWinningMove(int token) {

  for(int i=0;i<3;i++)
   for(int j=0;j<3;j++)
    if(getBoardValue(i, j)==EMPTY) {
     board[i][j] = token;
     boolean win = isWin(token);
     board[i][j] = EMPTY;
     if(win) return new int[]{i,j};
    }

  return null;
    }

    
    /**
     * This method changes player. It changes the token,
     * @param token int 1 or 2. The players token.
     * @return int if 1 then 2 is return otherwise 1.
     */
    @Override
    public int inverse(int token) {
  return token==ONE ? TWO : ONE;
 }

  
    /**
     * This method calculates the best move for current token.
     * It looks to see if the center is available and if not 
     * it checks to see if the computer can move next turn. 
     * If not then blok the player from winning.
     * 
     * @param token int 1 or 2. The players token.
     * @return null if no move is available or an int array with 2 values:
     * the i and j index of the next move.
     * */
    @Override
    public int[] nextMove(int token) {

        /* lucky position in the center of board*/
        if(getBoardValue(1, 1)==EMPTY) return new int[]{1,1};

        /* if we can move on the next turn */
        int winMove[] = nextWinningMove(token);
        if(winMove!=null) return winMove;

        /* choose the move that prevent enemy to win */
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(getBoardValue(i, j)==EMPTY)
                {
                    board[i][j] = token;
              boolean ok = nextWinningMove(inverse(token)) == null;
                    board[i][j] = EMPTY;
                    if(ok) return new int[]{i,j};
                }

        /* choose available move */
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(getBoardValue(i, j)==EMPTY)
                    return new int[]{i,j};

        /* no move is available */
        return null;
    }


    /**
     * This method determine if current token is win or not a win.
     * @param token int 1 or 2. The players token.
     * @return
     */
    @Override
 public boolean isWin(int token) {
  final int DI[]={-1,0,1,1};
  final int DJ[]={1,1,1,0};
  for(int i=0;i<3;i++)
   for(int j=0;j<3;j++) {

    /* we skip if the token in position(i,j) is not equal to current token */
    if(getBoardValue(i, j)!=token) continue;

    for(int k=0;k<4;k++) {
     int ctr = 0;
                 while(getBoardValue(i+DI[k]*ctr, j+DJ[k]*ctr)==token) ctr++;

     if(ctr==3) return true;
    }
  }
  return false;
    }
} 