package tr.edu.gumushane.hayvantakip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import tr.edu.gumushane.hayvantakip.common.NotificationService;
<<<<<<< HEAD
import tr.edu.gumushane.hayvantakip.common.SmsService; 

@Configuration 
public class ProjectConfig {

    @Bean("whatsappService") 
    @Lazy 
    public NotificationService lazyWhatsappService() {
        System.out.println(">>> LAZY BEAN: WhatsappService oluşturuluyor...");
        
=======
import tr.edu.gumushane.hayvantakip.common.SmsService; // Sadece örnek için

@Configuration // Rubric Item
public class ProjectConfig {

    // @Bean: @Component demediğimiz bir sınıfı veya 3. parti bir kütüphaneyi
    // Spring Bean'i yapmak için kullanılır.
    
    @Bean("whatsappService") // Rubric Item: Bean'e özel bir isim verelim
    @Lazy // Rubric Item: Bu bean, sadece ihtiyaç duyulduğunda oluşturulsun
    public NotificationService lazyWhatsappService() {
        System.out.println(">>> LAZY BEAN: WhatsappService oluşturuluyor...");
        // Normalde burada 'new WhatsappService()' olurdu, SmsService'i örnek için kullanalım
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        return new SmsService(); 
    }
}