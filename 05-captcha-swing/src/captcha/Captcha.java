package captcha; //The package where the class and test are located.

import javax.swing.*;//Useful for developing interfaces.
import java.awt.*;//Older drawing toolkit that Swing is built on: colors, fonts, shapes.
import java.awt.event.*;//Lets the program react when the user does something, like clicking a button.
import java.util.Random;//Lets us pick random letters, colors and positions.

public class Captcha extends JFrame {

    //Random object used to generate captcha text and visual noise.
    private Random random = new Random();

    //Text field where the user types the captcha.
    private JTextField input = new JTextField();

    //Buttons.
    private JButton validateButton = new JButton("Validate");
    private JButton refreshButton = new JButton("New Captcha");

    //Labels.
    private JLabel instructionLabel = new JLabel("Type the captcha:");
    private JLabel resultLabel = new JLabel("");

    //Current captcha text.
    private String captchaText = "";

    public Captcha() {
        //Generate the first captcha.
        generateCaptcha();

        //Window configuration.
        setLayout(null);
        setBounds(100, 100, 450, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Improved Captcha Application");
        setResizable(false);

        //Font and style for labels.
        instructionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        resultLabel.setFont(new Font("Arial", Font.BOLD, 15));

        //Component positions.
        instructionLabel.setBounds(110, 300, 250, 30);
        input.setBounds(110, 340, 220, 35);
        validateButton.setBounds(110, 390, 220, 40);
        refreshButton.setBounds(110, 440, 220, 40);
        resultLabel.setBounds(90, 500, 300, 30);

        //Add components to the window.
        add(instructionLabel);
        add(input);
        add(validateButton);
        add(refreshButton);
        add(resultLabel);

        //Button actions.
        setUpButtonListeners();

        setVisible(true);
    }

    //This method generates a random captcha with letters and numbers.
    private void generateCaptcha() {
        String characters = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
        StringBuilder captcha = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(characters.length());
            captcha.append(characters.charAt(index));
        }

        captchaText = captcha.toString();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //Convert Graphics to Graphics2D for better visual quality.
        Graphics2D g2d = (Graphics2D) g;

        //Smooth drawing.
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        //Draw main background.
        g2d.setColor(new Color(245, 247, 250));
        g2d.fillRect(0, 0, getWidth(), getHeight());

        //Draw captcha card.
        g2d.setColor(new Color(225, 235, 255));
        g2d.fillRoundRect(70, 100, 300, 160, 30, 30);

        //Draw card border.
        g2d.setColor(new Color(90, 120, 200));
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRoundRect(70, 100, 300, 160, 30, 30);

        //Draw random noise lines.
        for (int i = 0; i < 8; i++) {
            g2d.setColor(getRandomColor());

            int x1 = 80 + random.nextInt(270);
            int y1 = 115 + random.nextInt(130);
            int x2 = 80 + random.nextInt(270);
            int y2 = 115 + random.nextInt(130);

            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(x1, y1, x2, y2);
        }

        //Draw random dots.
        for (int i = 0; i < 45; i++) {
            g2d.setColor(getRandomColor());

            int x = 80 + random.nextInt(270);
            int y = 115 + random.nextInt(130);

            g2d.fillOval(x, y, 5, 5);
        }

        //Draw captcha text character by character.
        g2d.setFont(new Font("Arial", Font.BOLD, 42));

        int startX = 105;

        for (int i = 0; i < captchaText.length(); i++) {
            g2d.setColor(getDarkRandomColor());

            //Slight variation in position.
            int x = startX + (i * 38);
            int y = 190 + random.nextInt(25);

            //Slight rotation.
            double angle = Math.toRadians(random.nextInt(31) - 15);
            g2d.rotate(angle, x, y);

            g2d.drawString(String.valueOf(captchaText.charAt(i)), x, y);

            //Reset rotation.
            g2d.rotate(-angle, x, y);
        }

        //Draw title.
        g2d.setColor(new Color(40, 50, 80));
        g2d.setFont(new Font("Arial", Font.BOLD, 22));
        g2d.drawString("CAPTCHA Verification", 100, 70);
    }

    //Method for validating and refreshing captcha.
    public void setUpButtonListeners() {
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String userText = input.getText().trim();

                if (userText.equalsIgnoreCase(captchaText)) {
                    resultLabel.setText("Correct captcha! Access allowed.");
                    resultLabel.setForeground(new Color(0, 140, 70));
                } else {
                    resultLabel.setText("Incorrect captcha. Try a new one.");
                    resultLabel.setForeground(Color.RED);

                    //Generate a new captcha after incorrect attempt.
                    generateCaptcha();
                    input.setText("");
                    repaint();
                }
            }
        });

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                generateCaptcha();
                input.setText("");
                resultLabel.setText("");
                repaint();
            }
        });
    }

    //Generates random bright colors for lines and dots.
    private Color getRandomColor() {
        int red = 80 + random.nextInt(176);
        int green = 80 + random.nextInt(176);
        int blue = 80 + random.nextInt(176);

        return new Color(red, green, blue);
    }

    //Generates darker colors for captcha text.
    private Color getDarkRandomColor() {
        int red = random.nextInt(100);
        int green = random.nextInt(100);
        int blue = random.nextInt(100);

        return new Color(red, green, blue);
    }
}