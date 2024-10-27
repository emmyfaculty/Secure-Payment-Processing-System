package david.abejirin.service;

import david.abejirin.entity.Payment;
import david.abejirin.payload.requests.PaymentRequest;

public interface PaymentService {
    Payment processPayment(PaymentRequest request);
}
