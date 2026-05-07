import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI implements ActionListener{
    JFrame frame;
    JTextField display;
    CalculatorLogic logic;

    public CalculatorUI(){
        logic = new CalculatorLogic();

        frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setLayout(new BorderLayout());

        display = new JTextField();
        display.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "√", "x²", "%"
        };

        for(String text: buttons) {
            JButton btn = new JButton(text);
            btn.setActionCommand(text);
            btn.addActionListener(this);
            panel.add(btn);
        }

        frame.add(panel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();
        String result = logic.process(input, display.getText());
        display.setText(result);
    }
}