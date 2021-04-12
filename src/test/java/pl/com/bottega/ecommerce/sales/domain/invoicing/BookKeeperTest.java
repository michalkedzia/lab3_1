package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.MoneyBuilder;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class BookKeeperTest {

  @Mock BookKeeper bookKeeper;

  @Mock InvoiceFactory invoiceFactory;

  @Mock TaxPolicy taxPolicy;

  @BeforeEach
  void setUp() throws Exception {
    bookKeeper = new BookKeeper(invoiceFactory);
  }

  @Test
  void expected_invoice_with_one_item() {
    // Given
    ClientData clientData = new ClientDataBuilder().build();
    InvoiceRequest invoiceRequest =
        new InvoiceRequestBuilder()
            .withItems(new RequestItemBuilder().buildToList())
            .withClient(clientData)
            .build();
    Mockito.when(invoiceFactory.create(clientData))
        .thenReturn(new Invoice(Id.generate(), clientData));
    Mockito.when(taxPolicy.calculateTax(Mockito.any(), Mockito.any()))
        .thenReturn(new Tax(new MoneyBuilder().build(), "desc"));

    // When
    Invoice issuance = bookKeeper.issuance(invoiceRequest, taxPolicy);

    // Then
    Assertions.assertEquals(issuance.getItems().size(), 1);
  }

  @Test
  void expected_calling_method_calculateTax_two_times() {
    // Given
    ClientData clientData = new ClientDataBuilder().build();
    List<RequestItem> requestItems = new RequestItemBuilder().buildToList();
    requestItems.add(new RequestItemBuilder().build());

    InvoiceRequest invoiceRequest =
        new InvoiceRequestBuilder().withItems(requestItems).withClient(clientData).build();

    Mockito.when(invoiceFactory.create(clientData))
        .thenReturn(new Invoice(Id.generate(), clientData));
    Mockito.when(taxPolicy.calculateTax(Mockito.any(), Mockito.any()))
        .thenReturn(new Tax(new MoneyBuilder().build(), "desc"));

    // When
    Invoice issuance = bookKeeper.issuance(invoiceRequest, taxPolicy);

    // Then
    Mockito.verify(taxPolicy, Mockito.times(2)).calculateTax(Mockito.any(), Mockito.any());
    Assertions.assertEquals(issuance.getItems().size(), 2);

    Assertions.assertEquals(
        issuance.getItems().get(0).getProduct().getName(),
        requestItems.get(0).getProductData().getName());
    Assertions.assertEquals(
        issuance.getItems().get(1).getProduct().getName(),
        requestItems.get(1).getProductData().getName());
  }
}
