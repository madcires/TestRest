package it.corso.dto;

import it.corso.model.Tipologia;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

/**
 * DTO (Data Transfer Object) utilizzato per trasferire i dettagli del ruolo di un utente.
 * Contiene la tipologia del ruolo associato all'utente.
 */
public class UtenteRuoloDto {
    
    /**
     * La tipologia del ruolo dell'utente.
     * Viene mappata come stringa nel database.
     */
    @Enumerated(EnumType.STRING)
    private Tipologia tipologia;

    // Metodi getter e setter

    /**
     * Restituisce la tipologia del ruolo dell'utente.
     * 
     * @return tipologia del ruolo dell'utente
     */
    public Tipologia getTipologia() {
        return tipologia;
    }

    /**
     * Imposta la tipologia del ruolo dell'utente.
     * 
     * @param tipologia la tipologia del ruolo dell'utente
     */
    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }
}
