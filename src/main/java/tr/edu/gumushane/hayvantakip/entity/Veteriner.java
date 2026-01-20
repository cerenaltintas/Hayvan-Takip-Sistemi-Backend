package tr.edu.gumushane.hayvantakip.entity;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "veteriner")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
=======
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="veteriner")
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
public class Veteriner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "id")
    private int id;

    @Column(name = "ad_soyad")
    private String adSoyad;

    @Column(name = "klinik_adi")
    private String klinikAdi;

    @Column(name = "telefon")
    private String telefon;

    @OneToMany(mappedBy = "veteriner", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH }, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Animal> hayvanlar = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "veteriner_uzmanlik", joinColumns = @JoinColumn(name = "veteriner_id"), inverseJoinColumns = @JoinColumn(name = "uzmanlik_id"))
    private List<Uzmanlik> uzmanliklar = new ArrayList<>();

    public Veteriner() {
    }

    public void addUzmanlik(Uzmanlik uzmanlik) {
        this.uzmanliklar.add(uzmanlik);
        uzmanlik.getVeterinerler().add(this);
    }

    public void removeUzmanlik(Uzmanlik uzmanlik) {
        this.uzmanliklar.remove(uzmanlik);
        uzmanlik.getVeterinerler().remove(this);
    }

    public void addHayvan(Animal animal) {
        this.hayvanlar.add(animal);
        animal.setVeteriner(this);
    }

=======
    @Column(name="id")
    private int id;

    @Column(name="ad_soyad")
    private String adSoyad;

    @Column(name="klinik_adi")
    private String klinikAdi;
    
    @Column(name="telefon")
    private String telefon;

    // JPA için boş constructor
    public Veteriner() {
    }

    // Getter ve Setter metotları
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getKlinikAdi() {
        return klinikAdi;
    }

    public void setKlinikAdi(String klinikAdi) {
        this.klinikAdi = klinikAdi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
<<<<<<< HEAD

    public List<Animal> getHayvanlar() {
        return hayvanlar;
    }

    public void setHayvanlar(List<Animal> hayvanlar) {
        this.hayvanlar = hayvanlar;
    }

    public List<Uzmanlik> getUzmanliklar() {
        return uzmanliklar;
    }

    public void setUzmanliklar(List<Uzmanlik> uzmanliklar) {
        this.uzmanliklar = uzmanliklar;
    }
=======
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
}