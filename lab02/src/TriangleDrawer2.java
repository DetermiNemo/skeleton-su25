public class TriangleDrawer2 {

    public static void drawTriangle() {
        int SIZE = 5;
        int row = 0;
        int col = 0;
        for (; row < SIZE; row++) {
            for(; col < row; col++) {
                System.out.print('*');
            }
            System.out.println('*');
            col = 0;
        }
    }
    public static void main(String[] args) {
        drawTriangle();
    }
}