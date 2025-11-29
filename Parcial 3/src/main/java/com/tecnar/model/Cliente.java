package com.tecnar.model;

import lombok.*;
import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String id;
    private String nombre;
    private String apellido;
    private String username;
    private String direccion;
    private String telefono;
    private String email;
}
