package org.example.api_hoteles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de hoteles.
 * <p>
 * Proporciona endpoints para consultar y crear hoteles en la base de datos.
 * Utiliza {@link HotelRepository} para interactuar con la capa de datos.
 * <p>
 * Las rutas de este controlador están prefijadas con <strong>/api</strong>.
 *
 * @author [Tu Nombre]
 * @version 1.0
 */
@RestController
@RequestMapping("/api")
public class APIController {

    /**
     * Repositorio para acceder a los datos de los hoteles.
     */
    @Autowired
    private HotelRepository hotelRepository;

    /**
     * Obtiene la lista completa de hoteles almacenados en la base de datos.
     * <p>
     * Endpoint: <strong>GET /api/hoteles</strong>
     *
     * @return una lista de todos los {@link Hotel} existentes.
     */
    @GetMapping("/hoteles")
    public List<Hotel> all() {
        return hotelRepository.findAll();
    }

    /**
     * Busca hoteles por ciudad.
     * <p>
     * Endpoint: <strong>GET /api/ciudad/{ciudad}</strong>
     *
     * @param ciudad el nombre de la ciudad a filtrar.
     * @return una lista de {@link Hotel} ubicados en la ciudad especificada,
     *         o {@code null} si no se encuentran coincidencias.
     */
    @GetMapping("/ciudad/{ciudad}")
    public List<Hotel> findByCiudad(@PathVariable String ciudad) {
        if (hotelRepository.findHotelesByCiudad(ciudad).isEmpty()) {
            return null;
        }
        return hotelRepository.findHotelesByCiudad(ciudad);
    }

    /**
     * Crea un nuevo hotel en la base de datos.
     * <p>
     * Endpoint: <strong>POST /api/hoteles</strong>
     *
     * @param hotel el objeto {@link Hotel} enviado en el cuerpo de la solicitud.
     * @return el objeto {@link Hotel} creado.
     */
    @PostMapping("/hoteles")
    public Hotel create(@RequestBody Hotel hotel) {
        hotelRepository.save(hotel);
        return hotel;
    }
}
