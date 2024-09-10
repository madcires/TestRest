package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.CategoriaDao;
import it.corso.dto.CategoriaDto;
import it.corso.model.Categoria;

/**
 * Implementazione del servizio per la gestione delle categorie.
 * Fornisce metodi per recuperare, ottenere tutte le categorie ed eliminare una categoria.
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;
    
    private ModelMapper mapper = new ModelMapper();
    
    /**
     * Restituisce i dettagli di una categoria specifica in base all'ID fornito.
     * 
     * @param id l'ID della categoria da recuperare
     * @return un oggetto {@link CategoriaDto} contenente i dettagli della categoria, o null se non trovato
     */
    @Override
    public CategoriaDto getCategoriaById(int id) {
        try {
            Optional<Categoria> categoriaOptional = categoriaDao.findById(id);
            if(categoriaOptional.isPresent()) {
                Categoria categoria = categoriaOptional.get();
                String nomeCategoria = categoria.getNomeCategoria().toString();
                CategoriaDto categoriaDto = mapper.map(categoria, CategoriaDto.class);
                categoriaDto.setNomeCategoria(nomeCategoria);
                return categoriaDto;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Restituisce una lista di tutte le categorie disponibili nel sistema.
     * 
     * @return una lista di oggetti {@link CategoriaDto} contenente i dettagli di tutte le categorie, o null in caso di errore
     */
    @Override
    public List<CategoriaDto> getAllCategorie() {
        try {
            List<Categoria> categorie = (List<Categoria>) categoriaDao.findAll();
            List<CategoriaDto> categorieDto = new ArrayList<>();
            for(int i = 0; i < categorie.size(); i++) {
                Categoria categoria = categoriaDao.findById(categorie.get(i).getId()).get();
                String nomeCategoria = categoria.getNomeCategoria().toString();
                categorieDto.add(mapper.map(categorie.get(i), CategoriaDto.class));
                categorieDto.get(i).setNomeCategoria(nomeCategoria);
            }
            return categorieDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Elimina una categoria dal sistema in base all'ID fornito.
     * 
     * @param id l'ID della categoria da eliminare
     */
    @Override
    public void deleteCategoriaById(int id) {
        try {
            Optional<Categoria> categoriaOptional = categoriaDao.findById(id);
            if(categoriaOptional.isPresent()) {
                categoriaDao.delete(categoriaOptional.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
