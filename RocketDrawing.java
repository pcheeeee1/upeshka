/ Класс для крыльев
class Wings {
    private double wingspan;

    public Wings(double wingspan) throws IllegalArgumentException {
        if (wingspan <= 0) {
            throw new IllegalArgumentException("Размах крыльев должен быть больше 0");
        }
        this.wingspan = wingspan;
    }

    public double getWingspan() {
        return wingspan;
    }
}

// Класс для клюва
class Beak {
    private double beakSize;

    public Beak(double beakSize) throws IllegalArgumentException {
        if (beakSize <= 0) {
            throw new IllegalArgumentException("Размер клюва должен быть больше 0");
        }
        this.beakSize = beakSize;
    }

    public double getBeakSize() {
        return beakSize;
    }
}

// Класс для птицы
class Bird {
    private Wings wings;
    private Beak beak;

    public Bird(double wingspan, double beakSize) {
        try {
            this.wings = new Wings(wingspan);
            this.beak = new Beak(beakSize);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании птицы: " + e.getMessage());
        } catch (OutOfMemoryError e) {
            System.out.println("Ошибка: недостаточно памяти для создания птицы");
        }
    }

    // Метод для полета
    public void fly(double distance) {
        try {
            if (distance <= 0) {
                throw new IllegalArgumentException("Дистанция для полета должна быть больше 0");
            }
            System.out.println("Птица летит на расстояние " + distance + " метров.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка полета: " + e.getMessage());
        }
    }

    // Метод для посадки
    public void land() {
        try {
            System.out.println("Птица садится.");
        } catch (Exception e) {
            System.out.println("Ошибка при посадке: " + e.getMessage());
        }
    }

    // Метод для питания
    public void eat(double foodAmount) {
        try {
            if (foodAmount <= 0) {
                throw new IllegalArgumentException("Количество пищи должно быть больше 0");
            }
            System.out.println("Птица ест " + foodAmount + " грамм пищи.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка питания: " + e.getMessage());
        }
    }

    // Метод для атаки
    public void attack() {
        try {
            System.out.println("Птица атакует!");
        } catch (Exception e) {
            System.out.println("Ошибка при атаке: " + e.getMessage());
        }
    }
}
public class Main {
    public static void main(String[] args) {
        try {
            Bird bird = new Bird(1.5, 0.3);
            bird.fly(-10);
            bird.land();
            bird.eat(0);
            bird.attack();
        } catch (Exception e) {
            System.out.println("Общая ошибка: " + e.getMessage());
        }
    }
}

