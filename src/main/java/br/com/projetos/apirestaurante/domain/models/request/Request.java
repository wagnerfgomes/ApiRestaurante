package br.com.projetos.apirestaurante.domain.models.request;

import br.com.projetos.apirestaurante.domain.models.product.Product;
import br.com.projetos.apirestaurante.domain.models.reserve.DiningTable;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "REQUEST")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "request_id")
    private UUID id;

    private LocalDateTime dateTime;

    @ManyToMany
    @JoinTable(
            name = "request_product",
            joinColumns = @JoinColumn(name = "request_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @OneToOne
    @JoinColumn(name = "diningTable_id")
    private DiningTable diningTable;

    private Status status;

    enum Status{
        IN_PREPARATION,
        READY
    }
}
