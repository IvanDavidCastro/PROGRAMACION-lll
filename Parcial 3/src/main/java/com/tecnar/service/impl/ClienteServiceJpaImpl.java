package com.tecnar.service.impl;

import com.tecnar.model.ClienteDTO;
import com.tecnar.model.ClienteEntity;
import com.tecnar.repository.ClienteRepositoryJpa;
import com.tecnar.service.ClienteService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Profile("supabase")
public class ClienteServiceJpaImpl implements ClienteService {

    private final ClienteRepositoryJpa repo;

    public ClienteServiceJpaImpl(ClienteRepositoryJpa repo){ this.repo = repo; }

    private ClienteDTO toDto(ClienteEntity e){
        return new ClienteDTO(String.valueOf(e.getId()), e.getNombre(), e.getApellido(), e.getUsername(), e.getDireccion(), e.getTelefono(), e.getEmail());
    }

    public ClienteDTO create(ClienteDTO dto){
        ClienteEntity e = new ClienteEntity();
        e.setNombre(dto.getNombre()); e.setApellido(dto.getApellido()); e.setUsername(dto.getUsername());
        e.setDireccion(dto.getDireccion()); e.setTelefono(dto.getTelefono()); e.setEmail(dto.getEmail());
        ClienteEntity saved = repo.save(e);
        return toDto(saved);
    }

    public List<ClienteDTO> findAll(){
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public Optional<ClienteDTO> findById(String id){
        try{
            Long lid = Long.parseLong(id);
            return repo.findById(lid).map(this::toDto);
        }catch(Exception ex){ return Optional.empty(); }
    }

    public ClienteDTO update(String id, ClienteDTO dto){
        Long lid = Long.parseLong(id);
        ClienteEntity e = repo.findById(lid).orElseThrow();
        e.setNombre(dto.getNombre()); e.setApellido(dto.getApellido()); e.setUsername(dto.getUsername());
        e.setDireccion(dto.getDireccion()); e.setTelefono(dto.getTelefono()); e.setEmail(dto.getEmail());
        return toDto(repo.save(e));
    }

    public void delete(String id){
        Long lid = Long.parseLong(id);
        repo.deleteById(lid);
    }
}
