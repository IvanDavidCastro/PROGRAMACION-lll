package com.tecnar.controller;

import com.tecnar.model.ClienteDTO;
import com.tecnar.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service){ this.service = service; }

    @GetMapping
    public List<ClienteDTO> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> get(@PathVariable String id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> create(@RequestBody @Validated ClienteDTO dto){
        ClienteDTO created = service.create(dto);
        return ResponseEntity.created(URI.create("/api/clientes/" + created.getId())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable String id, @RequestBody ClienteDTO dto){
        try{
            ClienteDTO updated = service.update(id, dto);
            return ResponseEntity.ok(updated);
        }catch(Exception ex){ return ResponseEntity.notFound().build(); }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
