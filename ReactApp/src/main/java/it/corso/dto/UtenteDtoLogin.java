package it.corso.dto;

import jakarta.validation.constraints.Pattern;

/**
 * DTO (Data Transfer Object) utilizzato per gestire i dati di login di un utente.
 * Contiene l'email e la password dell'utente necessari per l'autenticazione.
 */
public class UtenteDtoLogin {

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

    // Metodi getter e setter

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
}
