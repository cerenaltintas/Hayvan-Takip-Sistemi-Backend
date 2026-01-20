package tr.edu.gumushane.hayvantakip.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tr.edu.gumushane.hayvantakip.entity.Rol;
import tr.edu.gumushane.hayvantakip.service.RolService;

@RestController
@RequestMapping("/admin/api")
public class AdminRolController {

    private RolService rolService;

    @Autowired
    public AdminRolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/roller")
    public List<Rol> findAll() {
        return rolService.findAll();
    }

    @PostMapping("/roller")
    public Rol addRol(@RequestBody Rol rol) {
        rol.setId(0); 
        return rolService.save(rol);
    }

    @PutMapping("/roller")
    public Rol updateRol(@RequestBody Rol rol) {
        return rolService.save(rol);
    }

    @DeleteMapping("/roller/{rolId}")
    public String deleteRol(@PathVariable int rolId) {
        Rol rol = rolService.findById(rolId);
        if (rol == null) {
            throw new RuntimeException("Rol id not found - " + rolId);
        }
        rolService.deleteById(rolId);
        return "Deleted rol with id - " + rolId;
    }

    @PatchMapping("/roller/{rolId}")
    public Rol patchRol(@PathVariable int rolId, @RequestBody Map<String, Object> updates) {
        Rol rol = rolService.findById(rolId);
        if (rol == null) {
            throw new RuntimeException("Rol id not found - " + rolId);
        }

        if (updates.containsKey("aciklama")) {
            rol.setAciklama((String) updates.get("aciklama"));
        }

        return rolService.save(rol);
    }
}
