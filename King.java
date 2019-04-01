import javax.swing.ImageIcon;
import java.util.*;

class King extends Piece{
    public King(int x, int y, int team, Board board){
        super(x,y,team,board);
        if (team == 0) this.icon = new ImageIcon("Icons/king-black.png");
        else if (team == 1) this.icon = new ImageIcon("Icons/king-white.png");
    }

    public List<Integer> possibleMoves(){
        List<Integer> moveList = new ArrayList<Integer>();
        int newx,newy;
        for (int i=-1;i<=1;i++){
            for (int j=-1;j<=1;j++){
                if (i==0 && j==0) continue;
                newx = x+i;
                newy = y+j;
                if (newx < 8 && newy < 8 && newx >= 0 && newy >= 0){
                    if (checkFriendly(newx, newy) != 1) moveList.add(newx+8*newy);
                }
            }
        }
        return moveList;
    }
}