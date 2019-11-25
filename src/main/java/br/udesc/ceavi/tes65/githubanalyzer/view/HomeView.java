package br.udesc.ceavi.tes65.githubanalyzer.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.udesc.ceavi.tes65.githubanalyzer.controller.AnalyzerControllerInterface;
import br.udesc.ceavi.tes65.githubanalyzer.controller.AnalyzerControllerObserver;
import br.udesc.ceavi.tes65.githubanalyzer.model.GithubUser;

@SuppressWarnings("serial")
public class HomeView extends JFrame implements AnalyzerControllerObserver {
    
    private AnalyzerControllerInterface controller;
    
    private JLabel lbUsername;
    private JTextField tfUsername;
    private JButton btAnalyze;

    public HomeView(AnalyzerControllerInterface analyzerController) {
        setTitle("Github Analyzer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        initComponents();
        addComponents();

        pack();
        setLocationRelativeTo(null);
        
        controller = analyzerController;
        controller.attach(this);
    }

    @Override
    public void updateUserAnalysis(GithubUser user, String result) {
        if(user != null) {
            AnalyzerView analyzerView = new AnalyzerView();
            analyzerView.setAlwaysOnTop(true);
            analyzerView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            analyzerView.updateData(user, result);
            analyzerView.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Error on find user data.");
        }
        
        tfUsername.setEnabled(true);
        tfUsername.setText(null);
        tfUsername.requestFocus();
        btAnalyze.setEnabled(true);
        btAnalyze.setText("Analyze");
    }

    private void initComponents() {
        lbUsername = new JLabel("Github username:");
        tfUsername = new JTextField();
        tfUsername.setPreferredSize(new Dimension(200, 25));
        
        btAnalyze = new JButton("Analyze");
        btAnalyze.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                if(Optional.ofNullable(username).isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Github username is required.");
                    return;
                }
                tfUsername.setEnabled(false);
                btAnalyze.setEnabled(false);
                btAnalyze.setText("Analyzing...");
                controller.startUserAnalysis(username);
            }
        });
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
