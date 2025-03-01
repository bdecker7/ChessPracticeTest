package chess;

import java.util.ArrayList;

public class BishopMoves implements PieceMovesCalculator{
    private ChessBoard board;
    private ChessPosition currentPosition;
    int x = 1;
    public BishopMoves(ChessBoard board, ChessPosition currentPosition){
        this.board = board;
        this.currentPosition = currentPosition;
    }

    public ArrayList<ChessMove> diagonalMoves(int x, int y){
        ChessPiece ghostBishop;
        ChessPosition listedPosition;
        ChessMove movedPosition;

        ArrayList<ChessMove> movedList = new ArrayList<ChessMove>();

        while(currentPosition.getRow()+x <= 8 && currentPosition.getColumn()+y>0 && currentPosition.getRow()+x > 0 && currentPosition.getColumn()+y<=8){
            listedPosition = new ChessPosition(currentPosition.getRow()+x,currentPosition.getColumn()+y);
            ghostBishop = board.getPiece(listedPosition);
            if(ghostBishop == null){
                movedPosition = new ChessMove(currentPosition,listedPosition,null);
                movedList.add(movedPosition);
            }else if(ghostBishop.getTeamColor() != board.getPiece(currentPosition).getTeamColor()){
                movedPosition = new ChessMove(currentPosition,listedPosition,null);
                movedList.add(movedPosition);
                break;
            }else{break;}


            if (x>0){
                x += 1;
            }else{
                x = x-1;
            }
            if (y>0){
                y += 1;
            }else{
                y = y-1;
            }
        }

        return movedList;
    }


    @Override
    public ArrayList<ChessMove> validMoves() {


        ArrayList<ChessMove> movedListFinal = new ArrayList<ChessMove>();

        if(diagonalMoves(1,1) != null){
            movedListFinal.addAll(diagonalMoves(1,1));
        }if(diagonalMoves(-1,-1) != null){
            movedListFinal.addAll(diagonalMoves(-1,-1));
        }if(diagonalMoves(-1,1) != null){
            movedListFinal.addAll(diagonalMoves(-1,1));
        }if(diagonalMoves(1,-1) != null){
            movedListFinal.addAll(diagonalMoves(1,-1));
        }


        return movedListFinal;
    }
}
