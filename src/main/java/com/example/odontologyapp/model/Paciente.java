package com.example.odontologyapp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    @Column(nullable = false)
    private LocalDateTime dataNascimento;

    // Getters e setters
}