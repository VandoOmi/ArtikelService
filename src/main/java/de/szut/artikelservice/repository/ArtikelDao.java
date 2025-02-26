package de.szut.artikelservice.repository;

import de.szut.artikelservice.model.Artikel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository

public class ArtikelDao {
    private Map<Long, Artikel> artikelListe;

    public ArtikelDao() {
        initHashMap();
    }

    private void initHashMap() {
        artikelListe = new HashMap<>();
        artikelListe.put(1L,new Artikel(1L,"Dummy","dummy",1,1));
    }

    public Artikel findById(long id) {
        return artikelListe.get(id);
    }

    public List<Artikel> findAll() {
        return new ArrayList<>(artikelListe.values());
    }

    public void insert(Artikel artikel) {
        if (!artikelListe.containsKey(artikel.getId())) {
            artikelListe.put(artikel.getId(), artikel);
        }
    }

    public void update(Artikel artikel) {
        artikelListe.replace(artikel.getId(), artikel);
    }

    public void delete(long id) {
        artikelListe.remove(id);
    }
}
