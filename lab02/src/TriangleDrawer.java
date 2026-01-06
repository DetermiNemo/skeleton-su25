public class TriangleDrawer {

    public static void drawTriangle() {
        int SIZE = 5;
        int row = 0;
        int col = 0;
        while (row < SIZE) {
            while (col < row) {
                System.out.print('*');
                col += 1;
            }
            System.out.println('*');
            row += 1;
            col = 0;
        }
    }
    public static void main(String[] args) {
        drawTriangle();
    }
}