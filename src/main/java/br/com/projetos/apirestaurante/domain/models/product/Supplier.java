package br.com.projetos.apirestaurante.domain.models.product;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "SUPPLIER")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "supplier_id")
    private UUID id;

    private String name;

    private String address;

    private String Email;

    private String number;

    @Enumerated(EnumType.STRING)
    private TypeSupply typeSupply;

    private boolean IsActive;

    enum TypeSupply{
        OF_PRODUCT,
        OF_INGREDIENTS;
    }

}
