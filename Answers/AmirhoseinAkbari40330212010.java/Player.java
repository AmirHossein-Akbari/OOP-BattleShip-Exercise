import java.util.Random;

public class Player {
    private Board board; 
    private Board trackingBoard; 
    private Random rand;


    public Player(int boardSize) {
        this.board = new Board(boardSize);
        this.trackingBoard = new Board(boardSize);
        this.rand = new Random();
    }

    
    public Board getBoard() { return board; }
    public Board getTrackingBoard() { return trackingBoard; }

    
    public void placeShips() {
        int[] shipSizes = {5, 4, 3, 2}; 
        for (int size : shipSizes) { 
            boolean placed = false;
            while (!placed) { 
                int row = rand.nextInt(board.getSize()); 
                int col = rand.nextInt(board.getSize()); 
                boolean horizontal = rand.nextBoolean();
                
                placed = board.placeShip(new Ship(size), row, col, horizontal);
            }
        }
    }

    
    public boolean takeTurn(Player opponent, Coordinate coord) {
        boolean hit = opponent.getBoard().receiveAttack(coord); 
        trackingBoard.receiveAttack(coord); 
        return hit; 
    }


    public void printGameStatus() {
        System.out.println("Your board:");
        board.printGrid();
        System.out.println("Tracking board:");
        trackingBoard.printGrid();
        Utils.printRemainingShips(board); 
    }
}