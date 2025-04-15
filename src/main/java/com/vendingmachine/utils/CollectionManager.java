package com.vendingmachine.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import com.vendingmachine.models.AbstractProduct;

public class CollectionManager {
    private List<AbstractProduct> productList;
    private Set<AbstractProduct> productSet;

    public CollectionManager() {
        productList = new ArrayList<>();
        productSet = new HashSet<>();
    }

    public void addToList(AbstractProduct product) {
        productList.add(product);
    }

    public void addToSet(AbstractProduct product) {
        productSet.add(product);
    }

    public AbstractProduct getFromList(int index) {
        return productList.get(index);
    }

    public AbstractProduct getFromSet(AbstractProduct product) {
        for (AbstractProduct p : productSet) {
            if (p.getName().equals(product.getName())) {
                return p;
            }
        }
        return null;
    }

    public void removeFromList(AbstractProduct product) {
        productList.remove(product);
    }

    public void removeFromSet(AbstractProduct product) {
        productSet.remove(product);
    }
}