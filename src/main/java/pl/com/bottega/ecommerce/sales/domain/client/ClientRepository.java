package pl.com.bottega.ecommerce.sales.domain.client;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public interface ClientRepository {
  Client load(Id id);

  void save(Client client);
}
