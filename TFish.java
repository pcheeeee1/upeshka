import java.awt.Color;
import java.awt.Graphics;

public abstract class TFish {
    protected int x, y; // Координаты рыбки
    protected int speed; // Скорость рыбки
    protected int size; // Размер рыбки
    protected Color color; // Цвет рыбки
    protected int direction; // Направление движения рыбки
    protected TFish next; // Указатель на следующую рыбку в стае

    public TFish(int x, int y, int speed, int size, Color color, int direction) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.size = size;
        this.color = color;
        this.direction = direction;
        this.next = null;
    }

    public abstract void draw(Graphics g); // Виртуальный метод для рисования рыбки

    public void init(Graphics g) {
        draw(g);
    }

    public void look() {
        // Проверка нескольких точек на линии движения рыбки
        // Если хотя бы одна из них отличается по цвету от воды, возвращает цвет и указывает расстояние до рыбки
        // Реализация опущена для краткости
    }

    public void run() {
        // Перемещение рыбки в текущем направлении на расстояние, зависящее от ее текущей скорости
        // Иногда случайным образом изменяет направление движения рыбки
        // Если на пути рыбки возникает препятствие, направление движения изменяется до тех пор, пока препятствие не исчезнет из ее поля зрения
        // Реализация опущена для краткости
    }
}
