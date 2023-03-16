package tictactoe;

public class TicTacToe {
    private int[][] map = new int[3][3];

    TicTacToe(){

    }

    public int place(int p, int r, int c){
        if(this.map[r][c] == 1 || this.map[r][c] == 2){
            return 3;
        }
        this.map[r][c] = p;
        if(this.map[r][0] == p && this.map[r][1] == p && this.map[r][2] == p){
            return p;
        }
        if(this.map[0][c] == p && this.map[1][c] == p && this.map[2][c] == p){
            return p;
        }
        if(this.map[0][0] == p && this.map[1][1] == p && this.map[2][2] == p){
            return p;
        }
        if(this.map[0][2] == p && this.map[1][1] == p && this.map[2][0] == p){
            return p;
        }
        return 0;
    }
}
