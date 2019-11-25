package br.udesc.ceavi.tes65.githubanalyzer.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class HomeView extends JFrame {
    
    private JLabel lbUsername;
    private JTextField tfUsername;
    private JButton btAnalyze;

    public HomeView() {
        setTitle("Github Analyzer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        initComponents();
        addComponents();

        pack();
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        lbUsername = new JLabel("Github username:");
        tfUsername = new JTextField();
        btAnalyze  = new JButton("Analyze");
        
        tfUsername.setPreferredSize(new Dimension(200, 25));
    }

    private void addComponents() {
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 40, 20, 40));
        contentPane.setLayout(new GridLayout(3, 1, 0, 5));
        
        contentPane.add(lbUsername);
        contentPane.add(tfUsername);
        contentPane.add(btAnalyze);
        
        setContentPane(contentPane);
    }

}
