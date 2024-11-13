import java.awt.Color;
import java.awt.Graphics;

public class TPike extends TFish {
    public TPike(int x, int y, int speed, int size, int direction) {
        super(x, y, speed, size, Color.GREEN, direction);
    }

    @Override
    public void draw(Graphics g) {
        // Рисование зеленой стрелки
        g.setColor(color);
        g.fillPolygon(new int[]{x, x + size, x - size}, new int[]{y, y + size, y + size}, 3);
    }
}
