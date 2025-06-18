package br.com.projetos.apirestaurante.domain.models.product;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "INGREDIENT")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ingredient_id")
    private UUID id;

    private String Name;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    private Integer amount;

    private BigDecimal unitValue;

    private LocalDateTime supplyDate;

    @ManyToOne
    @JoinColumn(name = "categoryItens_id")
    private CategoryItens categoryItens;


}
