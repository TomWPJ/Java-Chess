import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

class Space{
    Board board;
    Piece piece;
    JButton button;
    int x;
    int y;
    List<Integer> possibleMoves;
    public Space(int x, int y, Board board){
        this.x = x;
        this.y = y;
        button = new JButton();
        button.setActionCommand("show-moves");
        setBackground();
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("show-moves".equals(e.getActionCommand())){
                    board.spaces[board.selectedSpace].button.setActionCommand("show-moves");
                    board.resetBoardState();
                    if (piece != null) {
                        if (board.currentTurn == piece.team){
                            board.currentMoves = piece.possibleMoves();
                            board.updateBoardState();
                            board.selectedSpace = x+8*y;
                            button.setActionCommand("stop-showing-moves");
                        }
                    }
                }
                else if ("stop-showing-moves".equals(e.getActionCommand())){
                    board.resetBoardState();
                    button.setActionCommand("show-moves");
                }
                else if ("perform-move".equals(e.getActionCommand())){
                    if (piece instanceof King) {
                        board.gameOver = true;
                    }
                    board.resetBoardState();
                    if (board.spaces[board.selectedSpace].piece instanceof Pawn){
                        if (board.spaces[board.selectedSpace].piece.team == 1 && x == 7){
                            piece = new Queen(x,y,1,board);
                        }
                        else if (board.spaces[board.selectedSpace].piece.team == 0 && x == 0){
                            piece = new Queen(x,y,0,board);
                        }
                        else{
                            piece = board.spaces[board.selectedSpace].piece;
                            piece.updateCoords(x,y);
                        }
                    }
                    else{
                        piece = board.spaces[board.selectedSpace].piece;
                        piece.updateCoords(x,y);
                    }
                    board.spaces[board.selectedSpace].piece = null;
                    board.resetBoardState();
                    setIcon();
                    board.spaces[board.selectedSpace].setIcon();
                    board.nextTurn();
                }
            }
        });
    }

    public void setIcon(){
        if (piece != null) button.setIcon(piece.icon);
        else button.setIcon(null);
    }

    public void setBackground(){
        if ((x % 2) == 0) {
            if ((y % 2) == 0){
                button.setBackground(Color.LIGHT_GRAY);
            }
            else {
                button.setBackground(Color.WHITE);
            }
        }
        else {
            if ((y % 2) == 0){
                button.setBackground(Color.WHITE);
            }
            else {
                button.setBackground(Color.LIGHT_GRAY);
            }
        }
    }
    
}