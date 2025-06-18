package br.com.projetos.apirestaurante.domain.models.reserve;

import br.com.projetos.apirestaurante.domain.models.user.User;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "RESERVES")
public class Reserve {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "reserve_id")
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private LocalDateTime reservationDate;

    @Column(nullable = false)
    private int numberPeople;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User reservationUser;

    @ManyToOne
    @JoinColumn(name = "diningTable_id")
    private DiningTable table;

    enum Status{
        CONFIRMED,
        WAITING_CONFIRMATION,
        HAPPENING,
        FINISHED,
        CANCELED;
    }


}
