public class Utils {

    
    public static boolean isValidCoordinate(String input, int boardSize) {
        if (input == null || input.length() != 2) {
            System.out.println("Invalid input! Coordinates must be exactly 2 characters long (e.g., A5).");
            return false;
        }

        char colChar = input.charAt(0); 
        char rowChar = input.charAt(1); 


        return (colChar >= 'A' && colChar < 'A' + boardSize) && (rowChar >= '0' && rowChar < '0' + boardSize);
    }

    
    public static void printRemainingShips(Board board) {
        int remainingShips = 0;
        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                if (board.getGrid()[row][col] == 's') { 
                    remainingShips++;
                }
            }
        }
        System.out.println("Remaining ships: " + remainingShips);
    }

    
    public static String convertToCoordinateString(int row, int col) {
        return "" + (char) ('A' + col) + row;
    }

    public static Coordinate convertToCoordinate(String input) {
        return new Coordinate(input);
    }
}
