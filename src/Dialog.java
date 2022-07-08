import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;

public class Dialog extends JDialog {
    static JDialog dialog = new JDialog();
    private JLabel message = new JLabel("There is no corresponding Position for your address, please try again!");
    protected BorderLayout borderLayoutPanel = new BorderLayout();
    private JButton returnHome = new JButton("zur Startseite");

    public void createDialog() {
        dialog.setTitle("Attention");
        message.setBounds(0, 30, 400, 25);
        dialog.add(message);
        dialog.setBounds(200, 200, 400, 200);
        this.setLayout(borderLayoutPanel);
        borderLayoutPanel.setHgap(20);
        borderLayoutPanel.setVgap(20);
        this.add(returnHome, BorderLayout.SOUTH);
    }

    public static void setDialogVisible() {
        Dialog dialogWindow = new Dialog();
        dialogWindow.createDialog();
        dialog.setVisible(true);
    }

    public static void setDialogInvisible() {
        dialog.setVisible(false);
    }

    public void addReturnHomeListener(ActionListener listenForReturnHomeButton) {
        returnHome.addActionListener(listenForReturnHomeButton);
    }
}