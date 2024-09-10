package it.corso.dto;

import java.util.List;

/**
 * DTO (Data Transfer Object) utilizzato per trasferire i dettagli di un utente.
 * Contiene informazioni come nome, cognome, email, ruoli e corsi associati all'utente.
 */
public class UtenteDto {
    
    /**
     * Il nome dell'utente.
     */
    private String nome;
    
    /**
     * Il cognome dell'utente.
     */
    private String cognome;
    
    /**
     * L'email dell'utente.
     */
    private String email;

    /**
     * La lista dei ruoli associati all'utente.
     */
    private List<UtenteRuoloDto> ruoli;
    
    /**
     * La lista dei corsi associati all'utente.
     */
    private List<UtenteCorsoDto> corsi;

    // Metodi getter e setter

    /**
     * Restituisce il nome dell'utente.
     * 
     * @return nome dell'utente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Imposta il nome dell'utente.
     * 
     * @param nome il nome dell'utente
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Restituisce il cognome dell'utente.
     * 
     * @return cognome dell'utente
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Imposta il cognome dell'utente.
     * 
     * @param cognome il cognome dell'utente
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Restituisce l'email dell'utente.
     * 
     * @return email dell'utente
     */
    public String getEmail() {
        return email;
    }

    /**
     * Imposta l'email dell'utente.
     * 
     * @param email l'email dell'utente
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Restituisce la lista dei ruoli associati all'utente.
     * 
     * @return lista dei ruoli
     */
    public List<UtenteRuoloDto> getRuoli() {
        return ruoli;
    }

    /**
     * Imposta la lista dei ruoli associati all'utente.
     * 
     * @param ruoli la lista dei ruoli
     */
    public void setRuoli(List<UtenteRuoloDto> ruoli) {
        this.ruoli = ruoli;
    }

    /**
     * Restituisce la lista dei corsi associati all'utente.
     * 
     * @return lista dei corsi
     */
    public List<UtenteCorsoDto> getCorsi() {
        return corsi;
    }

    /**
     * Imposta la lista dei corsi associati all'utente.
     * 
     * @param corsi la lista dei corsi
     */
    public void setCorsi(List<UtenteCorsoDto> corsi) {
        this.corsi = corsi;
    }

}
