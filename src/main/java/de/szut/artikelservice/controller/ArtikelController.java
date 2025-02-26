package de.szut.artikelservice.controller;

import de.szut.artikelservice.model.Artikel;
import de.szut.artikelservice.service.ArtikelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/myappdata/articles")

public class ArtikelController {

    private ArtikelService artikelServ;

    public ArtikelController() {
        artikelServ = new ArtikelService();
    }

    @GetMapping
    public ResponseEntity<List<Artikel>> getArtikel() {
        List<Artikel>  artikelList = artikelServ.readAll();
        return new ResponseEntity<>(artikelList, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Artikel> getArtikel(@PathVariable Long id) {
        Artikel artikel = artikelServ.read(id);
        return new ResponseEntity<>(artikel, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Artikel> addArtikel(@RequestBody Artikel request) {
        Artikel artikel = artikelServ.add(request);
        return new ResponseEntity<>(artikel, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Artikel> updateArtikel(@RequestBody Artikel request) {
        Artikel artikel = artikelServ.update(request);
        return new ResponseEntity<>(artikel, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Artikel> deleteArtikel(@RequestBody Artikel request) {
        artikelServ.delete(request.getId());
        return new ResponseEntity<>(request, HttpStatus.OK);
    }
}


