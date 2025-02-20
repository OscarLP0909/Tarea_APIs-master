package org.example.api_hoteles;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/web")
public class WebController {
    @Autowired
    HotelRepository hotelRepository;

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        var hoteles = hotelRepository.findAll();
        model.addAttribute("titulo","Listado de hoteles");
        model.addAttribute("hoteles", hoteles);
        return "index";
    }

    @GetMapping("/{id}")
    public String single(Model model, @PathVariable String id) {
        var hotel = hotelRepository.findById(id);
        if(hotel.isEmpty()) return "404";

        else {
            model.addAttribute("hotel", hotel.get());
            return "single";
        }
    }


    @GetMapping("/new")
    public String mostrarFormularioNuevoHotel(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "new";
    }


    @PostMapping("/new")
    public String crearHotel(@ModelAttribute Hotel hotel) {
        hotelRepository.save(hotel);
        return "redirect:/web/";
    }

    @GetMapping("{id}/edit")
    public String mostrarFormularioEdicion(@PathVariable String id, Model model) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de hotel no válido: " + id));
        model.addAttribute("hotel", hotel);
        return "edit";
    }




    @PutMapping("{id}/edit")
    public String actualizarHotel(@PathVariable String id, @ModelAttribute Hotel hotel) {
        Hotel hotelExistente = hotelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de hotel no válido: " + id));

        // Actualizar campos
        hotelExistente.setNombre(hotel.getNombre());
        hotelExistente.setCiudad(hotel.getCiudad());
        hotelExistente.setPais(hotel.getPais());
        hotelExistente.setEstrellas(hotel.getEstrellas());
        hotelExistente.setPrecioPorNoche(hotel.getPrecioPorNoche());
        hotelExistente.setTelefono(hotel.getTelefono());

        hotelRepository.save(hotelExistente);

        return "redirect:/web/";
    }


}
