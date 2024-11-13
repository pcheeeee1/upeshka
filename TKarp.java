import java.awt.Color;
import java.awt.Graphics;

public class TKarp extends TFish {
    public TKarp(int x, int y, int speed, int size, int direction) {
        super(x, y, speed, size, Color.RED, direction);
    }

    @Override
    public void draw(Graphics g) {
        // Рисование красного треугольника
        g.setColor(color);
        g.fillPolygon(new int[]{x, x + size, x - size}, new int[]{y, y + size, y + size}, 3);
    }
}
