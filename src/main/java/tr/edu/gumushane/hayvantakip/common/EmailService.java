package tr.edu.gumushane.hayvantakip.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
<<<<<<< HEAD
@Primary 
=======
@Primary // Rubric Item: Birden fazla NotificationService varsa, varsayılan bu olsun.
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
public class EmailService implements NotificationService {
    @Override
    public String send(String message) {
        return "EMAIL gönderildi: " + message;
    }
}