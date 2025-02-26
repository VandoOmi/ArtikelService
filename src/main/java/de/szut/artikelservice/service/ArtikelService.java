package de.szut.artikelservice.service;

import de.szut.artikelservice.model.Artikel;
import de.szut.artikelservice.repository.ArtikelDao;

import java.util.List;

public class ArtikelService {
    private ArtikelDao artikelDao;

    public ArtikelService() {
        artikelDao = new ArtikelDao();
    }

    public Artikel read(long id) {
        return artikelDao.findById(id);
    }

    public List<Artikel> readAll() {
        return artikelDao.findAll();
    }

    public Artikel add(Artikel artikel) {
        artikelDao.insert(artikel);
        return artikelDao.findById(artikel.getId());
    }

    public Artikel update(Artikel artikel) {
        artikelDao.update(artikel);
        return artikelDao.findById(artikel.getId());
    }

    public void delete(long id) {
        artikelDao.delete(id);
    }
}
