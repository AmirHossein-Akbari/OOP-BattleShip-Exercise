public class Ship {
    private int size;   
    private int health;

    
    public Ship(int size) {
        this.size = size;
        this.health = size; 
    }

    
    public void takeDamage() {
        if (health > 0) health--; 
    }

    
    public boolean isSunk() {
        return health == 0; 
    }

    
    public int getSize() { return size; }
    public int getHealth() { return health; }
}