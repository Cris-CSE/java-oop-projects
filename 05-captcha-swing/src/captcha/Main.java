package captcha;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        // Swing components should be created on the Event Dispatch Thread.
        SwingUtilities.invokeLater(Captcha::new);
    }
}
