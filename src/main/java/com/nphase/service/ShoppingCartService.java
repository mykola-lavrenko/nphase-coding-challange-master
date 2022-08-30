package com.nphase.service;

import com.nphase.configuration.ProductDiscountProperties;
import com.nphase.domain.User;
import com.nphase.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.math.BigDecimal;

@Service
public class ShoppingCartService {
    private final ProductDiscountProperties productDiscountProperties;
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(@Nonnull final ProductDiscountProperties productDiscountProperties,
                               @Nonnull final ShoppingCartRepository shoppingCartRepository) {
        this.productDiscountProperties = productDiscountProperties;
        this.shoppingCartRepository = shoppingCartRepository;
    }

    public BigDecimal calculateTotalPrice(@Nonnull final User user) {
        return shoppingCartRepository.findByUser(user)
                .getProducts()
                .stream()
                .map(product -> product.getProductTotalPrice(productDiscountProperties.getCount(), productDiscountProperties.getAmount()))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
