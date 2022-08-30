package com.nphase.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "shoppingCart", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Product> products = Collections.emptyList();

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return List.copyOf(products);
    }

    public User getUser() {
        return user;
    }
}
