package org.example.api_hoteles;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador web para la gestión de vistas relacionadas con los hoteles.
 * <p>
 * Proporciona endpoints basados en vistas (Thymeleaf u otro motor de plantillas)
 * para mostrar, crear, editar y actualizar hoteles.
 * <p>
 * Todas las rutas de este controlador están prefijadas con <strong>/web</strong>.
 *
 * @author [Tu Nombre]
 * @version 1.0
 */
@Controller
@RequestMapping("/web")
public class WebController {

    /**
     * Repositorio para acceder a los datos de los hoteles.
     */
    @Autowired
    HotelRepository hotelRepository;

    /**
     * Muestra la página de inicio con un listado de todos los hoteles.
     * <p>
     * Endpoint: <strong>GET /web/</strong>
     *
     * @param session la sesión HTTP actual.
     * @param model   el modelo para pasar datos a la vista.
     * @return la vista "index" con la lista de hoteles.
     */
    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        var hoteles = hotelRepository.findAll();
        model.addAttribute("titulo", "Listado de hoteles");
        model.addAttribute("hoteles", hoteles);
        return "index";
    }

    /**
     * Muestra los detalles de un hotel específico por su ID.
     * <p>
     * Endpoint: <strong>GET /web/{id}</strong>
     *
     * @param model el modelo para pasar datos a la vista.
     * @param id    el ID del hotel.
     * @return la vista "single" si el hotel existe, o "404" si no se encuentra.
     */
    @GetMapping("/{id}")
    public String single(Model model, @PathVariable String id) {
        var hotel = hotelRepository.findById(id);
        if (hotel.isEmpty()) return "404";
        else {
            model.addAttribute("hotel", hotel.get());
            return "single";
        }
    }

    /**
     * Muestra el formulario para crear un nuevo hotel.
     * <p>
     * Endpoint: <strong>GET /web/new</strong>
     *
     * @param model el modelo para pasar datos a la vista.
     * @return la vista "new" con el formulario.
     */
    @GetMapping("/new")
    public String mostrarFormularioNuevoHotel(Model model) {
        model.addAttribute("hotel", new Hotel());
        return "new";
    }

    /**
     * Procesa la creación de un nuevo hotel.
     * <p>
     * Endpoint: <strong>POST /web/new</strong>
     *
     * @param hotel el objeto {@link Hotel} enviado desde el formulario.
     * @return redirección a la página principal de hoteles.
     */
    @PostMapping("/new")
    public String crearHotel(@ModelAttribute Hotel hotel) {
        hotelRepository.save(hotel);
        return "redirect:/web/";
    }

    /**
     * Muestra el formulario de edición para un hotel existente.
     * <p>
     * Endpoint: <strong>GET /web/{id}/edit</strong>
     *
     * @param id    el ID del hotel a editar.
     * @param model el modelo para pasar datos a la vista.
     * @return la vista "edit" con los datos del hotel.
     * @throws IllegalArgumentException si el ID no es válido.
     */
    @GetMapping("{id}/edit")
    public String mostrarFormularioEdicion(@PathVariable String id, Model model) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de hotel no válido: " + id));
        model.addAttribute("hotel", hotel);
        return "edit";
    }

    /**
     * Procesa la actualización de un hotel existente.
     * <p>
     * Endpoint: <strong>PUT /web/{id}/edit</strong>
     *
     * @param id    el ID del hotel a actualizar.
     * @param hotel el objeto {@link Hotel} con los nuevos datos.
     * @return redirección a la página principal de hoteles.
     * @throws IllegalArgumentException si el ID no es válido.
     */
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
