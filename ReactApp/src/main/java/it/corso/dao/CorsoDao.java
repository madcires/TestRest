package it.corso.dao;

import org.springframework.data.repository.CrudRepository;
import it.corso.model.Corso;

/**
 * DAO (Data Access Object) per la gestione delle operazioni CRUD sulla tabella Corso.
 * Estende l'interfaccia {@link CrudRepository} fornendo i metodi base per l'interazione con il database.
 */
public interface CorsoDao extends CrudRepository<Corso, Integer> {
    
    /**
     * Verifica se esiste un corso con il nome specificato nel database.
     * 
     * @param nomeCorso il nome del corso da verificare
     * @return true se esiste un corso con il nome fornito, false altrimenti
     */
    boolean existsByNomeCorso(String nomeCorso);

}
