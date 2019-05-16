package leetcode.hashTable;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/*
 * Determine if a 9x9 Sudoku board is valid. O
 * nly the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class _0036_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; ++i){
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            Set<Character> boxSet = new HashSet<>();

            for(int j = 0; j < 9; ++j){
                if(board[i][j] != '.' && !rowSet.add(board[i][j]))
                    return false;
                if(board[j][i] != '.' && !colSet.add(board[j][i]))
                    return false;
                int rowIndex = (i / 3) * 3;
                int colIndex = (i % 3) * 3;
                //System.out.println("i = " + i + " j = " + j);
                //System.out.println("rowIndex: " + (rowIndex + j / 3) + " colIndex: " + (colIndex + j % 3));
                if(board[rowIndex + j / 3][colIndex + j % 3] != '.'
                        && !boxSet.add(board[rowIndex + j / 3][colIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(board));
    }
}
