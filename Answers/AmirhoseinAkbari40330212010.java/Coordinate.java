public class Coordinate {
    private int row;
    private int col; 
    public Coordinate(String input) {
        this.row = input.charAt(1) - '0'; 
        this.col = input.charAt(0) - 'A';
    }

    
    public int getRow() { return row; }
    public int getCol() { return col; }
}