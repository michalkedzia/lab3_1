package pl.com.bottega.ecommerce.sales.domain.productscatalog;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import java.util.List;

public interface ProductRepository {
  Product load(Id productId);

  List<Product> findProductWhereBestBeforeExpiredIn(int days);
}
