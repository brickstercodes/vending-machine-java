package com.vendingmachine.gui;

import com.vendingmachine.models.CartItem;
import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeSupport;
import java.util.*;
import java.util.List;

public class ProductPanel extends JPanel {
    private JComboBox<String> productComboBox;
    private JSpinner quantitySpinner;
    private JButton addToCartButton;
    private JList<CartItem> cartList;
    private DefaultListModel<CartItem> cartModel;
    private JLabel priceLabel;
    private TransactionPanel transactionPanel;
    private Map<String, Double> productPrices;
    private List<CartItem> cartItems;
    private PropertyChangeSupport propertyChangeSupport;

    public ProductPanel() {
        propertyChangeSupport = new PropertyChangeSupport(this);
        setLayout(new BorderLayout(10, 10));
        cartItems = new ArrayList<>();
        initializePrices();
        initializeComponents();
        layoutComponents();
        setupListeners();
    }

    private void initializePrices() {
        productPrices = new HashMap<>();
        productPrices.put("Cola", 1.50);
        productPrices.put("Water", 1.00);
        productPrices.put("Chips", 0.75);
        productPrices.put("Chocolate", 1.25);
    }

    private void initializeComponents() {
        productComboBox = new JComboBox<>(productPrices.keySet().toArray(new String[0]));
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        addToCartButton = new JButton("Add to Cart");
        cartModel = new DefaultListModel<>();
        cartList = new JList<>(cartModel);
        priceLabel = new JLabel("Price: $" + productPrices.get(productComboBox.getSelectedItem()));
    }

    private void layoutComponents() {
        // Product selection panel
        JPanel selectionPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        selectionPanel.setBorder(BorderFactory.createTitledBorder("Select Product"));
        selectionPanel.add(productComboBox);
        selectionPanel.add(priceLabel);

        JPanel quantityPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        quantityPanel.add(new JLabel("Quantity:"));
        quantityPanel.add(quantitySpinner);
        selectionPanel.add(quantityPanel);
        selectionPanel.add(addToCartButton);

        // Cart panel
        JPanel cartPanel = new JPanel(new BorderLayout(5, 5));
        cartPanel.setBorder(BorderFactory.createTitledBorder("Shopping Cart"));
        cartList.setPreferredSize(new Dimension(200, 150));
        cartPanel.add(new JScrollPane(cartList), BorderLayout.CENTER);

        // Clear cart button
        JButton clearCartButton = new JButton("Clear Cart");
        clearCartButton.addActionListener(e -> clearCart());
        cartPanel.add(clearCartButton, BorderLayout.SOUTH);

        // Main layout
        add(selectionPanel, BorderLayout.NORTH);
        add(cartPanel, BorderLayout.CENTER);
    }

    private void setupListeners() {
        productComboBox.addActionListener(e -> {
            String selected = (String) productComboBox.getSelectedItem();
            priceLabel.setText("Price: $" + String.format("%.2f", productPrices.get(selected)));
        });

        addToCartButton.addActionListener(e -> addToCart());
    }

    private void addToCart() {
        String selectedProduct = (String) productComboBox.getSelectedItem();
        double price = productPrices.get(selectedProduct);
        int quantity = (int) quantitySpinner.getValue();

        CartItem newItem = new CartItem(selectedProduct, price, quantity);
        cartItems.add(newItem);
        cartModel.addElement(newItem);
        updateTransactionPanel();
        propertyChangeSupport.firePropertyChange("cartUpdated", null, cartItems);
    }

    private void clearCart() {
        cartItems.clear();
        cartModel.clear();
        updateTransactionPanel();
        propertyChangeSupport.firePropertyChange("cartUpdated", null, cartItems);
    }

    private void updateTransactionPanel() {
        if (transactionPanel != null) {
            double total = cartItems.stream()
                    .mapToDouble(CartItem::getTotal)
                    .sum();
            transactionPanel.setAmount(total);
        }
    }

    public void setTransactionPanel(TransactionPanel panel) {
        this.transactionPanel = panel;
    }

    public List<CartItem> getCartItems() {
        return new ArrayList<>(cartItems);
    }

    public void addPropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName, java.beans.PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(propertyName, listener);
    }
}