# 🎯 Guess the Number Game

## Objective

The **Guess the Number** project is a Java Swing-based game where:
- The application generates a random number within a defined range (e.g., 1–100).
- The user guesses the number through a simple GUI.
- After each guess, the game provides hints such as “Higher” or “Lower.”
- The game displays the total number of attempts taken once the correct number is guessed.

This project was created to practice GUI programming and basic game logic in Java.

---

## Tools & Technologies

- **Programming Language:** Java (JDK 8+)
- **GUI:** Java Swing
- **IDE:** IntelliJ IDEA or NetBeans

---

## Steps Performed

1. **Random Number Generation:**
   - Used Java’s `Random` class to generate a target number at runtime.

2. **GUI Design:**
   - Designed a Swing window (`JFrame`) with labels, text fields, and buttons.
   - Added components for user input and game feedback.

3. **Input Handling:**
   - Captured and validated the user's guess from a text field.
   - Compared the guess to the target number and showed hints.

4. **Game Loop:**
   - Allowed repeated guesses until the user found the correct number.

5. **Attempt Counter:**
   - Counted the number of guesses made by the user.

6. **Completion:**
   - Displayed a congratulatory message with the total attempts after a successful guess.

7. **Exception Handling:**
   - Managed invalid inputs (e.g., non-numeric guesses) with appropriate error messages.

---

## How to Run

1. **Compile the code:**
   ```bash
   javac GuessNumber.java

2. **Run the application:**
   ```bash
   java GuessNumber

3. **Play the game:**
   
  -Enter your guess in the input box.

  -Click the “Guess” button.

  -Follow the hints until you find the correct number.

## Outcome

-Created an interactive guessing game with a responsive UI.

-Practiced event-driven programming with Java Swing.

-Enhanced Java skills in basic algorithms, user interaction, and exception handling.
