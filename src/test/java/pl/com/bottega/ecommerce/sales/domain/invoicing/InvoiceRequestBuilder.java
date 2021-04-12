package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;

import java.util.List;

public class InvoiceRequestBuilder {
  private ClientData client = new ClientDataBuilder().build();
  private List<RequestItem> items = List.of(new RequestItemBuilder().build());

  public InvoiceRequest build() {
    InvoiceRequest invoiceRequest = new InvoiceRequest(client);
    for (RequestItem item : items) {
      invoiceRequest.add(item);
    }
    return invoiceRequest;
  }

  public InvoiceRequestBuilder withClient(ClientData client) {
    this.client = client;
    return this;
  }

  public InvoiceRequestBuilder withItems(List<RequestItem> items) {
    this.items = items;
    return this;
  }
}
