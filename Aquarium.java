import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Aquarium extends JPanel {
    private TFishSchool pikeSchool;
    private TFishSchool karpSchool;

    public Aquarium() {
        pikeSchool = new TFishSchool();
        karpSchool = new TFishSchool();

        // Добавление рыб в стаи
        pikeSchool.addFish(new TPike(100, 100, 5, 20, 1));
        pikeSchool.addFish(new TPike(200, 200, 5, 20, 1));

        karpSchool.addFish(new TKarp(300, 300, 5, 20, 1));
        karpSchool.addFish(new TKarp(400, 400, 5, 20, 1));

        // Запуск анимации
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pikeSchool.runSchool();
                karpSchool.runSchool();
                repaint();
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        pikeSchool.displaySchool(g);
        karpSchool.displaySchool(g);
    }
}
