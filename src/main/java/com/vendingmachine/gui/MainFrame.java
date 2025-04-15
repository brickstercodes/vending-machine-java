package com.vendingmachine.gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private ProductPanel productPanel;
    private TransactionPanel transactionPanel;

    public MainFrame() {
        setTitle("Vending Machine");
        setSize(400, 700); // Made taller to accommodate cart
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Initialize panels
        productPanel = new ProductPanel();
        transactionPanel = new TransactionPanel(productPanel);

        // Connect the panels
        productPanel.setTransactionPanel(transactionPanel);

        // Add panels with some padding
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Update cart summary when items are added
        productPanel.addPropertyChangeListener("cartUpdated",
                evt -> transactionPanel.updateCartSummary(productPanel.getCartItems()));

        contentPane.add(productPanel, BorderLayout.CENTER);
        contentPane.add(transactionPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);

        // Center the frame on screen
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}