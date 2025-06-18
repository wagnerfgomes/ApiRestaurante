package br.com.projetos.apirestaurante.domain.models.product;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "CATEGORYITENS")
public class CategoryItens {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "categoryItens_id")
    private UUID id;

    private String name;

    private String description;

}
