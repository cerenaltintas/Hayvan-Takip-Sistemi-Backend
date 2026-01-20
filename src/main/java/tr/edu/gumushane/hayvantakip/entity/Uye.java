package tr.edu.gumushane.hayvantakip.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "uyeler")
public class Uye {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "kullanici_adi", unique = true, nullable = false)
    private String kullaniciAdi;

    @Column(name = "sifre", nullable = false)
    private String sifre; 

    @Column(name = "aktif")
    private boolean aktif = true;

    @Column(name = "ad_soyad")
    private String adSoyad;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "uye_roller", joinColumns = @JoinColumn(name = "uye_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private List<Rol> roller = new ArrayList<>();

    public Uye() {
    }

    public Uye(String kullaniciAdi, String sifre, boolean aktif) {
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;
        this.aktif = aktif;
    }

    public void addRol(Rol rol) {
        this.roller.add(rol);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public boolean isAktif() {
        return aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rol> getRoller() {
        return roller;
    }

    public void setRoller(List<Rol> roller) {
        this.roller = roller;
    }
}
