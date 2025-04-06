public class Board {
    private int size; 
    private char[][] grid;  
    private Ship[][] ships; 

    
    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size]; 
        this.ships = new Ship[size][size]; 
        initializeGrid(); 
    }

    
    private void initializeGrid() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = '~'; 
            }
        }
    }


    public boolean placeShip(Ship ship, int row, int col, boolean horizontal) {
        if (canPlaceShip(row, col, ship.getSize(), horizontal)) { 
            for (int i = 0; i < ship.getSize(); i++) { 
                if (horizontal) { 
                    grid[row][col + i] = 's'; 
                    ships[row][col + i] = ship; 
                } else { 
                    grid[row + i][col] = 's';
                    ships[row + i][col] = ship;
                }
            }
            return true; 
        }
        return false; 
    }

    
    private boolean canPlaceShip(int row, int col, int shipSize, boolean horizontal) {
        if (horizontal) { 
            if (col + shipSize > size) return false; 
            for (int i = 0; i < shipSize; i++) { 
                if (grid[row][col + i] != '~') return false; 
            }
        } else {
            if (row + shipSize > size) return false;
            for (int i = 0; i < shipSize; i++) {
                if (grid[row + i][col] != '~') return false;
            }
        }
        return true; 
    }

    
    public boolean receiveAttack(Coordinate coord) {
        int row = coord.getRow(); 
        int col = coord.getCol(); 

        if (grid[row][col] == 's') { 
            grid[row][col] = 'X'; 
            ships[row][col].takeDamage(); 
            return true;
        } else {
            grid[row][col] = 'O'; 
            return false; 
        }
    }

    
    public boolean allShipsSunk() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] == 's') return false; 
            }
        }
        return true; 
    }

    
    public void printGrid() {
        System.out.print("  "); 
    
        for (char c = 'A'; c < 'A' + size; c++) {
            System.out.print(c + " ");
        }
        System.out.println();

        
        for (int row = 0; row < size; row++) {
            System.out.print(row + " "); 
            for (int col = 0; col < size; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println(); 
        }
    }

    
    public int getSize() { return size; }
    public char[][] getGrid() { return grid; }
}