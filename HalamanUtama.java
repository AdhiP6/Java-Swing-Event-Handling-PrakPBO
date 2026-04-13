/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kalkulator;

import javax.swing.*;
import java.awt.*;
 
public class HalamanUtama extends JFrame {
 
    JTextField panjang = new JTextField();
    JTextField lebar   = new JTextField();
    JTextField tinggi  = new JTextField();
    JLabel luas          = new JLabel("-");
    JLabel keliling      = new JLabel("-");
    JLabel volume        = new JLabel("-");
    JLabel luasPermukaan = new JLabel("-");
 
    public HalamanUtama(String sapaan, String username) {
        setTitle("Halaman Utama");
        setSize(500, 480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
 
        JPanel mainPanel = new JPanel(new BorderLayout(0, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
 
        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 0, 4));
        JLabel welcomeLabel = new JLabel("Welcome, " + sapaan + " " + username);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        JLabel subtitleLabel = new JLabel("Tentukan panjang, lebar, dan tinggi untuk menghitung Balok");
        subtitleLabel.setFont(new Font("SansSerif", Font.PLAIN, 12));
        subtitleLabel.setForeground(Color.GRAY);
        headerPanel.add(welcomeLabel);
        headerPanel.add(subtitleLabel);
 
        panjang.setPreferredSize(new Dimension(0, 24));
        lebar.setPreferredSize(new Dimension(0, 24));
        tinggi.setPreferredSize(new Dimension(0, 24));
 
        JButton hitungBtn = new JButton("Hitung");
        JButton resetBtn  = new JButton("Reset");
        hitungBtn.setPreferredSize(new Dimension(0, 28));
        resetBtn.setPreferredSize(new Dimension(0, 28));
        hitungBtn.setFocusPainted(false);
        resetBtn.setFocusPainted(false);
 
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
 
        // Input Panjang
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.35; gbc.gridwidth = 1;
        gbc.insets = new Insets(4, 0, 4, 8);
        inputPanel.add(new JLabel("Panjang"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.65; gbc.insets = new Insets(4, 0, 4, 0);
        inputPanel.add(panjang, gbc);
 
        // Input Lebar
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.35; gbc.insets = new Insets(4, 0, 4, 8);
        inputPanel.add(new JLabel("Lebar"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.65; gbc.insets = new Insets(4, 0, 4, 0);
        inputPanel.add(lebar, gbc);
 
        // Input Tinggi
        gbc.gridx = 0; gbc.gridy = 2; gbc.weightx = 0.35; gbc.insets = new Insets(4, 0, 4, 8);
        inputPanel.add(new JLabel("Tinggi"), gbc);
        gbc.gridx = 1; gbc.weightx = 0.65; gbc.insets = new Insets(4, 0, 4, 0);
        inputPanel.add(tinggi, gbc);
 
        // Tombol Hitung 
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2; gbc.weightx = 1;
        gbc.insets = new Insets(12, 0, 4, 0);
        inputPanel.add(hitungBtn, gbc);
 
        // Tombol Reset 
        gbc.gridy = 4; gbc.insets = new Insets(0, 0, 0, 0);
        inputPanel.add(resetBtn, gbc);
 
        JPanel hasilPanel = new JPanel(new BorderLayout(0, 6));
        hasilPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
 
        JPanel hasilTitlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        JLabel hasilTitle = new JLabel("Hasil");
        hasilTitle.setFont(new Font("SansSerif", Font.BOLD, 13));
        hasilTitlePanel.add(hasilTitle);
 
        JPanel hasilGrid = new JPanel(new GridLayout(4, 2, 5, 8));
        hasilGrid.add(new JLabel("Luas Persegi"));         hasilGrid.add(luas);
        hasilGrid.add(new JLabel("Keliling Persegi"));     hasilGrid.add(keliling);
        hasilGrid.add(new JLabel("Volume Balok"));         hasilGrid.add(volume);
        hasilGrid.add(new JLabel("Luas Permukaan Balok")); hasilGrid.add(luasPermukaan);
 
        hasilPanel.add(hasilTitlePanel, BorderLayout.NORTH);
        hasilPanel.add(hasilGrid,       BorderLayout.CENTER);
 
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(inputPanel,  BorderLayout.CENTER);
        mainPanel.add(hasilPanel,  BorderLayout.SOUTH);
 
        add(mainPanel);
 
        // ── Event ────────────────────────────────────────────────────────────
        hitungBtn.addActionListener(e -> {
            try {
                double p = Double.parseDouble(panjang.getText().trim());
                double l = Double.parseDouble(lebar.getText().trim());
                double t = Double.parseDouble(tinggi.getText().trim());
                if (p <= 0 || l <= 0 || t <= 0) { JOptionPane.showMessageDialog(this, "Nilai harus lebih dari 0!"); return; }
                luas.setText(String.valueOf(p * p));
                keliling.setText(String.valueOf(4 * p));
                volume.setText(String.valueOf(p * l * t));
                luasPermukaan.setText(String.valueOf(2 * (p*l + p*t + l*t)));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Input harus berupa angka!");
            }
        });
 
        resetBtn.addActionListener(e -> {
            panjang.setText(""); 
            lebar.setText(""); 
            tinggi.setText("");
            luas.setText("-"); 
            keliling.setText("-");
            volume.setText("-"); 
            luasPermukaan.setText("-");
        });
    }
}