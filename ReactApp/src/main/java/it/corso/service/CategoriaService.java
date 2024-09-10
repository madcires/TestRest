package it.corso.service;

import java.util.List;

import it.corso.dto.CategoriaDto;

/**
 * Interfaccia per il servizio di gestione delle categorie.
 * Definisce i metodi per recuperare, ottenere tutte le categorie ed eliminare una categoria.
 */
public interface CategoriaService {

    /**
     * Restituisce i dettagli di una categoria specifica in base all'ID fornito.
     * 
     * @param id l'ID della categoria da recuperare
     * @return un oggetto {@link CategoriaDto} contenente i dettagli della categoria
     */
    CategoriaDto getCategoriaById(int id);

    /**
     * Restituisce una lista di tutte le categorie disponibili.
     * 
     * @return una lista di oggetti {@link CategoriaDto} contenente i dettagli di tutte le categorie
     */
    List<CategoriaDto> getAllCategorie();

    /**
     * Elimina una categoria dal sistema in base all'ID fornito.
     * 
     * @param id l'ID della categoria da eliminare
     */
    void deleteCategoriaById(int id);
}
