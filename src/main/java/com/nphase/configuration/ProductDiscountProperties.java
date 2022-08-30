package com.nphase.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Component
@ConfigurationProperties("product.discount")
public class ProductDiscountProperties {
    @DecimalMax("1.0")
    @DecimalMin("0.0")
    private BigDecimal amount;
    @Min(0)
    private int count;

    public BigDecimal getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
