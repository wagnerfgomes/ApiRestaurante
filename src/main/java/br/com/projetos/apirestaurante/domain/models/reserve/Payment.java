package br.com.projetos.apirestaurante.domain.models.reserve;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "payment_id")
    private UUID id;

    @OneToOne
    private Bill bill;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private Status status;

    enum PaymentMethod{
        PIX,
        CREDIT,
        DEBIT,
        IN_SIGHT;
    }

    enum Status{
        APPROVED,
        DENIED;
    }

}
