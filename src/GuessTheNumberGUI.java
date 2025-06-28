import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessTheNumberGUI extends JFrame implements ActionListener {

    // GUI components
    private JLabel instructionLabel, feedbackLabel, scoreLabel, attemptLabel, roundLabel;
    private JTextField guessField;
    private JButton guessButton;

    // Game variables
    private int randomNumber;
    private int attemptsLeft;
    private int totalScore;
    private int round;
    private final int maxRounds = 3;
    private final int maxAttempts = 7;

    // Constructor
    public GuessTheNumberGUI() {
        setTitle("Guess The Number Game");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 1));

        // Initialize components
        roundLabel = new JLabel("Round: 1/" + maxRounds, SwingConstants.CENTER);
        instructionLabel = new JLabel("Guess a number between 1 and 100", SwingConstants.CENTER);
        feedbackLabel = new JLabel("Enter your guess below:", SwingConstants.CENTER);
        attemptLabel = new JLabel("Attempts Left: " + maxAttempts, SwingConstants.CENTER);
        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        guessField = new JTextField();
        guessField.setColumns(10);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(guessField);

        guessButton = new JButton("Submit Guess");

        // Add to frame
        add(roundLabel);
        add(instructionLabel);
        add(inputPanel);
        add(guessButton);
        add(feedbackLabel);
        add(attemptLabel);
        add(scoreLabel);

        guessButton.addActionListener(this);

        round = 0;
        totalScore = 0;
        startNewRound();

        setVisible(true);
    }


    // Start a new round
    private void startNewRound() {
        randomNumber = new Random().nextInt(100) + 1;
        attemptsLeft = maxAttempts;
        round++;
        roundLabel.setText("Round: " + round + "/" + maxRounds);
        attemptLabel.setText("Attempts Left: " + attemptsLeft);
        feedbackLabel.setText("Enter your guess below:");
        guessField.setText("");
    }

    // Handle button click
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = guessField.getText().trim();
        int guess;

        try {
            guess = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            feedbackLabel.setText("❌ Please enter a valid number.");
            return;
        }

        attemptsLeft--;

        if (guess == randomNumber) {
            int scoreEarned = 10 - (maxAttempts - attemptsLeft);
            totalScore += scoreEarned;
            feedbackLabel.setText("✅ Correct! You earned " + scoreEarned + " points.");
            scoreLabel.setText("Score: " + totalScore);

            if (round < maxRounds) {
                JOptionPane.showMessageDialog(this, "🎉 Correct! Starting next round...");
                startNewRound();
            } else {
                endGame();
            }

        } else if (guess < randomNumber) {
            feedbackLabel.setText("🔼 Too low! Try again.");
        } else {
            feedbackLabel.setText("🔽 Too high! Try again.");
        }

        attemptLabel.setText("Attempts Left: " + attemptsLeft);

        if (attemptsLeft == 0 && guess != randomNumber) {
            feedbackLabel.setText("❌ Out of attempts! Number was: " + randomNumber);
            if (round < maxRounds) {
                JOptionPane.showMessageDialog(this, "Moving to next round...");
                startNewRound();
            } else {
                endGame();
            }
        }

        guessField.setText("");
    }

    // End the game
    private void endGame() {
        JOptionPane.showMessageDialog(this, "🏁 Game Over!\nTotal Score: " + totalScore);
        guessButton.setEnabled(false);
        guessField.setEnabled(false);
        feedbackLabel.setText("Game Finished! Restart to play again.");
    }

    // Main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuessTheNumberGUI());
    }
}
