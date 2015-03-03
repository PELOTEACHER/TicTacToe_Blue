
package tictactoe;

/**
 *
 * 
 */
public interface TicTacToeAble {

    /* get the board value for position (i,j) */
    /**
     * This method gets the boar value for the specified position.
     *
     * @param i int the i index of the position you want
     * @param j int the j index of the position you want.
     * @return the token on the specified position.
     */
    int getBoardValue(int i, int j);

    /**
     * This method changes player. It changes the token,
     * @param token int 1 or 2. The players token.
     * @return int if 1 then 2 is return otherwise 1.
     */
    int inverse(int token);

    /**
     * This method determine if current token is win or not a win.
     * @param token int 1 or 2. The players token.
     * @return
     */
    boolean isWin(int token);

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
    int[] nextMove(int token);

    /* calculate the winning move for current token */
    /**
     * This method calculate the winning move for current token
     * @param token
     * @return
     */
    int[] nextWinningMove(int token);

    /**
     * This method sets the board value for position (i,j)
     * @param i
     * @param j
     * @param token
     */
    void setBoardValue(int i, int j, int token);
    
}
