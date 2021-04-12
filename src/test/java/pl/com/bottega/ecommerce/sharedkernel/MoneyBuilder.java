package pl.com.bottega.ecommerce.sharedkernel;

import java.math.BigDecimal;

public class MoneyBuilder {
  private BigDecimal value = new BigDecimal(51);
  private final Money money = new Money(value);

  public Money build() {
    return money;
  }

  public MoneyBuilder withMoneyValue(BigDecimal value) {
    this.value = value;
    return this;
  }
}
