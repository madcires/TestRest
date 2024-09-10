package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Classe che rappresenta un Utente nel sistema.
 * Un utente può avere uno o più ruoli e può essere iscritto a uno o più corsi.
 */
@Entity
@Table(name = "Utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_U")
    private int id;
    
    @Column(name = "Nome")
    private String nome;
        
    @Column(name = "Cognome")
    private String cognome;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    /**
     * Ruoli associati all'utente. La relazione è di tipo many-to-many.
     * Utilizza un join table denominato "utente_ruolo".
     */
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(
        name = "utente_ruolo", 
        joinColumns = @JoinColumn(name = "FK_U", referencedColumnName = "ID_U"),
        inverseJoinColumns = @JoinColumn(name = "FK_R", referencedColumnName = "ID_G")
    )
    private List<Ruolo> ruoli = new ArrayList<>();
    
    /**
     * Corsi ai quali l'utente è iscritto. La relazione è di tipo many-to-many.
     * Utilizza un join table denominato "utenti_corsi".
     */
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(
        name = "utenti_corsi", 
        joinColumns = @JoinColumn(name = "FK_UC", referencedColumnName = "ID_U"),
        inverseJoinColumns = @JoinColumn(name = "FK_CU", referencedColumnName = "ID_C")
    )
    private List<Corso> corsi = new ArrayList<>();
    
    // Metodi getter e setter

    /**
     * Restituisce l'ID dell'utente.
     * 
     * @return id dell'utente
     */
    public int getId() {
        return id;
    }

    /**
     * Imposta l'ID dell'utente.
     * 
     * @param id l'ID dell'utente
     */
    public void setId(int id) {
        this.id = id;
    }

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
     * Restituisce la lista dei ruoli associati all'utente.
     * 
     * @return lista dei ruoli
     */
    public List<Ruolo> getRuoli() {
        return ruoli;
    }

    /**
     * Imposta la lista dei ruoli associati all'utente.
     * 
     * @param ruoli la lista dei ruoli
     */
    public void setRuoli(List<Ruolo> ruoli) {
        this.ruoli = ruoli;
    }

    /**
     * Restituisce la lista dei corsi ai quali l'utente è iscritto.
     * 
     * @return lista dei corsi
     */
    public List<Corso> getCorsi() {
        return corsi;
    }

    /**
     * Imposta la lista dei corsi ai quali l'utente è iscritto.
     * 
     * @param corsi la lista dei corsi
     */
    public void setCorsi(List<Corso> corsi) {
        this.corsi = corsi;
    }
}
