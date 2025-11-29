package com.tecnar.service;

import com.tecnar.model.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    ClienteDTO create(ClienteDTO dto);
    List<ClienteDTO> findAll();
    Optional<ClienteDTO> findById(String id);
    ClienteDTO update(String id, ClienteDTO dto);
    void delete(String id);
}
