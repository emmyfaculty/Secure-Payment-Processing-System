package david.abejirin.service;

import david.abejirin.payload.requests.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayService {
    public boolean processPayment(PaymentRequest request) {
        switch (request.getType()) {
            case CREDIT_CARD:
            case DEBIT_CARD:
                return processCardPayment(request);
            case BANK_TRANSFER:
                return processBankTransfer(request);
            default:
                throw new UnsupportedOperationException("Unsupported payment type");
        }
    }

    private boolean processCardPayment(PaymentRequest request) {
        return Math.random() < 0.9;
    }

    private boolean processBankTransfer(PaymentRequest request) {
        return Math.random() < 0.95;
    }
}
