package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.corso.dto.CorsoAggiornamentoDto;
import it.corso.dto.CorsoCreazioneDto;
import it.corso.dto.CorsoDto;
import it.corso.service.CorsoService;
import jakarta.validation.Valid;

/**
 * Controller REST per la gestione dei corsi.
 * Fornisce endpoint per operazioni CRUD relative ai corsi.
 */
@RestController
@RequestMapping("/api/corso")
public class CorsoController {

    @Autowired
    private CorsoService corsoService;
    
    /**
     * Restituisce i dettagli di un corso specifico in base all'ID fornito.
     * 
     * @param id l'ID del corso da recuperare
     * @return {@link ResponseEntity} contenente {@link CorsoDto} se il corso è trovato, o un errore di bad request
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<CorsoDto> getCorsoById(@PathVariable int id) {
        try {
            if(id > 0) {
                return ResponseEntity.ok(corsoService.getCorsoById(id));
            }
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Restituisce una lista di tutti i corsi disponibili.
     * 
     * @return {@link ResponseEntity} contenente una lista di {@link CorsoDto}, o un errore di bad request
     */
    @GetMapping("/get/all")
    public ResponseEntity<List<CorsoDto>> getAllCorsi() {
        try {
            List<CorsoDto> corsiDto = corsoService.getAllCorsi();
            return ResponseEntity.ok(corsiDto);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Crea un nuovo corso nel sistema.
     * 
     * @param corsoDto i dettagli del nuovo corso da creare
     * @return {@link ResponseEntity} che indica il successo o il fallimento della creazione
     */
    @PostMapping("/creation")
    public ResponseEntity<Void> createCorso(@Valid @RequestBody CorsoCreazioneDto corsoDto) {
        try {
            corsoService.createCorso(corsoDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Aggiorna i dettagli di un corso esistente nel sistema.
     * 
     * @param corsoDto i nuovi dettagli del corso da aggiornare
     * @return {@link ResponseEntity} che indica il successo o il fallimento dell'aggiornamento
     */
    @PutMapping("/update")
    public ResponseEntity<Void> updateCorso(@Valid @RequestBody CorsoAggiornamentoDto corsoDto){
        try {
            String nomeFromDb = corsoService.getCorsoById(corsoDto.getId()).getNomeCorso();
             
            if (!nomeFromDb.equals(corsoDto.getNomeCorso())) {
                if (corsoService.existsByNomeCorso(corsoDto.getNomeCorso())) {
                    return ResponseEntity.badRequest().build();
                }
            }
            corsoService.updateCorso(corsoDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Elimina un corso dal sistema in base all'ID fornito.
     * 
     * @param id l'ID del corso da eliminare
     * @return {@link ResponseEntity} che indica il successo o il fallimento dell'eliminazione
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCorso(@PathVariable int id){
        try {
            corsoService.deleteCorsoById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
