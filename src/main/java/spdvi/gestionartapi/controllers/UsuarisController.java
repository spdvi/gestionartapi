package spdvi.gestionartapi.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spdvi.gestionartapi.dataaccess.DataAccess;
import spdvi.gestionartapi.models.Espai;
import spdvi.gestionartapi.models.Usuari;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/")
public class UsuarisController {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    @GetMapping("/usuari/{email}")
    @ResponseStatus(HttpStatus.OK)
    public Usuari getEspai(@PathVariable("email") String email) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        return dataAccess.getUser(email);
    }

//    @GetMapping(
//            value="/usuari/password/{email}",
//            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
//    )
//    public @ResponseBody byte[] getPassword(@PathVariable("email") String email) {
//        DataAccess dataAccess = new DataAccess(url, user, password);
//        return dataAccess.findUserPassword(email);
//    }

    @GetMapping("/usuari/password/{email}")
    @ResponseStatus(HttpStatus.OK)
    public String getPassword(@PathVariable("email") String email) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        return dataAccess.findUserPassword(email);
    }

    @GetMapping("/usuari/session/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getSession(@PathVariable("id") int id) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        return dataAccess.insertSession(id).toString();
    }

    @PostMapping("/usuari")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ResponseEntity<Usuari> createUsuari(@RequestBody Usuari usuari) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        Usuari newUsuari = null;
        int success = dataAccess.insertUser(usuari);
        if (success == 1) {
            newUsuari = dataAccess.getUser(usuari.getEmail());
            return new ResponseEntity<>(newUsuari, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(newUsuari, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/usuari/session/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSession(@PathVariable("uuid") String uuid) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        dataAccess.deleteSession(UUID.fromString(uuid));
    }

    @GetMapping("/usuari/profilePicture/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public byte[] getProfilePicture(@PathVariable("userId") int userId) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        return dataAccess.getUserProfilePicture(userId);
    }

    @PostMapping(path="/usuari/profilePicture/{userId}",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity updateProfilePicture(@RequestParam("profileImage") MultipartFile profileImage,
                                           @PathVariable("userId") int userId) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        try {
            dataAccess.updateUserProfilePicture(userId, profileImage.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok().build();
    }
}
