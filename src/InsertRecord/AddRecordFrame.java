package insertRecord;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class AddRecordFrame extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AddRecordFrame frame = new AddRecordFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public AddRecordFrame() {
        setResizable(false);
        setTitle("Add Record");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(497, 725);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        AddRecordPanel addRecordPanel = new AddRecordPanel();
        addRecordPanel.setBounds(-250, -42, 769, 731);
        getContentPane().add(addRecordPanel);

        setVisible(true);
    }
}
