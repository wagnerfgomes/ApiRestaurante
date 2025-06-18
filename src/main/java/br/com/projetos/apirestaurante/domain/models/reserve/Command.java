package br.com.projetos.apirestaurante.domain.models.reserve;

import br.com.projetos.apirestaurante.domain.models.product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "COMMAND")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "command_id")
    private UUID id;

    @OneToOne
    private Reserve reserve;

    @ManyToOne
    @JoinColumn(name = "diningTable_id")
    private DiningTable table;

    @ManyToMany
    @JoinTable(
            name = "PRODUCTS_COMMAND",
            joinColumns = @JoinColumn(name = "command_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime IssueDate;

    enum Status{
        OPEN,
        CLOSE,
        CANCELED;
    }

}
