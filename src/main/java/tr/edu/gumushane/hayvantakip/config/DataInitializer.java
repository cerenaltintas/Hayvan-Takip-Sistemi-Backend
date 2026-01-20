package tr.edu.gumushane.hayvantakip.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import tr.edu.gumushane.hayvantakip.entity.Rol;
import tr.edu.gumushane.hayvantakip.entity.Uye;
import tr.edu.gumushane.hayvantakip.entity.Uzmanlik;

@Component
public class DataInitializer implements CommandLineRunner {

    private EntityManager entityManager;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public DataInitializer(EntityManager entityManager, PasswordEncoder passwordEncoder) {
        this.entityManager = entityManager;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        if (countRoles() == 0) {
            initializeRoles();
        }

        if (countUsers() == 0) {
            initializeUsers();
        }

        if (countUzmanliklar() == 0) {
            initializeUzmanliklar();
        }

        // Admin kullanıcısı yoksa oluştur
        ensureAdminUserExists();

        // Düz metin şifreleri BCrypt formatına çevir
        fixPlainTextPasswords();
    }

    private void ensureAdminUserExists() {
        TypedQuery<Uye> query = entityManager.createQuery(
                "SELECT u FROM Uye u WHERE u.kullaniciAdi = :kullaniciAdi", Uye.class);
        query.setParameter("kullaniciAdi", "admin");

        if (query.getResultList().isEmpty()) {
            Rol adminRole = findRoleByName("ROLE_ADMIN");

            Uye admin = new Uye();
            admin.setKullaniciAdi("admin");
            admin.setSifre(passwordEncoder.encode("admin123"));
            admin.setAdSoyad("Sistem Yöneticisi");
            admin.setEmail("admin@hayvantakip.com");
            admin.setAktif(true);
            admin.addRol(adminRole);
            entityManager.persist(admin);
            System.out.println("✓ admin kullanıcısı oluşturuldu (şifre: admin123)");
        }
    }

    private void fixPlainTextPasswords() {
        TypedQuery<Uye> query = entityManager.createQuery("SELECT u FROM Uye u", Uye.class);
        Rol adminRole = findRoleByName("ROLE_ADMIN");

        for (Uye uye : query.getResultList()) {
            boolean updated = false;

            // BCrypt şifreleri $2a$ ile başlar, başlamayanları encode et
            if (uye.getSifre() != null && !uye.getSifre().startsWith("$2a$")) {
                String encodedPassword = passwordEncoder.encode(uye.getSifre());
                uye.setSifre(encodedPassword);
                updated = true;
                System.out.println(
                        "✓ " + uye.getKullaniciAdi() + " kullanıcısının şifresi BCrypt formatına güncellendi.");
            }

            // Rol atanmamış kullanıcılara ADMIN rolü ekle
            if (uye.getRoller() == null || uye.getRoller().isEmpty()) {
                uye.addRol(adminRole);
                updated = true;
                System.out.println(
                        "✓ " + uye.getKullaniciAdi() + " kullanıcısına ADMIN rolü eklendi.");
            }

            if (updated) {
                entityManager.merge(uye);
            }
        }
    }

    private long countRoles() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(r) FROM Rol r", Long.class);
        return query.getSingleResult();
    }

    private long countUsers() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(u) FROM Uye u", Long.class);
        return query.getSingleResult();
    }

    private long countUzmanliklar() {
        TypedQuery<Long> query = entityManager.createQuery("SELECT COUNT(u) FROM Uzmanlik u", Long.class);
        return query.getSingleResult();
    }

    private void initializeRoles() {

        Rol adminRole = new Rol("ROLE_ADMIN", "Sistem Yöneticisi - Tüm yetkilere sahip");
        Rol vetRole = new Rol("ROLE_VET", "Veteriner - Hayvan kayıtlarını yönetebilir");
        Rol userRole = new Rol("ROLE_USER", "Normal Kullanıcı - Sadece okuma yetkisi");

        entityManager.persist(adminRole);
        entityManager.persist(vetRole);
        entityManager.persist(userRole);

        System.out.println("✓ 3 adet rol oluşturuldu: ROLE_ADMIN, ROLE_VET, ROLE_USER");
    }

    private void initializeUsers() {

        Rol adminRole = findRoleByName("ROLE_ADMIN");
        Rol vetRole = findRoleByName("ROLE_VET");
        Rol userRole = findRoleByName("ROLE_USER");

        Uye admin = new Uye();
        admin.setKullaniciAdi("admin");
        admin.setSifre(passwordEncoder.encode("admin123"));
        admin.setAdSoyad("Sistem Yöneticisi");
        admin.setEmail("admin@hayvantakip.com");
        admin.setAktif(true);
        admin.addRol(adminRole);
        entityManager.persist(admin);

        Uye veteriner = new Uye();
        veteriner.setKullaniciAdi("veteriner");
        veteriner.setSifre(passwordEncoder.encode("vet123"));
        veteriner.setAdSoyad("Dr. Ahmet Veteriner");
        veteriner.setEmail("veteriner@hayvantakip.com");
        veteriner.setAktif(true);
        veteriner.addRol(vetRole);
        entityManager.persist(veteriner);

        Uye kullanici = new Uye();
        kullanici.setKullaniciAdi("kullanici");
        kullanici.setSifre(passwordEncoder.encode("user123"));
        kullanici.setAdSoyad("Normal Kullanıcı");
        kullanici.setEmail("kullanici@hayvantakip.com");
        kullanici.setAktif(true);
        kullanici.addRol(userRole);
        entityManager.persist(kullanici);

        System.out.println("✓ 3 adet kullanıcı oluşturuldu: admin, veteriner, kullanici");
    }

    private void initializeUzmanliklar() {

        Uzmanlik dahiliye = new Uzmanlik("Dahiliye", "İç hastalıkları uzmanlığı");
        Uzmanlik cerrahi = new Uzmanlik("Cerrahi", "Ameliyat ve cerrahi müdahaleler");
        Uzmanlik dermatoloji = new Uzmanlik("Dermatoloji", "Deri hastalıkları uzmanlığı");
        Uzmanlik kardiyoloji = new Uzmanlik("Kardiyoloji", "Kalp ve dolaşım sistemi uzmanlığı");

        entityManager.persist(dahiliye);
        entityManager.persist(cerrahi);
        entityManager.persist(dermatoloji);
        entityManager.persist(kardiyoloji);

        System.out.println("✓ 4 adet uzmanlık alanı oluşturuldu");
    }

    private Rol findRoleByName(String rolAdi) {
        TypedQuery<Rol> query = entityManager.createQuery(
                "SELECT r FROM Rol r WHERE r.rolAdi = :rolAdi", Rol.class);
        query.setParameter("rolAdi", rolAdi);
        return query.getSingleResult();
    }
}
