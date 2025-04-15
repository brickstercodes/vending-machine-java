package com.vendingmachine.gui;

import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {
    private JLabel totalLabel;
    private JTextArea cartSummary;
    private JTextField amountField;
    private JButton payButton;
    private double currentAmount = 0.0;
    private ProductPanel prod;

    public TransactionPanel(ProductPanel p) {
        this.prod = p;
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Initialize components
        totalLabel = new JLabel("Total Amount: $0.00");
        cartSummary = new JTextArea(4, 20);
        cartSummary.setEditable(false);
        amountField = new JTextField(10);
        payButton = new JButton("Pay");

        // Layout
        JPanel northPanel = new JPanel(new BorderLayout(5, 5));
        northPanel.add(totalLabel, BorderLayout.NORTH);
        northPanel.add(new JScrollPane(cartSummary), BorderLayout.CENTER);

        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        southPanel.add(new JLabel("Enter Amount: $"));
        southPanel.add(amountField);
        southPanel.add(payButton);

        add(northPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        payButton.addActionListener(e -> processPayment());
    }

    public void setAmount(double amount) {
        this.currentAmount = amount;
        totalLabel.setText("Total Amount: $" + String.format("%.2f", amount));
    }

    public void updateCartSummary(java.util.List<com.vendingmachine.models.CartItem> items) {
        StringBuilder summary = new StringBuilder("Cart Contents:\n");
        for (com.vendingmachine.models.CartItem item : items) {
            summary.append(item.toString()).append("\n");
        }
        cartSummary.setText(summary.toString());
    }

    private void processPayment() {
        try {
            double paidAmount = Double.parseDouble(amountField.getText());
            if (paidAmount >= currentAmount) {
                double change = paidAmount - currentAmount;
                JOptionPane.showMessageDialog(this,
                        String.format("Payment successful!\nChange: $%.2f", change),
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                resetTransaction();
                prod.clearCart();
            } else if (paidAmount < 0) {
                JOptionPane.showMessageDialog(this,
                        String.format("Negative money not allowed."),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                double extra = currentAmount - paidAmount;
                JOptionPane.showMessageDialog(this,
                        String.format("Insufficient amount. Please pay more $%.2f", extra),
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid amount entered. Please enter a valid number.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetTransaction() {
        currentAmount = 0.0;
        totalLabel.setText("Total Amount: $0.00");
        amountField.setText("");
        cartSummary.setText("");
    }
}