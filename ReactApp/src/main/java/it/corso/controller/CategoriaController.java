package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.corso.dto.CategoriaDto;
import it.corso.service.CategoriaService;

/**
 * Controller REST per la gestione delle categorie dei corsi.
 * Fornisce endpoint per operazioni CRUD relative alle categorie.
 */
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;
    
    /**
     * Restituisce i dettagli di una categoria specifica in base all'ID fornito.
     * 
     * @param id l'ID della categoria da recuperare
     * @return {@link ResponseEntity} contenente {@link CategoriaDto} se la categoria è trovata, o un errore di bad request
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<CategoriaDto> getCategoriaById(@PathVariable int id) {
        try {
            if(id > 0) {
                return ResponseEntity.ok(categoriaService.getCategoriaById(id));
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Restituisce una lista di tutte le categorie disponibili.
     * 
     * @return {@link ResponseEntity} contenente una lista di {@link CategoriaDto}, o un errore di bad request
     */
    @GetMapping("/get/all")
    public ResponseEntity<List<CategoriaDto>> getAllCategorie() {
        try {
            List<CategoriaDto> categorieDto = categoriaService.getAllCategorie();
            return ResponseEntity.ok(categorieDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Elimina una categoria dal sistema in base all'ID fornito.
     * 
     * @param id l'ID della categoria da eliminare
     * @return {@link ResponseEntity} che indica il successo o il fallimento dell'eliminazione
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable int id){
        try {
            categoriaService.deleteCategoriaById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
