package org.example.api_hoteles;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface HotelRepository extends MongoRepository<Hotel, String> {
    List<Hotel> findAll();
    public List<Hotel> findHotelesByEstrellas(Integer estrellas);
    public List<Hotel> findByPrecioPorNocheLessThan(double precioPorNoche);
    public List<Hotel>findHotelesByCiudad(String ciudad);

    @Query("{'precioPorNoche':?0}")
    public List<Hotel> hotelDePrecio(Integer precio);
}
