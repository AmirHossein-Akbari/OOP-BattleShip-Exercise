import java.util.Random;

public class AIPlayer extends Player {
    private Random rand; 

    
    public AIPlayer(int boardSize) {
        super(boardSize);
        this.rand = new Random();
    }


    @Override
    public boolean takeTurn(Player opponent, Coordinate coord) {
        int row = rand.nextInt(getBoard().getSize()); 
        int col = rand.nextInt(getBoard().getSize()); 
        coord = new Coordinate("" + (char) ('A' + col) + row); 
        return super.takeTurn(opponent, coord); 
    }
}