package com.dev.beans;

import com.dev.Exceptions.CellAlreadyOccupiedException;
import com.dev.Exceptions.OutOfDimensionException;
import com.dev.strategies.winning.WinningStrategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Player> players;

    private Board board;

    private int nextPlayer;

    private int dimension;

    private List<Move> moves;

    private Move move;

    private Player winner;

    private GameState gameState;

    Scanner sc = new Scanner(System.in);

    private List<WinningStrategies> winningStrategies;
    public Game(List<WinningStrategies> winningStrategies, List<Player> players, int dimension){
        this.gameState = GameState.INPROGRESS;
        this.board = new Board(dimension);
        this.moves = new ArrayList<>();
        this.dimension = dimension;
        this.move = null;
        this.winner = null;
        this.winningStrategies = winningStrategies;
        this.players = players;
        this.nextPlayer = 0;
    }

    public static GameBuilder getBuilder(){
        return new GameBuilder();
    }

    public static class GameBuilder{
        private List<WinningStrategies> winningStrategies;

        private List<Player> players;

        private int dimension;

        public GameBuilder setWinningStrategies(List<WinningStrategies> winningStrategies){
            this.winningStrategies = winningStrategies;
            return this;
        }

        public GameBuilder setPlayers(List<Player> players){
            this.players = players;
            return this;
        }
        public GameBuilder setDimension(int dimension){
            this.dimension = dimension;
            return this;
        }

        public Game build(){
            return new Game(winningStrategies, players,dimension);
        }

    }

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public int getNextPlayer() {
        return nextPlayer;
    }

    public int getDimension() {
        return dimension;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Move getMove() {
        return move;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public List<WinningStrategies> getWinningStrategies() {
        return winningStrategies;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setNextPlayer(int nextPlayer) {
        this.nextPlayer = nextPlayer;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setWinningStrategies(List<WinningStrategies> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public void printBoard(){

        board.printBoard();
    }

    public void makeMove() throws OutOfDimensionException, CellAlreadyOccupiedException {


        if (!moves.isEmpty()){
            System.out.print("Would you like to undo this move Y/N");
            String ch = sc.nextLine();

            if(ch.equals("Y")){
                int last = moves.size()-1;

                Move undoMove = moves.get(last);
                moves.remove(last);
                Cell cell = board.getBoard().get(undoMove.getRow()).get(undoMove.getCol());
                cell.setPlayer(null);
                cell.setSymbol(null);
                cell.setCellState(CellState.EMPTY);
            }

        }


        Player currentPlayer = players.get(nextPlayer);
        System.out.print("Next Player is " + currentPlayer.getName() + " please make a move");

        Move currentMove = currentPlayer.makeMove(board);

        validateMove(currentMove);

        Cell cell = populateCell(currentMove);
        cell.setCellState(CellState.FULL);
        cell.setPlayer(players.get(nextPlayer));
        cell.setSymbol(currentPlayer.getSymbol());
        //Check Winner

        for(WinningStrategies winningStrategy : winningStrategies){
            if(winningStrategy.isWinning(board,currentMove)){
                gameState = GameState.WIN;
                winner = currentPlayer;
                return;
            }
        }

        //Check Draw

        if(moves.size() == dimension * dimension){
            gameState = GameState.DRAW;
            return;
        }

        //Update Next Player index
        nextPlayer += 1;
        nextPlayer %= players.size();

        //Update List Of moves

        moves.add(currentMove);


    }

    public void validateMove(Move move) throws OutOfDimensionException, CellAlreadyOccupiedException {
        // Validate its inside the dimension

        validateDimension(move);
        // validate its the cell is not occupied
        validateCell(move);
    }

    public void validateDimension(Move move) throws OutOfDimensionException {
        if(move.getCol() >= dimension || move.getRow() >= dimension){
            throw new OutOfDimensionException();
        }
    }

    public void validateCell(Move move) throws CellAlreadyOccupiedException {
        if(board.getBoard().get(move.getRow()).get(move.getCol()).
                getCellState().equals(CellState.FULL)){
            throw new CellAlreadyOccupiedException();
        }
    }

    public Cell populateCell(Move move){
        Cell cell = board.getBoard().get(move.getRow())
                .get(move.getCol());
        return  cell;
    }
}
