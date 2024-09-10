package it.corso.dao;

import org.springframework.data.repository.CrudRepository;
import it.corso.model.Utente;

/**
 * DAO (Data Access Object) per la gestione delle operazioni CRUD sulla tabella Utente.
 * Estende l'interfaccia {@link CrudRepository} fornendo i metodi base per l'interazione con il database.
 */
public interface UtenteDao extends CrudRepository<Utente, Integer> {
    
    /**
     * Trova un utente nel database in base all'email fornita.
     * 
     * @param email l'email dell'utente da cercare
     * @return l'oggetto {@link Utente} corrispondente all'email fornita, o null se non trovato
     */
    Utente findByEmail(String email);

    /**
     * Verifica se esiste un utente con l'email specificata nel database.
     * 
     * @param email l'email dell'utente da verificare
     * @return true se esiste un utente con l'email fornita, false altrimenti
     */
    boolean existsByEmail(String email);
    
    /**
     * Verifica se esiste un utente con l'email e la password specificate nel database.
     * 
     * @param email l'email dell'utente da verificare
     * @param password la password dell'utente da verificare
     * @return true se esiste un utente con l'email e la password fornite, false altrimenti
     */
    boolean existsByEmailAndPassword(String email, String password);
    
}
