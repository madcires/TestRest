package it.corso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Classe che rappresenta un ruolo nel sistema.
 * Un ruolo può essere associato a uno o più utenti e definisce la tipologia dell'utente nel sistema.
 */
@Entity
@Table(name = "ruolo")
public class Ruolo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_G")
    private int id;
    
    @Column(name = "TIPOLOGIA")
    @Enumerated(EnumType.STRING)
    private Tipologia tipologia;
    
    /**
     * Lista degli utenti associati a questo ruolo. La relazione è di tipo many-to-many.
     * Utilizza un join table denominato "utente_ruolo".
     */
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(
        name = "utente_ruolo", 
        joinColumns = @JoinColumn(name = "FK_R", referencedColumnName = "ID_G"),
        inverseJoinColumns = @JoinColumn(name = "FK_U", referencedColumnName = "ID_U")
    )
    private List<Utente> utenti = new ArrayList<>();
    
    // Metodi getter e setter

    /**
     * Restituisce l'ID del ruolo.
     * 
     * @return id del ruolo
     */
    public int getId() {
        return id;
    }

    /**
     * Imposta l'ID del ruolo.
     * 
     * @param id l'ID del ruolo
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Restituisce la tipologia del ruolo.
     * 
     * @return tipologia del ruolo
     */
    public Tipologia getTipologia() {
        return tipologia;
    }

    /**
     * Imposta la tipologia del ruolo.
     * 
     * @param tipologia la tipologia del ruolo
     */
    public void setTipologia(Tipologia tipologia) {
        this.tipologia = tipologia;
    }

    /**
     * Restituisce la lista degli utenti associati a questo ruolo.
     * 
     * @return lista degli utenti
     */
    public List<Utente> getUtenti() {
        return utenti;
    }

    /**
     * Imposta la lista degli utenti associati a questo ruolo.
     * 
     * @param utenti la lista degli utenti
     */
    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }
}
