package tr.edu.gumushane.hayvantakip.common;

import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

<<<<<<< HEAD
@Component("smsService")
public class SmsService implements NotificationService {

=======
@Component
public class SmsService implements NotificationService {

    // Rubric Item: @PostConstruct
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @PostConstruct
    public void init() {
        System.out.println(">>> SmsService oluşturuldu! @PostConstruct çalıştı.");
    }

<<<<<<< HEAD
=======
    // Rubric Item: @PreDestroy
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
    @PreDestroy
    public void cleanup() {
        System.out.println(">>> SmsService yok ediliyor! @PreDestroy çalıştı.");
    }

    @Override
    public String send(String message) {
        return "SMS gönderildi: " + message;
    }
}