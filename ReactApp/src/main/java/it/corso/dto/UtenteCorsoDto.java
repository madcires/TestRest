package it.corso.dto;

/**
 * DTO (Data Transfer Object) utilizzato per trasferire i dettagli di un corso associato a un utente.
 * Contiene solo il nome del corso.
 */
public class UtenteCorsoDto {
    
    /**
     * Il nome del corso associato all'utente.
     */
    private String nomeCorso;
    
    // Metodi getter e setter

    /**
     * Restituisce il nome del corso associato all'utente.
     * 
     * @return nome del corso
     */
    public String getNomeCorso() {
        return nomeCorso;
    }
 
    /**
     * Imposta il nome del corso associato all'utente.
     * 
     * @param nomeCorso il nome del corso
     */
    public void setNomeCorso(String nomeCorso) {
        this.nomeCorso = nomeCorso;
    }
}
