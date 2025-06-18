package br.com.projetos.apirestaurante.domain.models.reserve;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "DINING_TABLE")
public class DiningTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diningTable_id")
    private int id;

    private boolean IsAvailable;
}
