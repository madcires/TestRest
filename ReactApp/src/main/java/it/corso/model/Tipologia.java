package it.corso.model;

/**
 * Enum che rappresenta le diverse tipologie di utenti nel sistema.
 */
public enum Tipologia {
    
    /**
     * Rappresenta un utente con privilegi amministrativi.
     */
    Admin,
    
    /**
     * Rappresenta un utente generico del sistema.
     */
    Utente,
    
    /**
     * Rappresenta un docente che può gestire corsi o lezioni.
     */
    Docente;
}
