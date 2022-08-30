package com.nphase.service;

import com.nphase.configuration.ProductDiscountProperties;
import com.nphase.domain.Product;
import com.nphase.domain.User;
import com.nphase.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.math.BigDecimal;
import java.util.Map;

import static java.util.stream.Collectors.*;

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
        final Map<String, BigDecimal> pricePerCategory = shoppingCartRepository.findByUser(user)
                .getProducts()
                .stream()
                .collect(groupingBy(Product::getCategory, teeing(
                        summingInt(Product::getQuantity),
                        reducing(BigDecimal.ZERO, Product::getProductTotalPrice, BigDecimal::add),
                        this::applyDiscount)));

        return pricePerCategory
                .values()
                .stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal applyDiscount(int quantity, BigDecimal totalPrice) {
        BigDecimal discount;
        if (quantity > productDiscountProperties.getCount()) {
            discount = productDiscountProperties.getAmount();
        } else {
            discount = BigDecimal.ZERO;
        }

        return totalPrice.multiply(BigDecimal.ONE.subtract(discount));
    }
}
