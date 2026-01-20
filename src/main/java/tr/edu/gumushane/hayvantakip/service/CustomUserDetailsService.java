package tr.edu.gumushane.hayvantakip.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tr.edu.gumushane.hayvantakip.dao.UyeDAO;
import tr.edu.gumushane.hayvantakip.entity.Uye;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UyeDAO uyeDAO;

    @Autowired
    public CustomUserDetailsService(UyeDAO uyeDAO) {
        this.uyeDAO = uyeDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Uye uye = uyeDAO.findByKullaniciAdi(username);

        if (uye == null) {
            throw new UsernameNotFoundException("Kullanıcı bulunamadı: " + username);
        }

        List<GrantedAuthority> authorities = uye.getRoller().stream()
                .map(rol -> new SimpleGrantedAuthority(rol.getRolAdi()))
                .collect(Collectors.toList());

        return new User(
                uye.getKullaniciAdi(),
                uye.getSifre(), 
                uye.isAktif(), 
                true, 
                true, 
                true, 
                authorities);
    }
}
