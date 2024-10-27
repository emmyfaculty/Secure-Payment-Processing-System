package david.abejirin.service.impl;

import david.abejirin.entity.Payment;
import david.abejirin.enums.PaymentStatus;
import david.abejirin.exception.PaymentProcessingException;
import david.abejirin.payload.requests.PaymentRequest;
import david.abejirin.repository.PaymentRepository;
import david.abejirin.service.PaymentGatewayService;
import david.abejirin.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final PaymentGatewayService gatewayService;

    @Transactional
    public Payment processPayment(PaymentRequest request) {
        Payment payment = createPayment(request);

        try {
            boolean processed = gatewayService.processPayment(request);
            payment.setStatus(processed ? PaymentStatus.COMPLETED : PaymentStatus.FAILED);
        } catch (Exception e) {
            payment.setStatus(PaymentStatus.FAILED);
            throw new PaymentProcessingException("Payment processing failed", e);
        }

        return paymentRepository.save(payment);
    }
    private Payment createPayment(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setTransactionId("P-C"+ LocalDate.now().toString() + UUID.randomUUID().toString());
        payment.setType(request.getType());
        payment.setAmount(request.getAmount());
        payment.setCurrencyCode(request.getCurrencyCode());
        payment.setStatus(PaymentStatus.PENDING);
        return payment;
    }
}
