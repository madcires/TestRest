package it.corso.dto;

import java.util.List;

import jakarta.validation.constraints.Pattern;

/**
 * DTO (Data Transfer Object) utilizzato per gestire i dati di registrazione di un nuovo utente.
 * Contiene informazioni come nome, cognome, email, password e i ruoli associati.
 */
public class UtenteDtoRegistrazione {
    
    /**
     * Il nome dell'utente.
     * Deve contenere solo lettere e avere una lunghezza massima di 50 caratteri.
     */
    @Pattern(regexp = "[a-zA-Z\\èàùìò]{1,50}", message = "Nome con caratteri non ammessi")
    private String nome;
    
    /**
     * Il cognome dell'utente.
     * Deve contenere solo lettere e avere una lunghezza massima di 50 caratteri.
     */
    @Pattern(regexp = "[a-zA-Z\\èàùìò]{1,50}", message = "Cognome con caratteri non ammessi")
    private String cognome;
    
    /**
     * L'email dell'utente.
     * Deve essere una email valida secondo il pattern specificato.
     */
    @Pattern(regexp = "[A-z0-9\\.\\+_-]+@[A-z0-9\\._-]+\\.[A-z]{2,8}", message="Email non valida")
    private String email;
    
    /**
     * La password dell'utente.
     */
    private String password;
    
    /**
     * La lista degli ID dei ruoli associati all'utente.
     */
    private List<Integer> ruoli;

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
     * Restituisce la password dell'utente.
     * 
     * @return password dell'utente
     */
    public String getPassword() {
        return password;
    }

    /**
     * Imposta la password dell'utente.
     * 
     * @param password la password dell'utente
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Restituisce la lista degli ID dei ruoli associati all'utente.
     * 
     * @return lista degli ID dei ruoli
     */
    public List<Integer> getRuoli() {
        return ruoli;
    }

    /**
     * Imposta la lista degli ID dei ruoli associati all'utente.
     * 
     * @param ruoli la lista degli ID dei ruoli
     */
    public void setRuoli(List<Integer> ruoli) {
        this.ruoli = ruoli;
    }
}
