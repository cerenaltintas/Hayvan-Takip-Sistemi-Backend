package tr.edu.gumushane.hayvantakip.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.gumushane.hayvantakip.entity.Veteriner;
import tr.edu.gumushane.hayvantakip.exception.VeterinerNotFoundException;
import tr.edu.gumushane.hayvantakip.service.VeterinerService;

@RestController
@RequestMapping("/public/api")
public class PublicVeterinerController {

    private VeterinerService veterinerService;

    @Autowired
    public PublicVeterinerController(VeterinerService veterinerService) {
        this.veterinerService = veterinerService;
    }

    @GetMapping("/veteriners")
    public List<Veteriner> findAll() {
        return veterinerService.findAll();
    }

    @GetMapping("/veteriners/{vetId}")
    public Veteriner findById(@PathVariable int vetId) {
        Veteriner veteriner = veterinerService.findById(vetId);

        if (veteriner == null) {
            throw new VeterinerNotFoundException("Veteriner id not found - " + vetId);
        }

        return veteriner;
    }
}