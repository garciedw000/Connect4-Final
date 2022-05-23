import java.util.Scanner;

public class Connect4 {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);

        char[][] grid = new char[6][7];

        for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                grid[row][col] = ' ';
            }
        }

        int turn = 1;
        char player = 'R';
        boolean winner = false;

        while (!winner && turn <= 42){
            boolean validPlay;
            int play;
            do {
                display(grid);

                System.out.print("Player " + player + ", choose a  WHOLE Number 0-6: ");
                play = in.nextInt();


                validPlay = validate(play,grid);

            }while (!validPlay);


            for (int row = grid.length-1; row >= 0; row--){
                if(grid[row][play] == ' '){
                    grid[row][play] = player;
                    break;
                }
            }


            winner = isWinner(player,grid);

            if (player == 'R'){
                player = 'B';
            }else{
                player = 'R';
            }

            turn++;
        }
        display(grid);

        if (winner){
            if (player=='R'){
                System.out.println("Black won");
            }else{
                System.out.println("Red won");
            }
        }else{
            System.out.println("Tie game");
        }

    }

    public static void display(char[][] grid){
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        for (char[] chars : grid) {
            System.out.print("|");
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(chars[col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println();
    }

    public static boolean validate(int column, char[][] grid){

        if (column < 0 || column > grid[0].length){
            return false;
        }


        return grid[0][column] == ' ';
    }

    public static boolean isWinner(char player, char[][] grid){

        for (char[] chars : grid) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (chars[col] == player &&
                        chars[col + 1] == player &&
                        chars[col + 2] == player &&
                        chars[col + 3] == player) {
                    return true;
                }
            }
        }

        for(int row = 0; row < grid.length - 3; row++){
            for(int col = 0; col < grid[0].length; col++){
                if (grid[row][col] == player   &&
                        grid[row+1][col] == player &&
                        grid[row+2][col] == player &&
                        grid[row+3][col] == player){
                    return true;
                }
            }
        }

        for(int row = 3; row < grid.length; row++){
            for(int col = 0; col < grid[0].length - 3; col++){
                if (grid[row][col] == player   &&
                        grid[row-1][col+1] == player &&
                        grid[row-2][col+2] == player &&
                        grid[row-3][col+3] == player){
                    return true;
                }
            }
        }

        for(int row = 0; row < grid.length - 3; row++){
            for(int col = 0; col < grid[0].length - 3; col++){
                if (grid[row][col] == player   &&
                        grid[row+1][col+1] == player &&
                        grid[row+2][col+2] == player &&
                        grid[row+3][col+3] == player){
                    return true;
                }
            }
        }
        return false;
    }
}