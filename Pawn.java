import javax.swing.ImageIcon;
import java.util.*;

class Pawn extends Piece{
    int startX;
    public Pawn(int x, int y, int team, Board board){
        super(x,y,team,board);
        startX = x;
        if (team == 0) this.icon = new ImageIcon("Icons/pawn-black.png");
        else if (team == 1) this.icon = new ImageIcon("Icons/pawn-white.png");
    }

    public List<Integer> possibleMoves(){
        List<Integer> moveList = new ArrayList<Integer>();
        int newx,newy;
        if (team == 1){
            newx = x+1;
            if (newx < 8){
                if (checkFriendly(newx, y) == 0) moveList.add(newx+8*y);
                newy = y+1;
                if (newy < 8) {
                    if (checkFriendly(newx, newy) == -1) moveList.add(newx+8*newy);
                }
                newy = y-1;
                if (newy >= 0) {
                    if (checkFriendly(newx, newy) == -1) moveList.add(newx+8*newy);
                }
            }
            if (x == startX){
                newx = x+2;
                if (newx < 8) {
                    if (checkFriendly(newx, y) == 0) moveList.add(newx+8*y);
                }
            }
        }
        else if (team == 0){
            newx = x-1;
            if (newx >= 0){
                if (checkFriendly(newx, y) == 0) moveList.add(newx+8*y);
                newy = y+1;
                if (newy < 8) {
                    if (checkFriendly(newx, newy) == -1) moveList.add(newx+8*newy);
                }
                newy = y-1;
                if (newy >= 0) {
                    if (checkFriendly(newx, newy) == -1) moveList.add(newx+8*newy);
                }
            }
            if (x == startX){
                newx = x-2;
                if (newx >= 0) {
                    if (checkFriendly(newx, y) == 0) moveList.add(newx+8*y);
                }
            }
        }
        return moveList;
    }
}