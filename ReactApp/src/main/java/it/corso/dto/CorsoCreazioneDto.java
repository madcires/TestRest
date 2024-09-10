package it.corso.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO (Data Transfer Object) utilizzato per la creazione di un nuovo corso.
 * Contiene le informazioni necessarie per creare un corso nel sistema.
 */
public class CorsoCreazioneDto {
    
    /**
     * Il nome del corso.
     * Non può essere vuoto e non può superare i 100 caratteri.
     */
    @NotBlank(message = "Il nome del corso non può essere vuoto")
    @Size(max = 100, message = "Il nome del corso non può superare i 100 caratteri")
    private String nomeCorso;
    
    /**
     * La descrizione breve del corso.
     * Non può essere vuota e non può superare i 255 caratteri.
     */
    @NotBlank(message = "La descrizione breve non può essere vuota")
    @Size(max = 255, message = "La descrizione breve non può superare i 255 caratteri")
    private String descrizioneBreve;
 
    /**
     * La descrizione completa del corso.
     * Non può superare i 2000 caratteri.
     */
    @Size(max = 2000, message = "La descrizione completa non può superare i 2000 caratteri")
    private String descrizioneCompleta;
 
    /**
     * L'ID della categoria associata al corso.
     * Deve essere un valore positivo.
     */
    @Min(value = 1, message = "La categoria deve essere un valore positivo")
    private int categoria;
 
    /**
     * La durata del corso in ore.
     * Deve essere almeno 1 ora e non può superare le 1000 ore.
     */
    @Min(value = 1, message = "La durata deve essere almeno 1 ora")
    @Max(value = 1000, message = "La durata non può superare le 1000 ore")
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
     * Restituisce l'ID della categoria associata al corso.
     * 
     * @return id della categoria
     */
    public int getCategoria() {
        return categoria;
    }
 
    /**
     * Imposta l'ID della categoria associata al corso.
     * 
     * @param categoria l'ID della categoria
     */
    public void setCategoria(int categoria) {
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
