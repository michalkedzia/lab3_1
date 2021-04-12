package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public class ClientDataBuilder {
  private Id id = Id.generate();
  private String name = "John Doe";

  public ClientData build() {
    return new ClientData(id, name);
  }

  public ClientDataBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public ClientDataBuilder withId(Id id) {
    this.id = id;
    return this;
  }
}
