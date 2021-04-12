package pl.com.bottega.ecommerce.sales.domain.reservation;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

public class ReservedProduct {
  private final String name;

  private final Money totalCost;

  private final Id productId;

  private final int quantity;

  public ReservedProduct(Id productId, String name, int quantity, Money totalCost) {
    this.productId = productId;
    this.name = name;
    this.quantity = quantity;
    this.totalCost = totalCost;
  }

  public String getName() {
    return name;
  }

  public Money getTotalCost() {
    return totalCost;
  }

  public Id getProductId() {
    return productId;
  }

  public int getQuantity() {
    return quantity;
  }
}
