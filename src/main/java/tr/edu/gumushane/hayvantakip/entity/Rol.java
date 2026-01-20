package tr.edu.gumushane.hayvantakip.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roller")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rol_adi", unique = true, nullable = false)
    private String rolAdi; 

    @Column(name = "aciklama")
    private String aciklama;

    public Rol() {
    }

    public Rol(String rolAdi) {
        this.rolAdi = rolAdi;
    }

    public Rol(String rolAdi, String aciklama) {
        this.rolAdi = rolAdi;
        this.aciklama = aciklama;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolAdi() {
        return rolAdi;
    }

    public void setRolAdi(String rolAdi) {
        this.rolAdi = rolAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}
