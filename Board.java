import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.*;
class Board{
    Space[] spaces;
    JFrame frame;
    List<Integer> currentMoves;
    int selectedSpace;
    int currentTurn = 0;
    boolean gameOver = false;
    public Board(){
       frame = new JFrame("Chess");
       spaces = new Space[64];
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       GridLayout testLayout = new GridLayout(0, 8);
       frame.setLayout(testLayout);
       frame.setSize(500,500);
       initBoardSpaces();
       frame.setVisible(true);
       initBoardPieces();
    }

    private void initBoardSpaces(){
        for (int i = 0; i<8 ; i++){
            for (int j = 0; j<8 ; j++){
                spaces[i+8*j] = new Space(i, j,this);
                frame.add(spaces[i+8*j].button);
            }
        }
    }

    private void initBoardPieces(){
        //Pawns

        for (int i=0;i<8;i++){
            spaces[6+8*i].piece = new Pawn(6,i,0,this);
            spaces[6+8*i].setIcon();
            spaces[1+8*i].piece = new Pawn(1,i,1,this);
            spaces[1+8*i].setIcon();
        }

        //Rooks
        spaces[7].piece = new Rook(7,0,0,this);
        spaces[7].setIcon();
        spaces[0].piece = new Rook(0,0,1,this);
        spaces[0].setIcon();
        spaces[7+8*7].piece = new Rook(7,7,0,this);
        spaces[7+8*7].setIcon();
        spaces[8*7].piece = new Rook(0,7,1,this);
        spaces[8*7].setIcon();

        //Knights
        spaces[7+8*1].piece = new Knight(7,1,0,this);
        spaces[7+8*1].setIcon();
        spaces[8*1].piece = new Knight(0,1,1,this);
        spaces[8*1].setIcon();
        spaces[7+8*6].piece = new Knight(7,6,0,this);
        spaces[7+8*6].setIcon();
        spaces[8*6].piece = new Knight(0,6,1,this);
        spaces[8*6].setIcon();

        //Bishops
        spaces[7+8*2].piece = new Bishop(7,2,0,this);
        spaces[7+8*2].setIcon();
        spaces[8*2].piece = new Bishop(0,2,1,this);
        spaces[8*2].setIcon();
        spaces[7+8*5].piece = new Bishop(7,5,0,this);
        spaces[7+8*5].setIcon();
        spaces[8*5].piece = new Bishop(0,5,1,this);
        spaces[8*5].setIcon();

        //Queens
        spaces[7+8*3].piece = new Queen(7,3,0,this);
        spaces[7+8*3].setIcon();
        spaces[8*3].piece = new Queen(0,3,1,this);
        spaces[8*3].setIcon();

        //Kings
        spaces[7+8*4].piece = new King(7,4,0,this);
        spaces[7+8*4].setIcon();
        spaces[8*4].piece = new King(0,4,1,this);
        spaces[8*4].setIcon();
    }

    public void resetBoardState(){
        if (currentMoves != null){
            for (Integer space:currentMoves){
                spaces[space].button.setActionCommand("show-moves");
                spaces[space].setBackground();
            }
        }
    }

    public void updateBoardState(){
        if (currentMoves != null){
            for (Integer space:currentMoves){
                spaces[space].button.setActionCommand("perform-move");
                spaces[space].button.setBackground(Color.GREEN);
            }
        }
    }

    public void nextTurn(){
        if (gameOver) currentTurn = -1;
        else currentTurn = (currentTurn == 1) ? 0 : 1;
    }

}