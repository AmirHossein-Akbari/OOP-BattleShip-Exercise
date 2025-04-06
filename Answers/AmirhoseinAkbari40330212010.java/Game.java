import java.util.Scanner;

public class Game {
    private Player player1; 
    private Player player2; 
    private boolean player1Turn; 
    private int boardSize; 

    
    public Game(int boardSize, boolean useAI) {
        this.boardSize = boardSize;
        this.player1 = new Player(boardSize);
        this.player2 = useAI ? new AIPlayer(boardSize) : new Player(boardSize);
        this.player1Turn = true;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain;
        do {
        
            resetGame();
            
            playGameLoop(scanner);
    
            playAgain = askToPlayAgain(scanner);
        } while (playAgain);
    }

    
    private void resetGame() {
        player1 = new Player(boardSize);
        player2 = new Player(boardSize);
        player1Turn = true;
        player1.placeShips(); 
        player2.placeShips(); 
    }


    private void playGameLoop(Scanner scanner) {
        while (!isGameOver()) {
            Player currentPlayer = player1Turn ? player1 : player2; 
            Player opponent = player1Turn ? player2 : player1; 
        
            System.out.println((player1Turn ? "Player 1" : "Player 2") + "'s turn:");
            opponent.getBoard().printGrid();
            
            handlePlayerAction(scanner, currentPlayer, opponent);
            player1Turn = !player1Turn;
        }
    }

    
    private void handlePlayerAction(Scanner scanner, Player currentPlayer, Player opponent) {
        System.out.println("Choose action: 1) Normal Attack 2) Radar Scan 3) Multi-Strike");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        if (choice == 1) {
        
            Coordinate coord = getValidCoordinate(scanner);
            boolean hit = currentPlayer.takeTurn(opponent, coord);
            System.out.println(hit ? "Hit!" : "Miss!");
        } else if (choice == 2) {
            SpecialAttack.radarScan(opponent.getBoard());
        } else if (choice == 3) {
        
            Coordinate coord = getValidCoordinate(scanner);
            SpecialAttack.multiStrike(opponent.getBoard(), coord.getRow(), coord.getCol());
        }
    }


    private Coordinate getValidCoordinate(Scanner scanner) {
        while (true) {
            System.out.println("Enter target coordinates (e.g., A5):");
            String input = scanner.nextLine().toUpperCase();
            if (Utils.isValidCoordinate(input, boardSize)) {
                return Utils.convertToCoordinate(input); 
            }
            System.out.println("Invalid input! Format: A-J followed by 0-9 (e.g., B7).");
        }
    }

    
    private boolean isGameOver() {
        return player1.getBoard().allShipsSunk() || player2.getBoard().allShipsSunk();
    }

    
    private boolean askToPlayAgain(Scanner scanner) {
        System.out.println("Play again? (yes/no)");
        return scanner.nextLine().equalsIgnoreCase("yes");
    }
}