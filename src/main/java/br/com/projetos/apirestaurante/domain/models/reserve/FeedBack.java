package br.com.projetos.apirestaurante.domain.models.reserve;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "FEEDBACK")
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "feedBack_id")
    private UUID id;

    private double rating;

    @OneToOne
    private Reserve reserve;
}
