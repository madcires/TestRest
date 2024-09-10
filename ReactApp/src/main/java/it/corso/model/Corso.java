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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Classe che rappresenta un corso nel sistema.
 * Un corso appartiene a una categoria e può avere molti utenti iscritti.
 */
@Entity
@Table(name = "Corso")
public class Corso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_C")
    private int id;
    
    @Column(name = "Nome_Corso")
    private String nomeCorso;
    
    @Column(name = "Descrizione_breve")
    private String descrizioneBreve;
    
    @Column(name = "Descrizione_Completa")
    private String descrizioneCompleta;
    
    /**
     * Categoria a cui appartiene il corso. La relazione è di tipo many-to-one.
     */
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "FK_CA", referencedColumnName = "ID_CA")
    private Categoria categoria;
    
    /**
     * Lista degli utenti iscritti a questo corso. La relazione è di tipo many-to-many.
     * Utilizza un join table denominato "utenti_corsi".
     */
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(
        name = "utenti_corsi", 
        joinColumns = @JoinColumn(name = "FK_CU", referencedColumnName = "ID_C"),
        inverseJoinColumns = @JoinColumn(name = "FK_UC", referencedColumnName = "ID_U")
    )
    private List<Utente> utenti = new ArrayList<>();
    
    @Column(name = "Durata")
    private int durata;

    // Metodi getter e setter

    /**
     * Restituisce l'ID del corso.
     * 
     * @return id del corso
     */
    public int getId() {
        return id;
    }

    /**
     * Imposta l'ID del corso.
     * 
     * @param id l'ID del corso
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Restituisce il nome del corso.
     * 
     * @return nome del corso
     */
    public String getNomeCorso() {
        return nomeCorso;
    }

    /**
     * Imposta il nome del corso.
     * 
     * @param nomeCorso il nome del corso
     */
    public void setNomeCorso(String nomeCorso) {
        this.nomeCorso = nomeCorso;
    }

    /**
     * Restituisce una descrizione breve del corso.
     * 
     * @return descrizione breve del corso
     */
    public String getDescrizioneBreve() {
        return descrizioneBreve;
    }

    /**
     * Imposta una descrizione breve del corso.
     * 
     * @param descrizioneBreve la descrizione breve del corso
     */
    public void setDescrizioneBreve(String descrizioneBreve) {
        this.descrizioneBreve = descrizioneBreve;
    }

    /**
     * Restituisce una descrizione completa del corso.
     * 
     * @return descrizione completa del corso
     */
    public String getDescrizioneCompleta() {
        return descrizioneCompleta;
    }

    /**
     * Imposta una descrizione completa del corso.
     * 
     * @param descrizioneCompleta la descrizione completa del corso
     */
    public void setDescrizioneCompleta(String descrizioneCompleta) {
        this.descrizioneCompleta = descrizioneCompleta;
    }

    /**
     * Restituisce la durata del corso.
     * 
     * @return durata del corso
     */
    public int getDurata() {
        return durata;
    }

    /**
     * Imposta la durata del corso.
     * 
     * @param durata la durata del corso
     */
    public void setDurata(int durata) {
        this.durata = durata;
    }

    /**
     * Restituisce la categoria a cui appartiene il corso.
     * 
     * @return categoria del corso
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Imposta la categoria a cui appartiene il corso.
     * 
     * @param categoria la categoria del corso
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    /**
     * Restituisce la lista degli utenti iscritti al corso.
     * 
     * @return lista degli utenti iscritti
     */
    public List<Utente> getUtenti() {
        return utenti;
    }

    /**
     * Imposta la lista degli utenti iscritti al corso.
     * 
     * @param utenti la lista degli utenti iscritti
     */
    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }
}
