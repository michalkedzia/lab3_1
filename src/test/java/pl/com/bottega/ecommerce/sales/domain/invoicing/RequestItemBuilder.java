package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductDataBuilder;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.ArrayList;
import java.util.List;

public class RequestItemBuilder {
  private ProductData productData = new ProductDataBuilder().build();
  private int quantity = 4;
  private Money totalCost = productData.getPrice().multiplyBy(quantity);

  public RequestItem build() {
    return new RequestItem(productData, quantity, totalCost);
  }

  public List<RequestItem> buildToList() {
    List<RequestItem> requestItems = new ArrayList<>();
    requestItems.add(build());
    return requestItems;
  }

  public RequestItemBuilder withProductData(ProductData productData) {
    this.productData = productData;
    return this;
  }

  public RequestItemBuilder withQuantity(int quantity) {
    this.quantity = quantity;
    return this;
  }

  public RequestItemBuilder withTotalCost(Money totalCost) {
    this.totalCost = totalCost;
    return this;
  }
}
