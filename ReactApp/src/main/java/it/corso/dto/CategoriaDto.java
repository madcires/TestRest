package it.corso.dto;

/**
 * DTO (Data Transfer Object) utilizzato per trasferire i dettagli di una categoria.
 * Contiene informazioni come l'ID e il nome della categoria.
 */
public class CategoriaDto {
    
    /**
     * L'ID della categoria.
     */
    private int id;
    
    /**
     * Il nome della categoria.
     */
    private String nomeCategoria;

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
    public String getNomeCategoria() {
        return nomeCategoria;
    }

    /**
     * Imposta il nome della categoria.
     * 
     * @param nomeCategoria il nome della categoria
     */
    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }
    
}
