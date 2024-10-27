package david.abejirin.payload.requests;

import david.abejirin.enums.PaymentType;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentRequest {
    @NotNull(message = "Payment type is required")
    private PaymentType type;

    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    @NotNull(message = "Amount is required")
    private BigDecimal amount;

    @Pattern(regexp = "[A-Z]{3}", message = "Currency code must be 3 uppercase letters")
    private String currencyCode;

    private PaymentInstrument paymentInstrument;
}
