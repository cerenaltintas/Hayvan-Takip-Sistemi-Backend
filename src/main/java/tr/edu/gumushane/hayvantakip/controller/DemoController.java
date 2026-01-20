package tr.edu.gumushane.hayvantakip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.edu.gumushane.hayvantakip.common.NotificationService;
import org.springframework.web.bind.annotation.RequestMapping;

<<<<<<< HEAD
@RestController
@RequestMapping("/demo") 
public class DemoController {

    private NotificationService varsayilanServis; 
    private NotificationService smsServisi;
    private NotificationService whatsappServisi; 

    @Autowired
    public DemoController(
            NotificationService notificationService, 

            @Qualifier("smsService") NotificationService smsServisi, 

=======

@RestController
@RequestMapping("/demo") // Demo endpointleri /demo altında olsun
public class DemoController {

    private NotificationService varsayilanServis; // @Primary olan (EmailService)
    private NotificationService smsServisi;
    private NotificationService whatsappServisi; // @Lazy olan

    @Autowired
    public DemoController(
            NotificationService notificationService, // @Primary olanı (EmailService) otomatik alır

            // @Qualifier: "smsService" adındaki Bean'i özel olarak iste
            @Qualifier("smsService") NotificationService smsServisi, 

            // @Qualifier: "whatsappService" adındaki Bean'i özel olarak iste
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
            @Qualifier("whatsappService") NotificationService whatsappServisi) 
    {
        this.varsayilanServis = notificationService;
        this.smsServisi = smsServisi;
        this.whatsappServisi = whatsappServisi;
    }

<<<<<<< HEAD
    @GetMapping("/test-primary")
    public String testPrimary() {
        
        return varsayilanServis.send("Varsayılan servis testi"); 
    }

    @GetMapping("/test-qualifier")
    public String testQualifier() {
        
        return smsServisi.send("Qualifier SMS testi"); 
    }

    @GetMapping("/test-lazy")
    public String testLazy() {

=======
    // @Primary test
    @GetMapping("/test-primary")
    public String testPrimary() {
        // "EMAIL gönderildi: ..." çıktısı vermeli
        return varsayilanServis.send("Varsayılan servis testi"); 
    }

    // @Qualifier test
    @GetMapping("/test-qualifier")
    public String testQualifier() {
        // "SMS gönderildi: ..." çıktısı vermeli
        return smsServisi.send("Qualifier SMS testi"); 
    }

    // @Lazy test
    @GetMapping("/test-lazy")
    public String testLazy() {
        // Bu istek atılana kadar "whatsappService" (ProjectConfig'teki) oluşturulmaz.
        // "SMS gönderildi: ..." çıktısı vermeli (çünkü o da SmsService kullanıyor)
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        return whatsappServisi.send("Lazy bean testi"); 
    }
}