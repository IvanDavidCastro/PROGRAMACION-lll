package com.tecnar.service.impl;

import com.tecnar.model.ClienteDTO;
import com.tecnar.model.ClienteDoc;
import com.tecnar.repository.ClienteRepositoryMongo;
import com.tecnar.service.ClienteService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Profile("mongodb")
public class ClienteServiceMongoImpl implements ClienteService {

    private final ClienteRepositoryMongo repo;

    public ClienteServiceMongoImpl(ClienteRepositoryMongo repo){ this.repo = repo; }

    private ClienteDTO toDto(ClienteDoc d){
        return new ClienteDTO(d.getId(), d.getNombre(), d.getApellido(), d.getUsername(), d.getDireccion(), d.getTelefono(), d.getEmail());
    }

    public ClienteDTO create(ClienteDTO dto){
        ClienteDoc d = new ClienteDoc(null, dto.getNombre(), dto.getApellido(), dto.getUsername(), dto.getDireccion(), dto.getTelefono(), dto.getEmail());
        ClienteDoc saved = repo.save(d);
        return toDto(saved);
    }

    public List<ClienteDTO> findAll(){ return repo.findAll().stream().map(this::toDto).collect(Collectors.toList()); }

    public Optional<ClienteDTO> findById(String id){ return repo.findById(id).map(this::toDto); }

    public ClienteDTO update(String id, ClienteDTO dto){
        ClienteDoc d = repo.findById(id).orElseThrow();
        d.setNombre(dto.getNombre()); d.setApellido(dto.getApellido()); d.setUsername(dto.getUsername());
        d.setDireccion(dto.getDireccion()); d.setTelefono(dto.getTelefono()); d.setEmail(dto.getEmail());
        return toDto(repo.save(d));
    }

    public void delete(String id){ repo.deleteById(id); }
}
