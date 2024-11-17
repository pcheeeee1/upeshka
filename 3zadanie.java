import java.util.ArrayList;
import java.util.List;

abstract class Quadrilateral {
    abstract double area();
    abstract double perimeter();
}

class Square extends Quadrilateral {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    double area() {
        return side * side;
    }

    @Override
    double perimeter() {
        return 4 * side;
    }
}

class Rectangle extends Quadrilateral {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }

    @Override
    double perimeter() {
        return 2 * (length + width);
    }
}

class Rhombus extends Quadrilateral {
    private double side;
    private double height;

    public Rhombus(double side, double height) {
        this.side = side;
        this.height = height;
    }

    @Override
    double area() {
        return side * height;
    }

    @Override
    double perimeter() {
        return 4 * side;
    }
}

class IrregularQuadrilateral extends Quadrilateral {
    private double[] sides;

    public IrregularQuadrilateral(double[] sides) {
        this.sides = sides;
    }

    @Override
    double area() {
        // Простой метод для произвольного четырехугольника (можно улучшить)
        double s = perimeter() / 2; // Полупериметр
        return Math.sqrt((s - sides[0]) * (s - sides[1]) * (s - sides[2]) * (s - sides[3]));
    }

    @Override
    double perimeter() {
        double sum = 0;
        for (double side : sides) {
            sum += side;
        }
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Quadrilateral> quadrilaterals = new ArrayList<>();
        quadrilaterals.add(new Square(4));
        quadrilaterals.add(new Rectangle(4, 6));
        quadrilaterals.add(new Rhombus(5, 3));
        quadrilaterals.add(new IrregularQuadrilateral(new double[]{3, 4, 5, 6}));
        quadrilaterals.add(new Square(2));

        // Подсчет и анализ
        double maxAreaSquare = Double.MIN_VALUE;
        double minAreaSquare = Double.MAX_VALUE;
        double maxAreaRectangle = Double.MIN_VALUE;
        double minAreaRectangle = Double.MAX_VALUE;
        double maxAreaRhombus = Double.MIN_VALUE;
        double minAreaRhombus = Double.MAX_VALUE;
        double maxAreaIrregular = Double.MIN_VALUE;
        double minAreaIrregular = Double.MAX_VALUE;

        for (Quadrilateral q : quadrilaterals) {
            if (q instanceof Square) {
                double area = q.area();
                maxAreaSquare = Math.max(maxAreaSquare, area);
                minAreaSquare = Math.min(minAreaSquare, area);
            } else if (q instanceof Rectangle) {
                double area = q.area();
                maxAreaRectangle = Math.max(maxAreaRectangle, area);
                minAreaRectangle = Math.min(minAreaRectangle, area);
            } else if (q instanceof Rhombus) {
                double area = q.area();
                maxAreaRhombus = Math.max(maxAreaRhombus, area);
                minAreaRhombus = Math.min(minAreaRhombus, area);
            } else if (q instanceof IrregularQuadrilateral) {
                double area = q.area();
                maxAreaIrregular = Math.max(maxAreaIrregular, area);
                minAreaIrregular = Math.min(minAreaIrregular, area);
            }
        }

        System.out.println("Квадраты: максимальная площадь = " + maxAreaSquare + ", минимальная площадь = " + minAreaSquare);
        System.out.println("Прямоугольники: максимальная площадь = " + maxAreaRectangle + ", минимальная площадь = " + minAreaRectangle);
        System.out.println("Ромбы: максимальная площадь = " + maxAreaRhombus + ", минимальная площадь = " + minAreaRhombus);
        System.out.println("Произвольные четырехугольники: максимальная площадь = " + maxAreaIrregular + ", минимальная площадь = " + minAreaIrregular);
    }
}
