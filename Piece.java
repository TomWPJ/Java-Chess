import javax.swing.ImageIcon;
import java.util.*;

abstract class Piece{
    Board board;
    int x;
    int y;
    int team;
    ImageIcon icon;

    public Piece(int x, int y, int team, Board board){
        this.x = x;
        this.y = y;
        this.team = team;
        this.board = board;
    }

    public int checkFriendly(int newx,int newy){
        if (board.spaces[newx+8*newy].piece == null) return 0;
        else {
            if (board.spaces[newx+8*newy].piece.team != team) return -1;
            return 1;
        }
    }

    public void updateCoords(int x, int y){
        this.x = x;
        this.y = y;
    }

    public abstract List<Integer> possibleMoves();
}