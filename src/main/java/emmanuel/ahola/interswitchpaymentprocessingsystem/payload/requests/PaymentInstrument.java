package david.abejirin.payload.requests;

import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PaymentInstrument {
    @Pattern(regexp = "\\d{16}", message = "Card number must be 16 digits")
    private String cardNumber;

    @Pattern(regexp = "\\d{2}", message = "Expiry month must be 2 digits")
    private String expiryMonth;

    @Pattern(regexp = "\\d{2}", message = "Expiry year must be 2 digits")
    private String expiryYear;

    @Pattern(regexp = "\\d{3,4}", message = "CVV must be 3 or 4 digits")
    private String cvv;

    private String accountNumber;
    private String routingNumber;
}
