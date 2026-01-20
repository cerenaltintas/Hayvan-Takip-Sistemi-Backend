package tr.edu.gumushane.hayvantakip.entity;

import java.util.Date;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
=======
import com.fasterxml.jackson.annotation.JsonIgnore; // YENİ IMPORT
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
<<<<<<< HEAD
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
=======
import jakarta.persistence.JoinColumn; // YENİ IMPORT
import jakarta.persistence.ManyToOne; // YENİ IMPORT
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
<<<<<<< HEAD
@Table(name = "mama")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
=======
@Table(name="mama")
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
public class Mama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "id")
    private int id;

    @Column(name = "marka")
    private String marka;

    @Column(name = "miktar_gram")
    private double miktarGram;

    @Temporal(TemporalType.DATE)
    @Column(name = "verilme_tarihi")
    private Date verilmeTarihi;

    @ManyToOne
    @JoinColumn(name = "hayvan_id") 
    @JsonIgnore
    private Animal animal;

    public Mama() {
    }

    public void removeFromAnimal() {
        if (this.animal != null) {
            this.animal.getMamalar().remove(this);
            this.animal = null;
        }
    }

=======
    @Column(name="id")
    private int id;

    @Column(name="marka")
    private String marka;

    @Column(name="miktar_gram")
    private double miktarGram;

    @Temporal(TemporalType.DATE)
    @Column(name="verilme_tarihi")
    private Date verilmeTarihi;

    // --- YENİ İLİŞKİ ALANI ---
    // Bir mama kaydı BİR hayvana aittir.
    @ManyToOne
    @JoinColumn(name="hayvan_id") // 'mama' tablosuna 'hayvan_id' kolonu ekler
    @JsonIgnore // API'de sonsuz döngüyü engellemek için ÇOK ÖNEMLİ
    private Animal animal;
    // --- BİTTİ ---

    // JPA için boş constructor
    public Mama() {
    }

    // Getter ve Setter metotları
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public double getMiktarGram() {
        return miktarGram;
    }

    public void setMiktarGram(double miktarGram) {
        this.miktarGram = miktarGram;
    }

    public Date getVerilmeTarihi() {
        return verilmeTarihi;
    }

    public void setVerilmeTarihi(Date verilmeTarihi) {
        this.verilmeTarihi = verilmeTarihi;
    }
<<<<<<< HEAD

=======
    
    // YENİ GETTER/SETTER
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}