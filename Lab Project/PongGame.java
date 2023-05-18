import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class PongGame extends JFrame {
    private static final int WIDTH = 1920;
    private static final int HEIGHT = 1080;  // 16:9 aspect ratio
    private static final int PADDLE_WIDTH = 10;
    private static final int PADDLE_HEIGHT = 100;
    private static final int BALL_SIZE = 20;
    private static final int PADDLE_SPEED = 20;
    private static final int BALL_SPEED_X = 4;
    private static final int BALL_SPEED_Y = 4;

    private int paddle1Y;
    private int paddle2Y;
    private int ballX;
    private int ballY;
    private int ballSpeedX;
    private int ballSpeedY;
    private int player1Score;
    private int player2Score;
    private boolean gameStarted;

    private JLabel scoreLabel;

    public PongGame() {
        setTitle("Pong Game");
        setSize(WIDTH, HEIGHT);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        paddle1Y = HEIGHT / 2 - PADDLE_HEIGHT / 2;
        paddle2Y = HEIGHT / 2 - PADDLE_HEIGHT / 2;
        ballX = WIDTH / 2 - BALL_SIZE / 2;
        ballY = HEIGHT / 2 - BALL_SIZE / 2;
        ballSpeedX = BALL_SPEED_X;
        ballSpeedY = BALL_SPEED_Y;
        player1Score = 0;
        player2Score = 0;
        gameStarted = false;

        JPanel gamePanel = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.RED);
                g.fillRect(PADDLE_WIDTH, paddle1Y, PADDLE_WIDTH, PADDLE_HEIGHT);
                g.setColor(Color.BLUE);
                g.fillRect(getWidth() - PADDLE_WIDTH * 2, paddle2Y, PADDLE_WIDTH, PADDLE_HEIGHT);
                g.setColor(Color.WHITE);
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
                g.setColor(Color.BLACK);
                g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            }
        };
        gamePanel.setBackground(new Color(173, 216, 230));  // Light blue background

        JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        scoreLabel = new JLabel("Eirik: 0  Himiko: 0");
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(24f));
        scorePanel.setBackground(new Color(173, 216, 230));  // Light blue background
        scorePanel.add(scoreLabel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton startButton = new JButton("Start");
        startButton.setFocusable(false);
        buttonPanel.setBackground(new Color(173, 216, 230));  // Light blue background
        buttonPanel.add(startButton);

        add(gamePanel, BorderLayout.CENTER);
        add(scorePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        gamePanel.setFocusable(true);

        gamePanel.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP && paddle2Y > 0) {
                    paddle2Y -= PADDLE_SPEED;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN && paddle2Y < HEIGHT - PADDLE_HEIGHT) {
                    paddle2Y += PADDLE_SPEED;
                }
                if (e.getKeyCode() == KeyEvent.VK_W && paddle1Y > 0) {
                    paddle1Y -= PADDLE_SPEED;
                }
                if (e.getKeyCode() == KeyEvent.VK_S && paddle1Y < HEIGHT - PADDLE_HEIGHT) {
                    paddle1Y += PADDLE_SPEED;
                }
            }
        });

        startButton.addActionListener(e -> {
            if (!gameStarted) {
                gameStarted = true;
                startButton.setEnabled(false);
                gamePanel.requestFocus();
                resetBall();
                gamePanel.repaint();
                Timer timer = new Timer(10, null);
                timer.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        ballX += ballSpeedX;
                        ballY += ballSpeedY;

                        if (ballY <= 0 || ballY >= HEIGHT - BALL_SIZE) {
                            ballSpeedY = -ballSpeedY;
                        }

                        if (ballX <= PADDLE_WIDTH && ballY + BALL_SIZE >= paddle1Y && ballY <= paddle1Y + PADDLE_HEIGHT) {
                            ballSpeedX = -ballSpeedX;
                        }

                        if (ballX >= WIDTH - BALL_SIZE - PADDLE_WIDTH && ballY + BALL_SIZE >= paddle2Y && ballY <= paddle2Y + PADDLE_HEIGHT) {
                            ballSpeedX = -ballSpeedX;
                        }

                        if (ballX <= 0) {
                            player2Score++;
                            updateScoreLabel();
                            resetBall();
                        }

                        if (ballX >= WIDTH - BALL_SIZE) {
                            player1Score++;
                            updateScoreLabel();
                            resetBall();
                        }

                        if (player1Score == 5 || player2Score == 5) {
                            timer.stop();
                            gameStarted = false;
                            startButton.setEnabled(true);
                        }

                        gamePanel.repaint();
                    }
                });
                timer.start();
            }
        });

        setVisible(true);
    }

    private void resetBall() {
        ballX = WIDTH / 2 - BALL_SIZE / 2;
        ballY = HEIGHT / 2 - BALL_SIZE / 2;
        Random random = new Random();
        ballSpeedX = BALL_SPEED_X * (random.nextBoolean() ? 1 : -1);
        ballSpeedY = BALL_SPEED_Y * (random.nextBoolean() ? 1 : -1);
        paddle1Y = random.nextInt(HEIGHT - PADDLE_HEIGHT);
        paddle2Y = random.nextInt(HEIGHT - PADDLE_HEIGHT);
    }

    private void updateScoreLabel() {
        scoreLabel.setText("<html><span style='font-size:24px'>Eirik: " + player1Score +
                "  <span style='color:blue'>Himiko: " + player2Score + "</span></span></html>");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PongGame());
    }
}
