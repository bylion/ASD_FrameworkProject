package edu.mum.cs.asd.framework.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ReportDialog extends JDialog {

    private JTextArea reportTextArea;
    private JScrollPane scrollPane;
    private JButton okButton;
    private String reportText;

    public ReportDialog(JFrame parent, String title, String reportText) {
        super(parent, title, true);
        this.reportText = reportText;

        initComponents();
    }

    private void initComponents() {
        reportTextArea = new JTextArea(reportText);
        scrollPane = new JScrollPane();

        reportTextArea.setEditable(false);
        reportTextArea.setColumns(20);
        reportTextArea.setRows(5);
        scrollPane.setViewportView(reportTextArea);
        scrollPane.setBounds(24,24,358,240);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog();
            }

        });

        getContentPane().setLayout(null);
        setSize(415, 370);

        okButton = new JButton("Ok");
        okButton.setBounds(156,276,96,24);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeDialog();
            }
        });
        
        getContentPane().add(scrollPane);
        getContentPane().add(okButton);
    }

    private void closeDialog() {
        setVisible(false);
        dispose();
    }
}
