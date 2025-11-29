package com.tecnar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "clientes")
public class ClienteDoc {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String username;
    private String direccion;
    private String telefono;
    private String email;
}
