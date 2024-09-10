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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Classe che rappresenta una categoria nel sistema.
 * Una categoria può avere uno o più corsi associati.
 */
@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CA")
    private int id;
    
    @Column(name = "nome_categoria")
    @Enumerated(EnumType.STRING)
    private NomeCategoria nomeCategoria;
    
    /**
     * Lista dei corsi associati a questa categoria. La relazione è di tipo one-to-many.
     * La gestione della relazione include la rimozione orfana e il caricamento EAGER.
     */
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Corso> corso = new ArrayList<>();
    
    // Metodi getter e setter

    /**
     * Restituisce l'ID della categoria.
     * 
     * @return id della categoria
     */
    public int getId() {
        return id;
    }

    /**
     * Imposta l'ID della categoria.
     * 
     * @param id l'ID della categoria
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Restituisce il nome della categoria.
     * 
     * @return nome della categoria
     */
    public NomeCategoria getNomeCategoria() {
        return nomeCategoria;
    }

    /**
     * Imposta il nome della categoria.
     * 
     * @param nomeCategoria il nome della categoria
     */
    public void setNomeCategoria(NomeCategoria nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    /**
     * Restituisce la lista dei corsi associati a questa categoria.
     * 
     * @return lista dei corsi
     */
    public List<Corso> getCorso() {
        return corso;
    }

    /**
     * Imposta la lista dei corsi associati a questa categoria.
     * 
     * @param corso la lista dei corsi
     */
    public void setCorso(List<Corso> corso) {
        this.corso = corso;
    }
}
