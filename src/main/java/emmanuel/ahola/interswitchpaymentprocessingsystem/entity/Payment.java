package david.abejirin.entity;

import david.abejirin.enums.PaymentStatus;
import david.abejirin.enums.PaymentType;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String transactionId;

    @Enumerated(EnumType.STRING)
    private PaymentType type;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(length = 3)
    private String currencyCode;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private Instant createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = Instant.now();
    }
}

