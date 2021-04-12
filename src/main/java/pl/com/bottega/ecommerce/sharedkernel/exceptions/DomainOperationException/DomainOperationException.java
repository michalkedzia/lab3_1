package pl.com.bottega.ecommerce.sharedkernel.exceptions.DomainOperationException;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

public class DomainOperationException extends RuntimeException {

  /** */
  private static final long serialVersionUID = -1698858061607208429L;

  private final Id id;

  public DomainOperationException(Id id, String string) {
    super(string);
    this.id = id;
  }

  public Id getId() {
    return id;
  }
}
