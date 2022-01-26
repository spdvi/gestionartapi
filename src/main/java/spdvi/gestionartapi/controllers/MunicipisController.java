package spdvi.gestionartapi.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import spdvi.gestionartapi.dataaccess.DataAccess;
import spdvi.gestionartapi.models.Municipi;

@RestController
@RequestMapping("/")
public class MunicipisController {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String user;
    @Value("${spring.datasource.password}")
    private String password;

    @GetMapping("/municipis")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Municipi> getMunicipis() {
        DataAccess dataAccess = new DataAccess(url, user, password);
        return dataAccess.getMunicipis();
    }
}
