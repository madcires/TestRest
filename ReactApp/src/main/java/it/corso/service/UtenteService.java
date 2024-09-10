package it.corso.service;

import java.util.List;

import it.corso.dto.UtenteDtoAggiornamento;
import it.corso.dto.UtenteDto;
import it.corso.dto.UtenteDtoRegistrazione;
import it.corso.dto.UtenteDtoLogin;

/**
 * Interfaccia che definisce i metodi per la gestione degli utenti nel sistema.
 * Include operazioni per la registrazione, aggiornamento, eliminazione, autenticazione e ricerca degli utenti.
 */
public interface UtenteService {

    /**
     * Restituisce i dettagli di un utente specifico in base all'ID fornito.
     * 
     * @param id l'ID dell'utente da recuperare
     * @return un oggetto {@link UtenteDto} contenente i dettagli dell'utente
     */
    UtenteDto getUtenteById(int id);

    /**
     * Restituisce i dettagli di un utente specifico in base all'email fornita.
     * 
     * @param email l'email dell'utente da recuperare
     * @return un oggetto {@link UtenteDto} contenente i dettagli dell'utente
     */
    UtenteDto getUtenteByEmail(String email);

    /**
     * Restituisce una lista di tutti gli utenti registrati nel sistema.
     * 
     * @return una lista di oggetti {@link UtenteDto} contenente i dettagli di tutti gli utenti
     */
    List<UtenteDto> getAllUtenti();

    /**
     * Registra un nuovo utente nel sistema con i dettagli forniti.
     * 
     * @param utente un oggetto {@link UtenteDtoRegistrazione} contenente i dettagli del nuovo utente
     * @return true se la registrazione ha successo, false altrimenti
     */
    boolean registrationUtente(UtenteDtoRegistrazione utente);

    /**
     * Aggiorna i dati di un utente esistente nel sistema.
     * 
     * @param utente un oggetto {@link UtenteDtoAggiornamento} contenente i nuovi dettagli dell'utente
     */
    void updateUtenteData(UtenteDtoAggiornamento utente);

    /**
     * Elimina un utente dal sistema in base all'ID fornito.
     * 
     * @param id l'ID dell'utente da eliminare
     */
    void deleteUtenteById(int id);

    /**
     * Effettua il login di un utente nel sistema.
     * 
     * @param utenteDto un oggetto {@link UtenteDtoLogin} contenente le credenziali di login dell'utente
     * @return true se il login ha successo, false altrimenti
     */
    boolean loginUtente(UtenteDtoLogin utenteDto);

    /**
     * Verifica se esiste un utente con l'email fornita nel sistema.
     * 
     * @param email l'email dell'utente da verificare
     * @return true se esiste un utente con l'email fornita, false altrimenti
     */
    boolean existsByEmail(String email);
    
    /**
     * Verifica se esiste un utente con l'email e la password fornite nel sistema.
     * 
     * @param email l'email dell'utente da verificare
     * @param password la password dell'utente da verificare
     * @return true se esiste un utente con l'email e la password fornite, false altrimenti
     */
    boolean existsByEmailAndPassword(String email, String password);
}
