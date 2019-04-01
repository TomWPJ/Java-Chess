import javax.swing.ImageIcon;
import java.util.*;

class Bishop extends Piece{
    public Bishop(int x, int y, int team, Board board){
        super(x,y,team,board);
        if (team == 0) this.icon = new ImageIcon("Icons/bishop-black.png");
        else if (team == 1) this.icon = new ImageIcon("Icons/bishop-white.png");
    }

    public List<Integer> possibleMoves(){
        List<Integer> moveList = new ArrayList<Integer>();
        int newx, newy;
        for (int i=1;i<8;i++){
            newx = x+i;
            newy = y+i;
            if (newx < 8 && newy < 8){
                if (checkFriendly(newx, newy) != 1){
                    moveList.add(newx+8*newy);
                    if (checkFriendly(newx, newy) == -1) break;
                }
                else break;
            }
            else break;
        }
        for (int i=1;i<8;i++){
            newx = x+i;
            newy = y-i;
            if (newx < 8 && newy >= 0){
                if (checkFriendly(newx, newy) != 1){
                    moveList.add(newx+8*newy);
                    if (checkFriendly(newx, newy) == -1) break;
                }
                else break;
            }
            else break;
        }
        for (int i=1;i<8;i++){
            newx = x-i;
            newy = y-i;
            if (newx >= 0 && newy >= 0){
                if (checkFriendly(newx, newy) != 1){
                    moveList.add(newx+8*newy);
                    if (checkFriendly(newx, newy) == -1) break;
                }
                else break;
            }
            else break;
        }
        for (int i=1;i<8;i++){
            newx = x-i;
            newy = y+i;
            if (newx >= 0 && newy < 8){
                if (checkFriendly(newx, newy) != 1){
                    moveList.add(newx+8*newy);
                    if (checkFriendly(newx, newy) == -1) break;
                }
                else break;
            }
            else break;
        }
        return moveList;
    }
}