import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

public class NumberGuessingGame extends JFrame {
    private int targetNumber;
    private int attempts;

    private JLabel messageLabel;
    private JTextField guessField;
    private JButton submitButton;
    private JButton startAgainButton;

    public NumberGuessingGame() {
        setTitle("Number Guessing Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 768);
        setLocationRelativeTo(null);
        setResizable(true);
        setLayout(new FlowLayout());

        targetNumber = generateRandomNumber();
        attempts = 3;

        messageLabel = new JLabel("I'm thinking of a number between 1 and 10.");
        guessField = new JTextField(10);
        submitButton = new JButton("Submit");
        startAgainButton = new JButton("Start Again");

        Font customFont = new Font("Siyamrupali", Font.BOLD, 30);
        messageLabel.setFont(customFont);
        guessField.setFont(customFont);
        submitButton.setFont(customFont);
        startAgainButton.setFont(customFont);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int guess = Integer.parseInt(guessField.getText());
                processGuess(guess);
            }
        });

        startAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        add(messageLabel);
        add(guessField);
        add(submitButton);
        add(startAgainButton);
        startAgainButton.setEnabled(false);

        setVisible(true);
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    private void processGuess(int guess) {
        attempts--;

        if (guess == targetNumber) {
            displayMessage("Congratulations! You guessed the number!");
            endGame();
        } else if (attempts == 0) {
            displayMessage("Game Over! The number was " + targetNumber);
            endGame();
        } else if (guess < targetNumber) {
            displayMessage("Too low! Guesses left: " + attempts);
            guessField.setText("");
        } else {
            displayMessage("Too high! Guesses left: " + attempts);
            guessField.setText("");
        }
    }

    private void resetGame() {
        targetNumber = generateRandomNumber();
        attempts = 3;
        messageLabel.setText("I'm thinking of a number between 1 and 10.");
        guessField.setText("");
        guessField.setEditable(true);
        submitButton.setEnabled(true);
        startAgainButton.setEnabled(false);
    }

    private void endGame() {
        guessField.setEditable(false);
        submitButton.setEnabled(false);
        startAgainButton.setEnabled(true);
    }

    private void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    String fontPath = "F:/Downloads/Siyamrupali.ttf";
                    Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(Font.BOLD, 30);

                    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                    ge.registerFont(customFont);

                    new NumberGuessingGame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
