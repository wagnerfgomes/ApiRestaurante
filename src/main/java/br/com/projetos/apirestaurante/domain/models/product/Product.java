package br.com.projetos.apirestaurante.domain.models.product;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "product_id")
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ingredient> ingredient;

    private BigDecimal value;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
