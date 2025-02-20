package org.example.api_hoteles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    @Autowired private HotelRepository hotelRepository;

    @GetMapping("/hoteles")
    public List<Hotel> all(){
        return hotelRepository.findAll();
    }

    @GetMapping("/ciudad/{ciudad}")
    public List<Hotel> findByCiudad(@PathVariable String ciudad){
        if (hotelRepository.findHotelesByCiudad(ciudad).isEmpty()){
            return null;
        }
        return hotelRepository.findHotelesByCiudad(ciudad);
    }

    @PostMapping("/hoteles")
    public Hotel create(@RequestBody Hotel hotel){
        hotelRepository.save(hotel);
        return hotel;
    }
}
