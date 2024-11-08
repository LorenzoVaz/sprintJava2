package com.example.odontologyapp.service;

import com.example.odontologyapp.model.Sinistro;
import com.example.odontologyapp.repository.SinistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SinistroService {

    @Autowired
    private SinistroRepository sinistroRepository;

    public Sinistro salvarSinistro(Sinistro sinistro) {
        return sinistroRepository.save(sinistro);
    }

    public Page<Sinistro> listarTodos(int page, int size) {
        return sinistroRepository.findAll(PageRequest.of(page, size));
    }

    public Sinistro buscarPorId(UUID id) {
        return sinistroRepository.findById(id).orElseThrow();
    }

    public Sinistro atualizarSinistro(Sinistro sinistro) {
        return sinistroRepository.save(sinistro);
    }

    public void deletarSinistro(UUID id) {
        sinistroRepository.deleteById(id);
    }
}