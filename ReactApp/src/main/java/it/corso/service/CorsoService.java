package it.corso.service;

import java.util.List;

import it.corso.dto.CorsoAggiornamentoDto;
import it.corso.dto.CorsoCreazioneDto;
import it.corso.dto.CorsoDto;

/**
 * Interfaccia che definisce i metodi per la gestione dei corsi nel sistema.
 * Include operazioni per la creazione, aggiornamento, eliminazione e ricerca dei corsi.
 */
public interface CorsoService {
    
    /**
     * Restituisce i dettagli di un corso specifico in base all'ID fornito.
     * 
     * @param id l'ID del corso da recuperare
     * @return un oggetto {@link CorsoDto} contenente i dettagli del corso
     */
    CorsoDto getCorsoById(int id);

    /**
     * Restituisce una lista di tutti i corsi disponibili nel sistema.
     * 
     * @return una lista di oggetti {@link CorsoDto} contenente i dettagli di tutti i corsi
     */
    List<CorsoDto> getAllCorsi();

    /**
     * Crea un nuovo corso nel sistema con i dettagli forniti.
     * 
     * @param corsoDto un oggetto {@link CorsoCreazioneDto} contenente i dettagli del nuovo corso
     */
    void createCorso(CorsoCreazioneDto corsoDto);

    /**
     * Aggiorna i dettagli di un corso esistente nel sistema.
     * 
     * @param corsoDto un oggetto {@link CorsoAggiornamentoDto} contenente i nuovi dettagli del corso
     */
    void updateCorso(CorsoAggiornamentoDto corsoDto);

    /**
     * Elimina un corso dal sistema in base all'ID fornito.
     * 
     * @param id l'ID del corso da eliminare
     */
    void deleteCorsoById(int id);

    /**
     * Verifica se esiste un corso con il nome fornito nel sistema.
     * 
     * @param nomeCorso il nome del corso da verificare
     * @return true se esiste un corso con il nome fornito, false altrimenti
     */
    boolean existsByNomeCorso(String nomeCorso);
}
