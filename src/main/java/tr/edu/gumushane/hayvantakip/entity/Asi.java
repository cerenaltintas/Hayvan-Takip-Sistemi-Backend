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
@Table(name = "asi")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
=======
@Table(name="asi")
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
public class Asi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "id")
    private int id;

    @Column(name = "asi_adi")
    private String asiAdi;

    @Temporal(TemporalType.DATE)
    @Column(name = "yapilma_tarihi")
    private Date yapilmaTarihi;

    @ManyToOne
    @JoinColumn(name = "hayvan_id")
    @JsonIgnore
    private Animal animal;
=======
    @Column(name="id")
    private int id;

    @Column(name="asi_adi")
    private String asiAdi;

    @Temporal(TemporalType.DATE)
    @Column(name="yapilma_tarihi")
    private Date yapilmaTarihi;

    // --- YENİ İLİŞKİ ALANI ---
    @ManyToOne
    @JoinColumn(name="hayvan_id")
    @JsonIgnore 
    private Animal animal;
    // --- BİTTİ ---
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a

    public Asi() {
    }

<<<<<<< HEAD
    public void removeFromAnimal() {
        if (this.animal != null) {
            this.animal.getAsilar().remove(this);
            this.animal = null;
        }
    }

=======
    // Getter ve Setter metotları
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsiAdi() {
        return asiAdi;
    }

    public void setAsiAdi(String asiAdi) {
        this.asiAdi = asiAdi;
    }

    public Date getYapilmaTarihi() {
        return yapilmaTarihi;
    }

    public void setYapilmaTarihi(Date yapilmaTarihi) {
        this.yapilmaTarihi = yapilmaTarihi;
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