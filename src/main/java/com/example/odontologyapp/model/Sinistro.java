package com.example.odontologyapp.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "sinistros")
public class Sinistro {
    @Id
    private UUID id = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Column(nullable = false)
    private String descricao;

    @Lob
    @Column(columnDefinition = "TEXT")
    private byte[] imagem;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    // Getters e setters
}