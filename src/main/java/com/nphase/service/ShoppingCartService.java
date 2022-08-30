package com.nphase.service;

import com.nphase.domain.Product;
import com.nphase.domain.User;
import com.nphase.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(@Nonnull final ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public BigDecimal calculateTotalPrice(@Nonnull final User user) {
        return shoppingCartRepository.findByUser(user)
                .getProducts()
                .stream()
                .map(Product::getProductTotalPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
