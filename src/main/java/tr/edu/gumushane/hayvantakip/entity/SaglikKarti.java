package tr.edu.gumushane.hayvantakip.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "saglik_karti")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class SaglikKarti {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "kan_grubu")
    private String kanGrubu;

    @Column(name = "alerjiler")
    private String alerjiler;

    @Column(name = "kronik_hastaliklar")
    private String kronikHastaliklar;

    @Column(name = "ozel_notlar")
    private String ozelNotlar;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hayvan_id", unique = true)
    private Animal animal;

    public SaglikKarti() {
    }

    public SaglikKarti(String kanGrubu, String alerjiler, String kronikHastaliklar, String ozelNotlar) {
        this.kanGrubu = kanGrubu;
        this.alerjiler = alerjiler;
        this.kronikHastaliklar = kronikHastaliklar;
        this.ozelNotlar = ozelNotlar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKanGrubu() {
        return kanGrubu;
    }

    public void setKanGrubu(String kanGrubu) {
        this.kanGrubu = kanGrubu;
    }

    public String getAlerjiler() {
        return alerjiler;
    }

    public void setAlerjiler(String alerjiler) {
        this.alerjiler = alerjiler;
    }

    public String getKronikHastaliklar() {
        return kronikHastaliklar;
    }

    public void setKronikHastaliklar(String kronikHastaliklar) {
        this.kronikHastaliklar = kronikHastaliklar;
    }

    public String getOzelNotlar() {
        return ozelNotlar;
    }

    public void setOzelNotlar(String ozelNotlar) {
        this.ozelNotlar = ozelNotlar;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
