# 05 · Captcha (Swing)

A desktop application built with **Java Swing** that generates and validates a CAPTCHA. The text is drawn character by character with random rotation, position and color, plus noise lines and dots to make it harder for bots to read.

<!-- Add a screenshot of the app here, for example: ![Captcha app](screenshot.png) -->

## Features
- Random 6-character code (ambiguous characters like `I`, `O`, `0` and `1` are excluded)
- Visual noise: random lines, dots, colors and rotated characters
- **Validate** button: checks the input (case-insensitive) and shows the result
- **New Captcha** button: generates a new code
- A new CAPTCHA is generated automatically after a wrong attempt

## Concepts practiced
- Building a GUI with `JFrame`, `JLabel`, `JTextField` and `JButton`
- Event handling with `ActionListener`
- 2D drawing with `Graphics2D` (antialiasing, shapes, strokes, rotation)
- Inheritance (`Captcha extends JFrame`)

## How to run

```bash
cd src
javac captcha/*.java
java captcha.Main
```

## Possible improvements
- Use `SecureRandom` instead of `Random`
- Draw on a custom `JPanel` (`paintComponent`) to avoid flickering
- Limit the number of attempts
