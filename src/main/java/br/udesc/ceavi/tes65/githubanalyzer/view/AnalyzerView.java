package br.udesc.ceavi.tes65.githubanalyzer.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.net.URL;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import br.udesc.ceavi.tes65.githubanalyzer.model.GithubUser;

@SuppressWarnings("serial")
public class AnalyzerView extends JFrame {
    
    private JLabel lbName;
    private JTextField tfName;

    private JLabel lbPhoto;
    private JPanel pnPhoto;
    
    private JLabel lbLocation;
    private JTextField tfLocation;
    
    private JLabel lbCompany;
    private JTextField tfCompany;
    
    private JLabel lbFollowers;
    private JTextField tfFollowers;
    
    private JLabel lbRepositories;
    private JTextField tfRepositories;
    
    private JLabel lbBiography;
    private JTextArea taBiography;
    
    private JLabel lbResult;
    private JPanel pnResult;
    
    public AnalyzerView() {
        setTitle("Github Analyzer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        initComponents();
        addComponents();

        pack();
        setLocationRelativeTo(null);
    }
    
    public void updateData(GithubUser user, String result) {
        setTitle(String.format("Github Analyzer - %s", user.getUsername()));
        tfName.setText(user.getName());
        tfLocation.setText(user.getLocation());
        tfCompany.setText(user.getCompany());
        tfFollowers.setText(String.valueOf(user.getFollowers()));
        tfRepositories.setText(String.valueOf(user.getRepositories()));
        taBiography.setText(user.getBiography());
        lbResult.setText(String.format("Result: %s", result));
        updatePhoto(user.getPhoto());
    }

    private void updatePhoto(String photo) {
        if(Optional.ofNullable(photo).isEmpty()) {
            lbPhoto.setText("No photo.");
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                lbPhoto.setText("Loading...");
                Icon icon;
                try {
                    icon = new ImageIcon(ImageIO.read(new URL(photo)).getScaledInstance(lbPhoto.getWidth(), lbPhoto.getHeight(), Image.SCALE_SMOOTH));
                    lbPhoto.setText(null);
                } catch(Exception e) {
                    icon = null;
                    lbPhoto.setText("No photo.");
                }
                lbPhoto.setIcon(icon);
            }
        }).start();
    }

    private void initComponents() {
        Border defaultColorBorder = BorderFactory.createLineBorder(new Color(150, 150, 150));
        Border defaultComponentBorder = BorderFactory.createCompoundBorder(defaultColorBorder, BorderFactory.createEmptyBorder(5, 5, 5, 5));
        Color defaultFieldDisabledTextColor = new Color(50, 50, 50);
        
        //Name
        lbName = new JLabel("Name:");
        tfName = new JTextField();
        tfName.setPreferredSize(new Dimension(200, 25));
        tfName.setEnabled(false);
        tfName.setBorder(defaultComponentBorder);
        tfName.setDisabledTextColor(defaultFieldDisabledTextColor);
        
        //Location
        lbLocation = new JLabel("Location:");
        tfLocation = new JTextField();
        tfLocation.setPreferredSize(new Dimension(200, 25));
        tfLocation.setEnabled(false);
        tfLocation.setBorder(defaultComponentBorder);
        tfLocation.setDisabledTextColor(defaultFieldDisabledTextColor);
        
        //Photo
        lbPhoto = new JLabel();
        lbPhoto.setHorizontalAlignment(SwingConstants.CENTER);
        pnPhoto = new JPanel();
        pnPhoto.setPreferredSize(new Dimension(100, 100));
        pnPhoto.setBackground(new Color(180, 180, 180));
        pnPhoto.setBorder(defaultColorBorder);
        pnPhoto.setLayout(new BorderLayout());
        pnPhoto.add(lbPhoto, BorderLayout.CENTER);
        
        //Company
        lbCompany = new JLabel("Company:");
        tfCompany = new JTextField();
        tfCompany.setPreferredSize(new Dimension(200, 25));
        tfCompany.setEnabled(false);
        tfCompany.setBorder(defaultComponentBorder);
        tfCompany.setDisabledTextColor(defaultFieldDisabledTextColor);
        
        //Followers
        lbFollowers = new JLabel("Follows.:");
        tfFollowers = new JTextField();
        tfFollowers.setPreferredSize(new Dimension(50, 25));
        tfFollowers.setEnabled(false);
        tfFollowers.setBorder(defaultComponentBorder);
        tfFollowers.setDisabledTextColor(defaultFieldDisabledTextColor);
        
        //Repositories
        lbRepositories = new JLabel("Repos.:");
        tfRepositories = new JTextField();
        tfRepositories.setPreferredSize(new Dimension(50, 25));
        tfRepositories.setEnabled(false);
        tfRepositories.setBorder(defaultComponentBorder);
        tfRepositories.setDisabledTextColor(defaultFieldDisabledTextColor);
        
        //Biography
        lbBiography = new JLabel("Biography:");
        taBiography = new JTextArea();
        taBiography.setPreferredSize(new Dimension(310, 50));
        taBiography.setEnabled(false);
        taBiography.setAutoscrolls(true);
        taBiography.setBorder(defaultComponentBorder);
        taBiography.setLineWrap(true);
        taBiography.setDisabledTextColor(defaultFieldDisabledTextColor);
        
        //Result
        lbResult = new JLabel();
        lbResult.setHorizontalAlignment(SwingConstants.CENTER);
        pnResult = new JPanel();
        pnResult.setPreferredSize(new Dimension(310, 30));
        pnResult.setBackground(new Color(180, 180, 180));
        pnResult.setBorder(defaultComponentBorder);
        pnResult.setLayout(new BorderLayout());
        pnResult.add(lbResult, BorderLayout.CENTER);
    }

    private void addComponents() {
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints cons;

        //Name
        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        contentPane.add(lbName, cons);
        
        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        cons.gridy = 1;
        contentPane.add(tfName, cons);

        //Location
        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        cons.gridy = 2;
        cons.insets = new Insets(5, 0, 0, 0);
        contentPane.add(lbLocation, cons);
        
        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        cons.gridy = 3;
        contentPane.add(tfLocation, cons);
        
        //Photo
        cons = new GridBagConstraints();
        cons.gridx = 1;
        cons.gridy = 0;
        cons.insets = new Insets(0, 5, 0, 0);
        cons.gridheight = 4;
        cons.gridwidth = 2;
        contentPane.add(pnPhoto, cons);

        //Company
        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        cons.gridy = 4;
        cons.insets = new Insets(5, 0, 0, 0);
        contentPane.add(lbCompany, cons);
        
        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        cons.gridy = 5;
        contentPane.add(tfCompany, cons);
        
        //Followers
        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        cons.gridx = 1;
        cons.gridy = 4;
        cons.insets = new Insets(5, 5, 0, 0);
        contentPane.add(lbFollowers, cons);

        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        cons.gridx = 1;
        cons.gridy = 5;
        cons.insets = new Insets(0, 5, 0, 0);
        contentPane.add(tfFollowers, cons);
        
        //Repositories
        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        cons.gridx = 2;
        cons.gridy = 4;
        cons.insets = new Insets(5, 5, 0, 0);
        contentPane.add(lbRepositories, cons);

        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        cons.gridx = 2;
        cons.gridy = 5;
        cons.insets = new Insets(0, 5, 0, 0);
        contentPane.add(tfRepositories, cons);

        //Biography
        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        cons.gridy = 6;
        cons.insets = new Insets(5, 0, 0, 0);
        contentPane.add(lbBiography, cons);
        
        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        cons.gridy = 7;
        cons.gridwidth = 3;
        contentPane.add(taBiography, cons);
        
        //Results
        cons = new GridBagConstraints();
        cons.anchor = GridBagConstraints.WEST;
        cons.gridy = 8;
        cons.gridwidth = 3;
        cons.insets = new Insets(10, 0, 0, 0);
        contentPane.add(pnResult, cons);
        
        setContentPane(contentPane);
    }

}
