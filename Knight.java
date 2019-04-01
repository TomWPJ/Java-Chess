import javax.swing.ImageIcon;
import java.util.*;

class Knight extends Piece{
    public Knight(int x, int y, int team, Board board){
        super(x,y,team,board);
        if (team == 0) this.icon = new ImageIcon("Icons/knight-black.png");
        else if (team == 1) this.icon = new ImageIcon("Icons/knight-white.png");
    }

    public List<Integer> possibleMoves(){
        List<Integer> moveList = new ArrayList<Integer>();
        int newx,newy;
        newx = x+2;
        if (newx < 8){
            newy = y+1;
            if (newy < 8){
                if (checkFriendly(newx, newy) != 1) moveList.add(newx+8*newy);
            }
            newy = y-1;
            if (newy >= 0){
                if (checkFriendly(newx, newy) != 1) moveList.add(newx+8*newy);
            }
        }
        newx = x-2;
        if (newx >= 0){
            newy = y+1;
            if (newy < 8){
                if (checkFriendly(newx, newy) != 1) moveList.add(newx+8*newy);
            }
            newy = y-1;
            if (newy >= 0){
                if (checkFriendly(newx, newy) != 1) moveList.add(newx+8*newy);
            }
        }
        newx = x+1;
        if (newx < 8){
            newy = y+2;
            if (newy < 8){
                if (checkFriendly(newx, newy) != 1) moveList.add(newx+8*newy);
            }
            newy = y-2;
            if (newy >= 0){
                if (checkFriendly(newx, newy) != 1) moveList.add(newx+8*newy);
            }
        }
        newx = x-1;
        if (newx >= 0){
            newy = y+2;
            if (newy < 8){
                if (checkFriendly(newx, newy) != 1) moveList.add(newx+8*newy);
            }
            newy = y-2;
            if (newy >= 0){
                if (checkFriendly(newx, newy) != 1) moveList.add(newx+8*newy);
            }
        }
        return moveList;
    }
}