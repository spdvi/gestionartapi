package spdvi.gestionartapi.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spdvi.gestionartapi.dataaccess.DataAccess;
import spdvi.gestionartapi.models.DAOUser;
import spdvi.gestionartapi.models.Usuari;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    @Autowired
    private PasswordEncoder bcryptEncoder;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if ("javainuse".equals(username)) {
//            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//                    new ArrayList<>());
//        } else {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        DataAccess dataAccess = new DataAccess(url, user, password);
        DAOUser user = dataAccess.getDAOUser(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }


    public Usuari save(Usuari usuari) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        usuari.setPassword(bcryptEncoder.encode(usuari.getPassword()));
        Usuari newUsuari = null;
        int success = dataAccess.insertUser(usuari);
        if (success == 1) {
            newUsuari = dataAccess.getUser(usuari.getEmail());
        }
        return newUsuari;
    }
}
