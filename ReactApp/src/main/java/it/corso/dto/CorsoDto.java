package it.corso.dto;

/**
 * DTO (Data Transfer Object) utilizzato per trasferire i dettagli di un corso.
 * Contiene le informazioni di base di un corso come nome, descrizione, categoria e durata.
 */
public class CorsoDto {
    
    /**
     * Il nome del corso.
     */
    private String nomeCorso;
    
    /**
     * La descrizione breve del corso.
     */
    private String descrizioneBreve;
    
    /**
     * La descrizione completa del corso.
     */
    private String descrizioneCompleta;
    
    /**
     * La categoria a cui appartiene il corso.
     */
    private String categoria;
    
    /**
     * La durata del corso in ore.
     */
    private int durata;

    // Metodi getter e setter

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
     * Restituisce la descrizione breve del corso.
     * 
     * @return descrizione breve del corso
     */
    public String getDescrizioneBreve() {
        return descrizioneBreve;
    }

    /**
     * Imposta la descrizione breve del corso.
     * 
     * @param descrizioneBreve la descrizione breve del corso
     */
    public void setDescrizioneBreve(String descrizioneBreve) {
        this.descrizioneBreve = descrizioneBreve;
    }

    /**
     * Restituisce la descrizione completa del corso.
     * 
     * @return descrizione completa del corso
     */
    public String getDescrizioneCompleta() {
        return descrizioneCompleta;
    }

    /**
     * Imposta la descrizione completa del corso.
     * 
     * @param descrizioneCompleta la descrizione completa del corso
     */
    public void setDescrizioneCompleta(String descrizioneCompleta) {
        this.descrizioneCompleta = descrizioneCompleta;
    }

    /**
     * Restituisce la categoria a cui appartiene il corso.
     * 
     * @return categoria del corso
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Imposta la categoria a cui appartiene il corso.
     * 
     * @param categoria la categoria del corso
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Restituisce la durata del corso in ore.
     * 
     * @return durata del corso in ore
     */
    public int getDurata() {
        return durata;
    }

    /**
     * Imposta la durata del corso in ore.
     * 
     * @param durata la durata del corso in ore
     */
    public void setDurata(int durata) {
        this.durata = durata;
    }
}
