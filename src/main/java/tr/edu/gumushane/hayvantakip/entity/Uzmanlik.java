package tr.edu.gumushane.hayvantakip.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "uzmanlik")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Uzmanlik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "alan_adi")
    private String alanAdi;

    @Column(name = "aciklama")
    private String aciklama;

    @ManyToMany(mappedBy = "uzmanliklar")
    @JsonIgnore 
    private List<Veteriner> veterinerler = new ArrayList<>();

    public Uzmanlik() {
    }

    public Uzmanlik(String alanAdi, String aciklama) {
        this.alanAdi = alanAdi;
        this.aciklama = aciklama;
    }

    public void removeFromVeteriner(Veteriner veteriner) {
        if (veteriner != null) {
            this.veterinerler.remove(veteriner);
            veteriner.getUzmanliklar().remove(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlanAdi() {
        return alanAdi;
    }

    public void setAlanAdi(String alanAdi) {
        this.alanAdi = alanAdi;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public List<Veteriner> getVeterinerler() {
        return veterinerler;
    }

    public void setVeterinerler(List<Veteriner> veterinerler) {
        this.veterinerler = veterinerler;
    }
}
