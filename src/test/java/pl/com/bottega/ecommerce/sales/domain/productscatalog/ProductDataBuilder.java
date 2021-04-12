package pl.com.bottega.ecommerce.sales.domain.productscatalog;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import pl.com.bottega.ecommerce.sharedkernel.MoneyBuilder;

import java.util.Date;

public class ProductDataBuilder {
  private Id productId = Id.generate();
  private Money price = new MoneyBuilder().build();
  private String name = "Name";
  private Date snapshotDate = new Date();
  private ProductType type = ProductType.DRUG;

  public ProductData build() {
    return new ProductData(productId, price, name, type, snapshotDate);
  }

  public ProductDataBuilder withProductId(Id id) {
    this.productId = id;
    return this;
  }

  public ProductDataBuilder withPrice(Money price) {
    this.price = price;
    return this;
  }

  public ProductDataBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public ProductDataBuilder withDate(Date date) {
    this.snapshotDate = date;
    return this;
  }

  public ProductDataBuilder withType(ProductType productType) {
    this.type = productType;
    return this;
  }
}
