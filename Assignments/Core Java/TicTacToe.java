import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static boolean checkWin(char[][] grid){
        for(int i=0 ; i< grid.length ; i++){
            if(grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][0] != '\u0000'){
                if(grid[i][0] == 'O'){
                    System.out.println("Player 2 won.");
                }
                else{
                    System.out.println("player 1 won");
                }
                return true;
            }
        }
        for(int i=0 ; i< grid[0].length ; i++){
            if(grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[0][i] != '\u0000'){
                if(grid[0][i] == 'O'){
                    System.out.println("Player 2 won.");
                }
                else{
                    System.out.println("player 1 won");
                }
                return true;
            }
        }
        if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != '\u0000') {
            if (grid[0][0] == 'X'){
                System.out.println("Player 1 won");
            }
            else{
                System.out.println("Player 2 won");
            }
            return true;
        }
        else if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != '\u0000') {
            if (grid[0][2] == 'X'){
                System.out.println("Player 1 won");
            }
            else{
                System.out.println("Player 2 won");
            }
            return true;
        }
        return false;
    }
    public static void printBoard(char[][] grid){
        for (char[] chars : grid) {
            System.out.println(Arrays.toString(chars));
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char turn = '1';
        char[][] grid = new char[3][3];
        int[] input = new int[2];
        int count =0;
        char sign = ' ';
        while(count < 9 && !checkWin(grid)){

            if(turn == '1'){
                turn = '2';
                sign = 'O';
            }
            else{
                turn = '1';
                sign = 'X';
            }
            System.out.println("Player " + turn +" chance :-" );
            input[0] = sc.nextInt();
            input[1] = sc.nextInt();
            if(input[0] >= 3 || input[1] >= 3 || grid[input[0]][input[1]] != '\u0000'){
                System.out.println("invalid index entered");

                if(turn == '1'){
                    turn = '2';
                }
                else{
                    turn = '1';
                }
                count--;
                continue;

            }
            count++;
            grid[input[0]][input[1]] = sign;
            System.out.println("Updated Board :- ");
            printBoard(grid);


        }
    }
}
