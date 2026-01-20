package tr.edu.gumushane.hayvantakip.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth

                .requestMatchers("/actuator/**").permitAll()

                .requestMatchers(HttpMethod.GET, "/public/api/**").permitAll()

                .requestMatchers(HttpMethod.GET, "/admin/api/**").hasAnyRole("ADMIN", "VET", "USER")

                .requestMatchers(HttpMethod.POST, "/admin/api/**").hasAnyRole("ADMIN", "VET")

                .requestMatchers(HttpMethod.PUT, "/admin/api/**").hasAnyRole("ADMIN", "VET")

                .requestMatchers(HttpMethod.PATCH, "/admin/api/**").hasAnyRole("ADMIN", "VET")

                .requestMatchers(HttpMethod.DELETE, "/admin/api/**").hasRole("ADMIN")

                .anyRequest().authenticated());

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));

=======
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Rubric Item: Bu bir yapılandırma sınıfı
@EnableWebSecurity
public class SecurityConfig {

    @Bean // Rubric Item: Bu bir Spring Bean'i
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth ->
            auth
                // Actuator ve H2 Konsol için GÜVENLİĞİ KAPAT (Herkes erişebilsin)
                .requestMatchers("/actuator/**", "/h2-console/**").permitAll()
                
                // Geri kalan TÜM İSTEKLER kimlik doğrulaması (Basic Auth) istesin
                .anyRequest().authenticated()
        );

        // Basic Auth (user/password) oturum açmayı etkinleştir
        http.httpBasic(Customizer.withDefaults());

        // CSRF'yi kapat (Postman ve H2-Console için gereklidir)
        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()));
>>>>>>> fe0aad881e404be8b95831ebfbe886d0b70fa21a
        return http.build();
    }
}