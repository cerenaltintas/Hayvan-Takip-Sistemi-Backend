package tr.edu.gumushane.hayvantakip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.gumushane.hayvantakip.entity.Veteriner;
import tr.edu.gumushane.hayvantakip.exception.VeterinerNotFoundException;
import tr.edu.gumushane.hayvantakip.service.VeterinerService;

@RestController
@RequestMapping("/admin/api")
public class AdminVeterinerController {

    private VeterinerService veterinerService;

    @Autowired
    public AdminVeterinerController(VeterinerService veterinerService) {
        this.veterinerService = veterinerService;
    }

    @PostMapping("/veteriners")
    public Veteriner addVeteriner(@RequestBody Veteriner veteriner) {
        veteriner.setId(0); 
        return veterinerService.save(veteriner);
    }

    @PutMapping("/veteriners")
    public Veteriner updateVeteriner(@RequestBody Veteriner veteriner) {
        return veterinerService.save(veteriner);
    }

    @DeleteMapping("/veteriners/{vetId}")
    public String deleteVeteriner(@PathVariable int vetId) {
        if (veterinerService.findById(vetId) == null) {
            throw new VeterinerNotFoundException("Veteriner id not found - " + vetId);
        }
        veterinerService.deleteById(vetId);
        return "Deleted veteriner with id - " + vetId;
    }
}