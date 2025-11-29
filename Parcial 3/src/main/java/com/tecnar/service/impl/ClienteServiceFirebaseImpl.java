package com.tecnar.service.impl;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.tecnar.model.ClienteDTO;
import com.tecnar.service.ClienteService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
@Profile("firebase")
public class ClienteServiceFirebaseImpl implements ClienteService {

    private final Firestore db = FirestoreClient.getFirestore();
    private final String COLLECTION = "clientes";

    private ClienteDTO toDto(DocumentSnapshot s){
        Map<String,Object> m = s.getData();
        if(m==null) return null;
        return new ClienteDTO(s.getId(),
                (String)m.getOrDefault("nombre",""),
                (String)m.getOrDefault("apellido",""),
                (String)m.getOrDefault("username",""),
                (String)m.getOrDefault("direccion",""),
                (String)m.getOrDefault("telefono",""),
                (String)m.getOrDefault("email",""));
    }

    public ClienteDTO create(ClienteDTO dto){
        try{
            Map<String,Object> data = new HashMap<>();
            data.put("nombre", dto.getNombre()); data.put("apellido", dto.getApellido());
            data.put("username", dto.getUsername()); data.put("direccion", dto.getDireccion());
            data.put("telefono", dto.getTelefono()); data.put("email", dto.getEmail());
            ApiFuture<DocumentReference> future = db.collection(COLLECTION).add(data);
            String id = future.get().getId();
            dto.setId(id);
            return dto;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    public List<ClienteDTO> findAll(){
        try{
            ApiFuture<QuerySnapshot> future = db.collection(COLLECTION).get();
            List<QueryDocumentSnapshot> docs = future.get().getDocuments();
            return docs.stream().map(this::toDto).collect(Collectors.toList());
        }catch(Exception ex){ throw new RuntimeException(ex); }
    }

    public Optional<ClienteDTO> findById(String id){
        try{
            DocumentSnapshot s = db.collection(COLLECTION).document(id).get().get();
            if(!s.exists()) return Optional.empty();
            return Optional.ofNullable(toDto(s));
        }catch(Exception ex){ throw new RuntimeException(ex); }
    }

    public ClienteDTO update(String id, ClienteDTO dto){
        try{
            Map<String,Object> data = new HashMap<>();
            data.put("nombre", dto.getNombre()); data.put("apellido", dto.getApellido());
            data.put("username", dto.getUsername()); data.put("direccion", dto.getDireccion());
            data.put("telefono", dto.getTelefono()); data.put("email", dto.getEmail());
            ApiFuture<WriteResult> w = db.collection(COLLECTION).document(id).set(data);
            w.get();
            dto.setId(id);
            return dto;
        }catch(Exception ex){ throw new RuntimeException(ex); }
    }

    public void delete(String id){
        try{ db.collection(COLLECTION).document(id).delete().get(); }
        catch(Exception ex){ throw new RuntimeException(ex); }
    }
}
