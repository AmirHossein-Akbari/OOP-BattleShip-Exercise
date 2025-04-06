public class Main {
    public static void main(String[] args) {
        int boardSize = 10; // تنظیم اندازه صفحه.
        boolean useAI = true; // فعال/غیرفعال کردن هوش مصنوعی.
        Game game = new Game(boardSize, useAI); // ایجاد شیء بازی.
        game.start(); // شروع بازی.
    }
}

