import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PasswordGeneratorGUI extends JFrame {
    private JLabel lengthLabel;
    private JTextField lengthField;
    private JCheckBox uppercaseCheckbox;
    private JCheckBox lowercaseCheckbox;
    private JCheckBox numbersCheckbox;
    private JCheckBox specialCharsCheckbox;
    private JButton generateButton;
    private JTextArea passwordArea;

    public PasswordGeneratorGUI() {
        setTitle("Password Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        lengthLabel = new JLabel("Password Length:");
        lengthField = new JTextField(10);
        uppercaseCheckbox = new JCheckBox("Include Uppercase Letters");
        lowercaseCheckbox = new JCheckBox("Include Lowercase Letters");
        numbersCheckbox = new JCheckBox("Include Numbers");
        specialCharsCheckbox = new JCheckBox("Include Special Characters");
        generateButton = new JButton("Generate");
        passwordArea = new JTextArea(5, 20);
        passwordArea.setEditable(false);

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generatePassword();
            }
        });

        add(lengthLabel);
        add(lengthField);
        add(uppercaseCheckbox);
        add(lowercaseCheckbox);
        add(numbersCheckbox);
        add(specialCharsCheckbox);
        add(generateButton);
        add(new JScrollPane(passwordArea));

        pack();
        setVisible(true);
    }

    private void generatePassword() {
        try {
            int length = Integer.parseInt(lengthField.getText());
            String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
            String numbers = "0123456789";
            String specialCharacters = "!@#$%^&*()-_=+[]{}<>.,:;?";
            String allCharacters = "";
            StringBuilder password = new StringBuilder();

            if (uppercaseCheckbox.isSelected()) {
                allCharacters += uppercaseLetters;
            }
            if (lowercaseCheckbox.isSelected()) {
                allCharacters += lowercaseLetters;
            }
            if (numbersCheckbox.isSelected()) {
                allCharacters += numbers;
            }
            if (specialCharsCheckbox.isSelected()) {
                allCharacters += specialCharacters;
            }

            if (allCharacters.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please select at least one option.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }

            for (int i = 0; i < length; i++) {
                int randomIndex = (int) (Math.random() * allCharacters.length());
                password.append(allCharacters.charAt(randomIndex));
            }

            passwordArea.setText(password.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for password length.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordGeneratorGUI();
            }
        });
    }
}
