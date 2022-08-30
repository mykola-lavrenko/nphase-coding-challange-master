package com.nphase.repository;

import com.nphase.domain.ShoppingCart;
import com.nphase.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    @Nonnull
    ShoppingCart findByUser(@Nonnull final User user);
}
