package pl.com.bottega.ecommerce.sales.application.api.command;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public class AddProductCommand {

  private final Id orderId;
  private final Id productId;
  private final int quantity;

  public AddProductCommand(Id orderId, Id productId, int quantity) {
    this.orderId = orderId;
    this.productId = productId;
    this.quantity = quantity;
  }

  public Id getOrderId() {
    return orderId;
  }

  public Id getProductId() {
    return productId;
  }

  public int getQuantity() {
    return quantity;
  }
}
