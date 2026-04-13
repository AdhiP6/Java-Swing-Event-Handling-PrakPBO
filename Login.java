/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kalkulator;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
 
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JRadioButton rdLaki = new JRadioButton("Laki-laki");
    JRadioButton rdPerempuan = new JRadioButton("Perempuan");
 
    public Login() {
        setTitle("Login Page");
        setSize(400, 340);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
 
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdLaki);
        bg.add(rdPerempuan);
 
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        genderPanel.add(rdLaki);
        genderPanel.add(Box.createHorizontalStrut(20));
        genderPanel.add(rdPerempuan);
 
        JButton loginBtn = new JButton("Login");
 
        JPanel panel = new JPanel(new GridLayout(9, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        JLabel title = new JLabel("Selamat Datang!");
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
 
        JLabel subtitle = new JLabel("Silakan masuk untuk melanjutkan.");
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 12));
        subtitle.setForeground(Color.GRAY);
        
        panel.add(title);
        panel.add(subtitle);
        panel.add(new JLabel("Username"));
        panel.add(usernameField);
        panel.add(new JLabel("Password"));
        panel.add(passwordField);
        panel.add(new JLabel("Jenis Kelamin"));
        panel.add(genderPanel);
        panel.add(loginBtn);
 
        add(panel);
 
        loginBtn.addActionListener(e -> {
            String user = usernameField.getText().trim();
            String pass = new String(passwordField.getPassword());
 
            if (user.isEmpty()) { JOptionPane.showMessageDialog(this, "Username tidak boleh kosong!"); return; }
            if (pass.isEmpty()) { JOptionPane.showMessageDialog(this, "Password tidak boleh kosong!"); return; }
            if (!rdLaki.isSelected() && !rdPerempuan.isSelected()) { JOptionPane.showMessageDialog(this, "Pilih jenis kelamin!"); return; }
 
            String sapaan = rdLaki.isSelected() ? "Mr." : "Mrs.";
            new HalamanUtama(sapaan, user).setVisible(true);
            dispose();
        });
    }
 
    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}