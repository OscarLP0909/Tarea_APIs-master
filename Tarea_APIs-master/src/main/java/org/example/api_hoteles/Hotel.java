package org.example.api_hoteles;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="hotel")
@Data
public class Hotel {
    @Id
    private String _id;
    private String nombre;
    private String ciudad;
    private String pais;
    private Integer estrellas;
    private double precioPorNoche;
    private String telefono;
}
