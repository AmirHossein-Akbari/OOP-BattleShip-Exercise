public class SpecialAttack {
    
    public static void radarScan(Board enemyBoard) {
        System.out.println("Radar scan activated!");
        for (int row = 0; row < enemyBoard.getSize(); row++) {
            for (int col = 0; col < enemyBoard.getSize(); col++) {
                if (enemyBoard.getGrid()[row][col] == 's') { 
                    System.out.println("Ship detected at: " + (char) ('A' + col) + row); // نمایش مختصات کشتی.
                }
            }
        }
    }

    
    public static void multiStrike(Board enemyBoard, int targetRow, int targetCol) {
        System.out.println("Multi-Strike attack!");
        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) { 
            for (int colOffset = -1; colOffset <= 1; colOffset++) { 
                int newRow = targetRow + rowOffset; 
                int newCol = targetCol + colOffset; 
                
                if (newRow >= 0 && newRow < enemyBoard.getSize() && newCol >= 0 && newCol < enemyBoard.getSize()) {
                    enemyBoard.receiveAttack(new Coordinate("" + (char) ('A' + newCol) + newRow)); // حمله به سلول.
                }
            }
        }
    }
}