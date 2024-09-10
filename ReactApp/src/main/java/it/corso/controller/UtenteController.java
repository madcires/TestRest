package it.corso.controller;

import java.util.List;
import java.util.regex.Pattern;

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

import it.corso.dto.UtenteDtoAggiornamento;
import it.corso.dto.UtenteDto;
import it.corso.dto.UtenteDtoRegistrazione;
import it.corso.dto.UtenteDtoLogin;
import it.corso.service.UtenteService;
import jakarta.validation.Valid;

/**
 * Controller REST per la gestione degli utenti.
 * Fornisce endpoint per operazioni CRUD e autenticazione relative agli utenti.
 */
@RestController
@RequestMapping("/api/utente")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;
    
    /**
     * Restituisce un utente in base all'ID specificato.
     * 
     * @param id l'ID dell'utente da recuperare
     * @return {@link ResponseEntity} contenente {@link UtenteDto} se l'utente è trovato, o un errore di bad request
     */
    @GetMapping("/get/id/{id}")
    public ResponseEntity<UtenteDto> getUtenteById(@PathVariable int id) {
        try {
            UtenteDto utente = utenteService.getUtenteById(id);
            if(id > 1 && utente != null) {
                return ResponseEntity.ok(utente);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Restituisce un utente in base all'email specificata.
     * 
     * @param email l'email dell'utente da recuperare
     * @return {@link ResponseEntity} contenente {@link UtenteDto} se l'utente è trovato, o un errore di bad request
     */
    @GetMapping("/get/email/{email}")
    public ResponseEntity<UtenteDto> getUtenteByEmail(@PathVariable String email) {
        try {
            UtenteDto utente = utenteService.getUtenteByEmail(email);
            if(!email.isEmpty() && !email.isBlank() && email != null && utente != null) {
                return ResponseEntity.ok(utente);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Restituisce una lista di tutti gli utenti.
     * 
     * @return {@link ResponseEntity} contenente una lista di {@link UtenteDto}, o un errore di bad request
     */
    @GetMapping("/get/all")
    public ResponseEntity<List<UtenteDto>> getAllUtenti() {
        try {
            List<UtenteDto> utenti = utenteService.getAllUtenti();
            return ResponseEntity.ok(utenti);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Registra un nuovo utente nel sistema.
     * 
     * @param utenteDto i dettagli dell'utente da registrare
     * @return {@link ResponseEntity} che indica il successo o il fallimento della registrazione
     */
    @PostMapping("/registration")
    public ResponseEntity<?> registrationUtente(@Valid @RequestBody UtenteDtoRegistrazione utenteDto) {
        try {
            if(utenteService.existsByEmail(utenteDto.getEmail())) {
                return ResponseEntity.badRequest().body("Email già esistente");
            } else if(!Pattern.matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,20}", utenteDto.getPassword())) {
                return ResponseEntity.badRequest().body("Password non valida");
            } else {
                utenteService.registrationUtente(utenteDto);
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Aggiorna i dati di un utente esistente.
     * 
     * @param utenteDto i nuovi dettagli dell'utente
     * @return {@link ResponseEntity} che indica il successo o il fallimento dell'aggiornamento
     */
    @PutMapping("/update")
    public ResponseEntity<?> updateUtenteData(@Valid @RequestBody UtenteDtoAggiornamento utenteDto) {
        try {
            UtenteDto utenteFromDb = utenteService.getUtenteById(utenteDto.getId());
            String emailFromDb = utenteFromDb.getEmail();
            String emailDto = utenteDto.getEmail();
            if(!emailFromDb.equals(emailDto)) {
                if(utenteService.existsByEmail(emailDto)) {
                    return ResponseEntity.badRequest().body("Email già esistente");
                }
            }
            utenteService.updateUtenteData(utenteDto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Elimina un utente in base all'ID specificato.
     * 
     * @param id l'ID dell'utente da eliminare
     * @return {@link ResponseEntity} che indica il successo o il fallimento dell'eliminazione
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUtente(@PathVariable int id) {
        try {
            if(id > 0) {
                utenteService.deleteUtenteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    /**
     * Esegue il login di un utente nel sistema.
     * 
     * @param utenteDto i dati di login dell'utente
     * @return {@link ResponseEntity} che indica il successo o il fallimento del login
     */
    @PostMapping("/login")
    public ResponseEntity<Boolean> loginUtente(@Valid @RequestBody UtenteDtoLogin utenteDto) {
        try {
            if(utenteService.loginUtente(utenteDto)) {
                return ResponseEntity.ok().build();
            }
            else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
