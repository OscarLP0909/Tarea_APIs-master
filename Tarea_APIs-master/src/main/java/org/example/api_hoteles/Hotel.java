package org.example.api_hoteles;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Representa un documento de la colección "hotel" en MongoDB.
 * <p>
 * La clase {@code Hotel} modela los datos básicos de un hotel, incluyendo
 * su ubicación, número de estrellas, precio por noche y datos de contacto.
 * <p>
 * Usa anotaciones de Spring Data MongoDB para mapear esta clase a la colección
 * correspondiente y Lombok para generar automáticamente getters, setters,
 * {@code toString()}, {@code equals()} y {@code hashCode()}.
 *
 * @author [Tu Nombre]
 * @version 1.0
 */
@Document(collection = "hotel")
@Data
public class Hotel {

    /**
     * Identificador único del hotel.
     * Mapeado como el campo {@code _id} en MongoDB.
     */
    @Id
    private String _id;

    /**
     * Nombre del hotel.
     */
    private String nombre;

    /**
     * Ciudad donde se encuentra el hotel.
     */
    private String ciudad;

    /**
     * País donde se encuentra el hotel.
     */
    private String pais;

    /**
     * Número de estrellas que tiene el hotel (por ejemplo, 3, 4, 5).
     */
    private Integer estrellas;

    /**
     * Precio por noche para alojarse en el hotel.
     */
    private double precioPorNoche;

    /**
     * Número de teléfono de contacto del hotel.
     */
    private String telefono;
}
