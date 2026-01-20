package tr.edu.gumushane.hayvantakip.entity;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
=======
import java.util.Date;
import java.util.List; // YENİ IMPORT

import jakarta.persistence.CascadeType; // YENİ IMPORT
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn; // YENİ IMPORT
import jakarta.persistence.ManyToOne; // YENİ IMPORT
import jakarta.persistence.OneToMany; // YENİ IMPORT
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
<<<<<<< HEAD
@Table(name = "hayvan")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
=======
@Table(name="hayvan")
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "id")
    private int id;

    @Column(name = "ad")
    private String ad;

    @Column(name = "tur")
    private String tur;

    @Column(name = "irk")
    private String irk;

    @Column(name = "kilo")
    private double kilo;

    @Column(name = "dogum_tarihi")
    @Temporal(TemporalType.DATE)
    private Date dogumTarihi;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veteriner_id")
    private Veteriner veteriner;

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Mama> mamalar = new ArrayList<>();

    @OneToMany(mappedBy = "animal", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH })
    private List<Asi> asilar = new ArrayList<>();

    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Ilac> ilaclar = new ArrayList<>();

    public Animal() {
    }

=======
    @Column(name="id")
    private int id;

    @Column(name="ad")
    private String ad;

    @Column(name="tur")
    private String tur; // "Kedi", "Köpek"

    @Column(name="irk")
    private String irk;

    @Column(name="kilo")
    private double kilo;

    @Column(name="dogum_tarihi")
    @Temporal(TemporalType.DATE)
    private Date dogumTarihi;

    // --- YENİ İLİŞKİ ALANLARI ---

    // Bir hayvanın BİR veterineri olur.
    @ManyToOne
    @JoinColumn(name="veteriner_id") // 'hayvan' tablosuna 'veteriner_id' kolonu ekler
    private Veteriner veteriner;
    
    // Bir hayvanın BİRDEN ÇOK mama kaydı olur.
    // "mappedBy = animal" -> Mama sınıfındaki 'animal' alanına bakarak ilişkiyi kur
    // CascadeType.ALL -> Hayvan silinirse, ona ait mama kayıtları da silinsin.
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Mama> mamalar;

    // Bir hayvanın BİRDEN ÇOK aşı kaydı olur.
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Asi> asilar;

    // Bir hayvanın BİRDEN ÇOK ilaç kaydı olur.
    @OneToMany(mappedBy = "animal", cascade = CascadeType.ALL)
    private List<Ilac> ilaclar;

    // --- BİTTİ ---

    // JPA için varsayılan (boş) constructor şarttır
    public Animal() {
    }

    // Kullanışlı constructor
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    public Animal(String ad, String tur, String irk, double kilo, Date dogumTarihi) {
        this.ad = ad;
        this.tur = tur;
        this.irk = irk;
        this.kilo = kilo;
        this.dogumTarihi = dogumTarihi;
    }

<<<<<<< HEAD
    public void addMama(Mama mama) {
        this.mamalar.add(mama);
        mama.setAnimal(this);
    }

    public void addAsi(Asi asi) {
        this.asilar.add(asi);
        asi.setAnimal(this);
    }

    public void addIlac(Ilac ilac) {
        this.ilaclar.add(ilac);
        ilac.setAnimal(this);
    }

=======
    // --- Getter ve Setter Metotları ---
    
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getIrk() {
        return irk;
    }

    public void setIrk(String irk) {
        this.irk = irk;
    }

    public double getKilo() {
        return kilo;
    }

    public void setKilo(double kilo) {
        this.kilo = kilo;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

<<<<<<< HEAD
=======
    // --- YENİ GETTER/SETTER'LAR ---

>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    public Veteriner getVeteriner() {
        return veteriner;
    }

    public void setVeteriner(Veteriner veteriner) {
        this.veteriner = veteriner;
    }

    public List<Mama> getMamalar() {
        return mamalar;
    }

    public void setMamalar(List<Mama> mamalar) {
        this.mamalar = mamalar;
    }

    public List<Asi> getAsilar() {
        return asilar;
    }

    public void setAsilar(List<Asi> asilar) {
        this.asilar = asilar;
    }

    public List<Ilac> getIlaclar() {
        return ilaclar;
    }

    public void setIlaclar(List<Ilac> ilaclar) {
        this.ilaclar = ilaclar;
    }
}