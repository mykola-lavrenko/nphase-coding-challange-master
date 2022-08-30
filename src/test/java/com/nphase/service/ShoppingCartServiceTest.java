package com.nphase.service;

import com.nphase.domain.User;
import com.nphase.repository.UserRepository;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@Sql(executionPhase = AFTER_TEST_METHOD, scripts = "/sql/cleanup.sql")
@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = {"/sql/test_data.sql"})
class ShoppingCartServiceTest {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private UserRepository userRepository;

    @ParameterizedTest(name = "calculateTotalPrice should return shopping cart total price={1} when user id={0}")
    @CsvSource({"1, 16.5", "2, 0", "3, 31.95", "4, 31.84"})
    void calculateTotalPrice(Long userId, BigDecimal expectedTotalPrice) {
        final User user = userRepository.findById(userId).orElseThrow(AssertionError::new);

        final BigDecimal totalPrice = shoppingCartService.calculateTotalPrice(user);

        assertEquals(expectedTotalPrice, totalPrice.stripTrailingZeros());
    }
}