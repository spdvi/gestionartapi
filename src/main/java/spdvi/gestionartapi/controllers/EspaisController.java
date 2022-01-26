package spdvi.gestionartapi.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import spdvi.gestionartapi.dataaccess.DataAccess;
import spdvi.gestionartapi.models.Comentari;
import spdvi.gestionartapi.models.Espai;
import spdvi.gestionartapi.models.Imatge;

@RestController
@RequestMapping("/")
public class EspaisController {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    @GetMapping("/espais")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Espai> getEspais() {
        DataAccess dataAccess = new DataAccess(url, user, password);
        return dataAccess.getEspais("");
    }

    @GetMapping("/espais/municipi/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Espai> getEspaisByMunicipi(@PathVariable("id") int id) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        return dataAccess.getEspaisByMunicipi(id);
    }

    @GetMapping("/espais/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Espai getEspai(@PathVariable("id") String id) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        return dataAccess.getEspai(id);
    }

    @GetMapping("/espais/imatges/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Iterable<Imatge> getEspaiImatges(@PathVariable("id") String id) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        return dataAccess.getImatgesEspai(id);
    }

    @GetMapping("/espais/modalitats/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Iterable<String> getModalitatsEspai(@PathVariable("id") String id) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        return dataAccess.getModalitatsEspai(id);
    }

    @GetMapping("/espais/serveis/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Iterable<String> getServeisEspai(@PathVariable("id") String id) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        return dataAccess.getServeisEspai(id);
    }

    @GetMapping("/espais/comentaris/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Iterable<Comentari> getComentarisEspai(@PathVariable("id") String id) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        return dataAccess.getComentarisEspai(id);
    }

    @GetMapping("/espais/valoracio/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody float getValoracioEspai(@PathVariable("id") String id) {
        DataAccess dataAccess = new DataAccess(url, user, password);
        return dataAccess.getValoracioEspaiAvg(id);
    }

    @PostMapping(
            path="/espais/comentari",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
//    public void postComentari(@RequestBody String text, @RequestBody String registre, @RequestBody int userId, @RequestBody int valoracio) {
    public ResponseEntity<String> postComentari(@RequestParam MultiValueMap<String,String> paramMap) {
        String text = paramMap.getFirst("text");
        String registre = paramMap.getFirst("registre");
        int userId = Integer.parseInt(paramMap.getFirst("userId"));
        int valoracio = Integer.parseInt(paramMap.getFirst("valoracio"));
        DataAccess dataAccess = new DataAccess(url, user, password);
        dataAccess.insertComentariEspai(text, registre, userId, valoracio);
        return new ResponseEntity<String>("Thank you for submitting feedback", HttpStatus.CREATED);
    }
}
