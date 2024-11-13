import javax.swing.*;
import java.awt.*;

public class CombinedApp extends JFrame {
    public CombinedApp() {
        setTitle("Combined Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        // Вкладка для ракеты
        JPanel rocketPanel = new RocketDrawing();
        tabbedPane.addTab("Rocket", rocketPanel);

        // Вкладка для аквариума
        JPanel aquariumPanel = new Aquarium();
        tabbedPane.addTab("Aquarium", aquariumPanel);

        // Вкладка для игры Математико
        MatematicoGame matematicoGame = new MatematicoGame();
        tabbedPane.addTab("Matematico", matematicoGame.getContentPane());

        add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CombinedApp app = new CombinedApp();
                app.setVisible(true);
            }
        });
    }
}
