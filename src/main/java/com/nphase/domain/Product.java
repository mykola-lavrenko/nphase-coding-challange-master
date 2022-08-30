package com.nphase.domain;

import javax.annotation.Nonnull;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table
public class Product implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal pricePerUnit;
    @Column
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "shopping_cart_id", nullable = false)
    private ShoppingCart shoppingCart;

    public String getName() {
        return name;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getProductTotalPrice(final int discountCount, @Nonnull final BigDecimal discount) {
        BigDecimal totalPrice;
        if (quantity > discountCount) {
            totalPrice = pricePerUnit.multiply(BigDecimal.valueOf(quantity))
                    .multiply(BigDecimal.ONE.subtract(discount));
        } else {
            totalPrice = pricePerUnit.multiply(BigDecimal.valueOf(quantity));
        }
        return totalPrice;
    }
}
