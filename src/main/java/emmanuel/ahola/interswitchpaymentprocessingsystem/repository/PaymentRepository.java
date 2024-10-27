package david.abejirin.repository;

import david.abejirin.entity.Payment;
import lombok.Lombok;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
