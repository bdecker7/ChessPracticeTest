package chess;

import java.util.ArrayList;

public class PawnMoves implements PieceMovesCalculator {
    ChessBoard board;
    ChessPosition currentPosition;
    public PawnMoves(ChessBoard board, ChessPosition currentPosition) {
        this.board = board;
        this.currentPosition = currentPosition;
    }

        public ArrayList<ChessMove> helperMoves (int x, int y){
            ChessPiece ghostPawn;
            ChessPosition listedPosition;
            ChessMove movedPosition1;
            ChessMove movedPosition2;
            ChessMove movedPosition3;
            ChessMove movedPosition4;

            ArrayList<ChessMove> movedList = new ArrayList<ChessMove>();

            if (currentPosition.getRow() + x <= 8 && currentPosition.getColumn() + y > 0 && currentPosition.getRow() + x > 0 && currentPosition.getColumn() + y <= 8) {
                listedPosition = new ChessPosition(currentPosition.getRow() + x, currentPosition.getColumn() + y);
                ghostPawn = board.getPiece(listedPosition);
                if(listedPosition.getRow() == 8 && board.getPiece(currentPosition).getTeamColor() == ChessGame.TeamColor.WHITE){
                    movedPosition1 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.KNIGHT);
                    movedPosition2 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.ROOK);
                    movedPosition3 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.QUEEN);
                    movedPosition4 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.BISHOP);

                    movedList.add(movedPosition1);
                    movedList.add(movedPosition2);
                    movedList.add(movedPosition3);
                    movedList.add(movedPosition4);
                    return movedList;

                }if(listedPosition.getRow() == 1 && board.getPiece(currentPosition).getTeamColor() == ChessGame.TeamColor.BLACK){
                    movedPosition1 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.KNIGHT);
                    movedPosition2 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.ROOK);
                    movedPosition3 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.QUEEN);
                    movedPosition4 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.BISHOP);

                    movedList.add(movedPosition1);
                    movedList.add(movedPosition2);
                    movedList.add(movedPosition3);
                    movedList.add(movedPosition4);
                    return movedList;

                }else if (ghostPawn == null) {
                    movedPosition1 = new ChessMove(currentPosition, listedPosition, null);
                    movedList.add(movedPosition1);
                    return movedList;
                }
            }
            return null;
        }

    public ArrayList<ChessMove> diagonalMoves (int x, int y) {
        ChessPiece ghostPawn;
        ChessPosition listedPosition;
        ChessMove movedPosition1;
        ChessMove movedPosition2;
        ChessMove movedPosition3;
        ChessMove movedPosition4;

        ArrayList<ChessMove> movedList = new ArrayList<ChessMove>();

        if (currentPosition.getRow() + x <= 8 && currentPosition.getColumn() + y > 0 && currentPosition.getRow() + x > 0 && currentPosition.getColumn() + y <= 8) {
            listedPosition = new ChessPosition(currentPosition.getRow() + x, currentPosition.getColumn() + y);
            ghostPawn = board.getPiece(listedPosition);
            if ((ghostPawn != null) && ghostPawn.getTeamColor() != board.getPiece(currentPosition).getTeamColor()) {
                if (listedPosition.getRow() == 8 && board.getPiece(currentPosition).getTeamColor() == ChessGame.TeamColor.WHITE) {
                    movedPosition1 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.KNIGHT);
                    movedPosition2 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.ROOK);
                    movedPosition3 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.QUEEN);
                    movedPosition4 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.BISHOP);

                    movedList.add(movedPosition1);
                    movedList.add(movedPosition2);
                    movedList.add(movedPosition3);
                    movedList.add(movedPosition4);
                    return movedList;

                }
                if (listedPosition.getRow() == 1 && board.getPiece(currentPosition).getTeamColor() == ChessGame.TeamColor.BLACK) {
                    movedPosition1 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.KNIGHT);
                    movedPosition2 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.ROOK);
                    movedPosition3 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.QUEEN);
                    movedPosition4 = new ChessMove(currentPosition, listedPosition, ChessPiece.PieceType.BISHOP);

                    movedList.add(movedPosition1);
                    movedList.add(movedPosition2);
                    movedList.add(movedPosition3);
                    movedList.add(movedPosition4);
                    return movedList;
                }else{
                    movedPosition1 = new ChessMove(currentPosition, listedPosition, null);
                    movedList.add(movedPosition1);
                    return movedList;
                }
            }
        }
        return null;
    }

        @Override
        public ArrayList<ChessMove> validMoves () {
            ArrayList<ChessMove> movedListFinal = new ArrayList<ChessMove>();

            if(board.getPiece(currentPosition).getTeamColor() == ChessGame.TeamColor.WHITE) {


                if (helperMoves(1, 0) != null) {
                    movedListFinal.addAll(helperMoves(1, 0));
                    if (helperMoves(2, 0) != null && currentPosition.getRow() == 2) {
                        movedListFinal.addAll(helperMoves(2, 0));
                    }
                }
                if (diagonalMoves(1, 1) != null) {
                    movedListFinal.addAll(diagonalMoves(1, 1));
                }
                if (diagonalMoves(1, -1) != null) {
                    movedListFinal.addAll(diagonalMoves(1, -1));
                }


            }else if(board.getPiece(currentPosition).getTeamColor() == ChessGame.TeamColor.BLACK) {


                if (helperMoves(-1, 0) != null) {
                    movedListFinal.addAll(helperMoves(-1, 0));
                    if (helperMoves(-2, 0) != null && currentPosition.getRow() == 7) {
                        movedListFinal.addAll(helperMoves(-2, 0));
                    }
                }
                if (diagonalMoves(-1, -1) != null) {
                    movedListFinal.addAll(diagonalMoves(-1, -1));
                }
                if (diagonalMoves(-1, 1) != null) {
                    movedListFinal.addAll(diagonalMoves(-1, 1));
                }
    }
            return movedListFinal;
}
}
