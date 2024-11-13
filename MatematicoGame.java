import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatematicoGame extends JFrame {
    private JPanel boardPanel;
    private JButton[][] boardButtons;
    private JLabel nextNumberLabel;
    private JLabel scoreLabel;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private int score;
    private boolean gameRunning;
    private int nextNumber;
    private List<Integer> availableNumbers;

    public MatematicoGame() {
        setTitle("Математико");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        // Создаем набор из 52 карточек
        List<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                cards.add(i);
            }
        }

        // Перемешиваем карточки
        Collections.shuffle(cards);

        // Создаем квадратное поле из 25 клеток
        boardButtons = new JButton[5][5];
        boardPanel = new JPanel(new GridLayout(5, 5));
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!cards.isEmpty()) {
                    boardButtons[i][j] = new JButton(String.valueOf(cards.remove(0)));
                } else {
                    boardButtons[i][j] = new JButton("0");
                }
                boardButtons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                boardButtons[i][j].setBackground(Color.WHITE);
                boardButtons[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                boardButtons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleButtonClick((JButton) e.getSource());
                    }
                });
                boardPanel.add(boardButtons[i][j]);
            }
        }

        // Создаем панель для счета и кнопок
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        nextNumberLabel = new JLabel("Следующее число: " + nextNumber);
        nextNumberLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        stopButton.setEnabled(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopGame();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        controlPanel.add(scoreLabel);
        controlPanel.add(nextNumberLabel);
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(resetButton);

        // Добавляем панели в окно
        add(boardPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.EAST);

        // Инициализация переменных
        score = 0;
        gameRunning = false;
        availableNumbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(boardButtons[i][j].getText());
                if (!availableNumbers.contains(number)) {
                    availableNumbers.add(number);
                }
            }
        }
        nextNumber = getNextNumber();
        nextNumberLabel.setText("Следующее число: " + nextNumber);
    }

    private void startGame() {
        if (!gameRunning) {
            gameRunning = true;
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            resetButton.setEnabled(false);
        }
    }

    private void stopGame() {
        if (gameRunning) {
            gameRunning = false;
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
            resetButton.setEnabled(true);
            showFinalScore();
        }
    }

    private void resetGame() {
        // Сброс игры
        score = 0;
        scoreLabel.setText("Score: 0");
        gameRunning = false;
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        resetButton.setEnabled(false);

        // Перемешиваем карточки и обновляем поле
        List<Integer> cards = new ArrayList<>();
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                cards.add(i);
            }
        }
        Collections.shuffle(cards);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!cards.isEmpty()) {
                    boardButtons[i][j].setText(String.valueOf(cards.remove(0)));
                } else {
                    boardButtons[i][j].setText("0");
                }
                boardButtons[i][j].setEnabled(true);
                boardButtons[i][j].setBackground(Color.WHITE);
            }
        }

        availableNumbers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int number = Integer.parseInt(boardButtons[i][j].getText());
                if (!availableNumbers.contains(number)) {
                    availableNumbers.add(number);
                }
            }
        }
        nextNumber = getNextNumber();
        nextNumberLabel.setText("Следующее число: " + nextNumber);
    }

    private void handleButtonClick(JButton button) {
        if (gameRunning) {
            int clickedNumber = Integer.parseInt(button.getText());
            if (clickedNumber == nextNumber) {
                // Правильный выбор
                score += 10;
                scoreLabel.setText("Score: " + score);
                button.setEnabled(false);
                button.setBackground(Color.GRAY);
                availableNumbers.remove((Integer) nextNumber);
                nextNumber = getNextNumber();
                if (nextNumber == -1) {
                    stopGame();
                } else {
                    nextNumberLabel.setText("Следующее число: " + nextNumber);
                }
            } else {
                // Неправильный выбор
                score -= 5;
                scoreLabel.setText("Score: " + score);
            }
        }
    }

    private int getNextNumber() {
        if (availableNumbers.isEmpty()) {
            return -1; // No more available numbers
        }
        Collections.shuffle(availableNumbers);
        return availableNumbers.get(0);
    }

    private void showFinalScore() {
        JOptionPane.showMessageDialog(this, "Финальный счёт: " + score, "Игра завершена", JOptionPane.INFORMATION_MESSAGE);
    }
}
