package br.com.projetos.apirestaurante.domain.models.reserve;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "BILL")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "bill_id")
    private UUID id;

    @OneToOne
    private Command command;

    private LocalDateTime issueDate;

    private BigDecimal totalValue;

    @Enumerated(EnumType.STRING)
    private Status status;

    enum Status{
        PAID,
        WAITING_FOR_PAYMENT,
        CANCELED;
    }

}
