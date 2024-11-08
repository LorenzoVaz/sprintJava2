package com.example.odontologyapp.service;

import com.example.odontologyapp.model.Paciente;
import com.example.odontologyapp.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public Page<Paciente> listarTodos(int page, int size) {
        return pacienteRepository.findAll(PageRequest.of(page, size));
    }

    public Paciente buscarPorId(Long id) {
        return pacienteRepository.findById(id).orElseThrow();
    }

    public Paciente atualizarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }
}