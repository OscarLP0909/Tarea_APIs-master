package org.example.api_hoteles;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Repositorio de acceso a datos para la entidad {@link Hotel}.
 * <p>
 * Esta interfaz extiende {@link MongoRepository} proporcionando
 * métodos CRUD estándar, así como consultas personalizadas para
 * acceder y filtrar datos en la colección de hoteles.
 * <p>
 * Utiliza las convenciones de nombres de Spring Data MongoDB para
 * generar automáticamente las consultas.
 *
 * @author [Tu Nombre]
 * @version 1.0
 */
public interface HotelRepository extends MongoRepository<Hotel, String> {

    /**
     * Recupera todos los hoteles almacenados en la base de datos.
     *
     * @return una lista de todos los {@link Hotel} existentes.
     */
    List<Hotel> findAll();

    /**
     * Encuentra todos los hoteles que tienen un número específico de estrellas.
     *
     * @param estrellas el número de estrellas del hotel.
     * @return una lista de {@link Hotel} con el número especificado de estrellas.
     */
    List<Hotel> findHotelesByEstrellas(Integer estrellas);

    /**
     * Encuentra todos los hoteles cuyo precio por noche sea menor al valor especificado.
     *
     * @param precioPorNoche el precio máximo por noche.
     * @return una lista de {@link Hotel} con precios por noche menores al valor dado.
     */
    List<Hotel> findByPrecioPorNocheLessThan(double precioPorNoche);

    /**
     * Encuentra todos los hoteles ubicados en una ciudad específica.
     *
     * @param ciudad el nombre de la ciudad.
     * @return una lista de {@link Hotel} ubicados en la ciudad especificada.
     */
    List<Hotel> findHotelesByCiudad(String ciudad);

    /**
     * Encuentra todos los hoteles que tienen un precio exacto por noche utilizando
     * una consulta personalizada en MongoDB.
     *
     * @param precio el precio exacto por noche.
     * @return una lista de {@link Hotel} con el precio especificado.
     */
    @Query("{'precioPorNoche': ?0}")
    List<Hotel> hotelDePrecio(Integer precio);
}
