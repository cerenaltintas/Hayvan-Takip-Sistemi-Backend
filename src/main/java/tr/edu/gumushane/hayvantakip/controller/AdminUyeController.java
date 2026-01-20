package tr.edu.gumushane.hayvantakip.controller;

import java.util.ArrayList;
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
import tr.edu.gumushane.hayvantakip.entity.Uye;
import tr.edu.gumushane.hayvantakip.service.RolService;
import tr.edu.gumushane.hayvantakip.service.UyeService;

@RestController
@RequestMapping("/admin/api")
public class AdminUyeController {

    private UyeService uyeService;
    private RolService rolService;

    @Autowired
    public AdminUyeController(UyeService uyeService, RolService rolService) {
        this.uyeService = uyeService;
        this.rolService = rolService;
    }

    @GetMapping("/uyeler")
    public List<Uye> findAll() {
        return uyeService.findAll();
    }

    @PostMapping("/uyeler")
    public Uye addUye(@RequestBody Uye uye) {
        uye.setId(0);
        return uyeService.save(uye);
    }

    @PutMapping("/uyeler")
    public Uye updateUye(@RequestBody Uye uye) {
        return uyeService.save(uye);
    }

    @DeleteMapping("/uyeler/{uyeId}")
    public String deleteUye(@PathVariable int uyeId) {
        Uye uye = uyeService.findById(uyeId);
        if (uye == null) {
            throw new RuntimeException("Uye id not found - " + uyeId);
        }
        uyeService.deleteById(uyeId);
        return "Deleted uye with id - " + uyeId;
    }

    @SuppressWarnings("unchecked")
    @PatchMapping("/uyeler/{uyeId}")
    public Uye patchUye(@PathVariable int uyeId, @RequestBody Map<String, Object> updates) {
        Uye uye = uyeService.findById(uyeId);
        if (uye == null) {
            throw new RuntimeException("Uye id not found - " + uyeId);
        }

        if (updates.containsKey("aktif")) {
            uye.setAktif((Boolean) updates.get("aktif"));
        }
        if (updates.containsKey("adSoyad")) {
            uye.setAdSoyad((String) updates.get("adSoyad"));
        }
        if (updates.containsKey("email")) {
            uye.setEmail((String) updates.get("email"));
        }
        if (updates.containsKey("roller")) {
            List<Map<String, Object>> rollerData = (List<Map<String, Object>>) updates.get("roller");
            List<Rol> yeniRoller = new ArrayList<>();
            for (Map<String, Object> rolData : rollerData) {
                int rolId = (Integer) rolData.get("id");
                Rol rol = rolService.findById(rolId);
                if (rol != null) {
                    yeniRoller.add(rol);
                }
            }
            uye.setRoller(yeniRoller);
        }

        return uyeService.save(uye);
    }

    @PostMapping("/uyeler/{uyeId}/roller/{rolId}")
    public Uye addRoleToUye(@PathVariable int uyeId, @PathVariable int rolId) {
        return uyeService.addRoleToUye(uyeId, rolId);
    }

    @DeleteMapping("/uyeler/{uyeId}/roller/{rolId}")
    public Uye removeRoleFromUye(@PathVariable int uyeId, @PathVariable int rolId) {
        return uyeService.removeRoleFromUye(uyeId, rolId);
    }
}
