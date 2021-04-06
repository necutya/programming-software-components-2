package UI;

import Controller.Command;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UI {

    private static JFrame frame;
    private static JPanel content;
    private static ArrayList<JComponent> enterFields = new ArrayList<JComponent>();
    JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));


    public UI(String windowName) {
        frame = new JFrame(windowName);
        content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public UI addLabel(String text) {
        JLabel mainLabel = new JLabel(text);
        content.add(mainLabel);
        return this;
    }

    public UI addEnterField(String text) {
        JTextField enter = new JTextField(text, 10);
        content.add(enter);
        enterFields.add(enter);
        return this;
    }

    public UI addDropDownMenu(String text, String[] choices) {
        JLabel mainLabel = new JLabel(text);
        final JComboBox<String> cb = new JComboBox<String>(choices);
        content.add(mainLabel);
        content.add(cb);
        enterFields.add(cb);
        return this;
    }

    public UI addButton(String text, Command command, boolean create_by_enters) {
        JButton btn = new JButton(text);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message;
                if (create_by_enters) {
                    try {
                       command.writeData(getAllEnterFieldsValues());
                    }
                    catch (Exception ex) {
                        message = ex.getMessage();
                        JOptionPane.showMessageDialog(frame, message);
                        return;
                    }
                }
                message = command.execute();
                JOptionPane.showMessageDialog(frame, message);
            }
        });
        buttons.add(btn);
        return this;
    }

    public void show() {
        content.add(buttons);
        frame.setSize(800, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private ArrayList<String> getAllEnterFieldsValues() {
        ArrayList<String> values = new ArrayList<String>();
        for (JComponent enterField: enterFields) {
            if(enterField instanceof JTextField) {
                values.add(((JTextField) enterField).getText());
            }
            else if (enterField instanceof JComboBox) {
                values.add((String) ((JComboBox) enterField).getSelectedItem());
            }
        }
        return values;
    }
}
