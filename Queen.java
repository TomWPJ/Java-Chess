import javax.swing.ImageIcon;
import java.util.*;

class Queen extends Piece{
    public Queen(int x, int y, int team, Board board){
        super(x,y,team,board);
        if (team == 0) this.icon = new ImageIcon("Icons/queen-black.png");
        else if (team == 1) this.icon = new ImageIcon("Icons/queen-white.png");
    }

    public List<Integer> possibleMoves(){
        List<Integer> moveList = new ArrayList<Integer>();
        int newx, newy;
        //Straight
        for (int i=1;i<8;i++){
            newx = x+i;
            if (newx < 8){
                if (checkFriendly(newx, y) != 1){
                    moveList.add(newx+8*y);
                    if (checkFriendly(newx, y) == -1) break;
                }
                else break;
            }
            else break;
        }
        for (int i=1;i<8;i++){
            newx = x-i;
            if (newx >= 0){
                if (checkFriendly(newx, y) != 1){
                    moveList.add(newx+8*y);
                    if (checkFriendly(newx, y) == -1) break;
                }
                else break;
            }
            else break;
        }
        for (int i=1;i<8;i++){
            newy = y+i;
            if (newy < 8){
                if (checkFriendly(x, newy) != 1){
                    moveList.add(x+8*newy);
                    if (checkFriendly(x, newy) == -1) break;
                }
                else break;
            }
            else break;
        }
        for (int i=1;i<8;i++){
            newy = y-i;
            if (newy >= 0){
                if (checkFriendly(x, newy) != 1){
                    moveList.add(x+8*newy);
                    if (checkFriendly(x, newy) == -1) break;
                }
                else break;
            }
            else break;
        }

        //Diagonal
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