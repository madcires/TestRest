package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.RuoloDao;
import it.corso.dao.UtenteDao;
import it.corso.dto.UtenteDtoAggiornamento;
import it.corso.dto.UtenteDto;
import it.corso.dto.UtenteDtoRegistrazione;
import it.corso.dto.UtenteDtoLogin;
import it.corso.model.Ruolo;
import it.corso.model.Utente;

/**
 * Implementazione del servizio per la gestione degli utenti.
 * Fornisce metodi per creare, aggiornare, eliminare e recuperare gli utenti, oltre a gestire l'autenticazione e la registrazione.
 */
@Service
public class UtenteServiceImpl implements UtenteService {
    
    @Autowired
    private UtenteDao utenteDao;
    
    @Autowired
    private RuoloDao ruoloDao;
    
    private ModelMapper mapper = new ModelMapper();

    /**
     * Restituisce i dettagli di un utente specifico in base all'ID fornito.
     * 
     * @param id l'ID dell'utente da recuperare
     * @return un oggetto {@link UtenteDto} contenente i dettagli dell'utente, o null se non trovato
     */
    @Override
    public UtenteDto getUtenteById(int id) {
        try {
            Optional<Utente> utenteOptional = utenteDao.findById(id);
            if (utenteOptional.isPresent()) {
                Utente utente = utenteOptional.get();
                UtenteDto utenteDto = mapper.map(utente, UtenteDto.class);
                return utenteDto;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Restituisce i dettagli di un utente specifico in base all'email fornita.
     * 
     * @param email l'email dell'utente da recuperare
     * @return un oggetto {@link UtenteDto} contenente i dettagli dell'utente, o null se non trovato
     */
    @Override
    public UtenteDto getUtenteByEmail(String email) {
        try {
            Utente utente = utenteDao.findByEmail(email);
            if(utente.equals(null)) {
                return null;
            }
            UtenteDto utenteDto = mapper.map(utente, UtenteDto.class);
            return utenteDto;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Restituisce una lista di tutti gli utenti registrati nel sistema.
     * 
     * @return una lista di oggetti {@link UtenteDto} contenente i dettagli di tutti gli utenti, o null in caso di errore
     */
    @Override
    public List<UtenteDto> getAllUtenti() {
        try {
            List<Utente> utenti = (List<Utente>) utenteDao.findAll();
            List<UtenteDto> utentiDto = new ArrayList<>();
            utenti.forEach(u->utentiDto.add(mapper.map(u, UtenteDto.class)));
            return utentiDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Registra un nuovo utente nel sistema.
     * 
     * @param utenteDto i dettagli del nuovo utente da registrare
     * @return true se la registrazione ha successo, false altrimenti
     */
    @Override
    public boolean registrationUtente(UtenteDtoRegistrazione utenteDto) {
        try {
            if(!utenteDao.existsByEmail(utenteDto.getEmail())) {
                List<Ruolo> ruoli = new ArrayList<>();
                List<Integer> idRuoliUtente = utenteDto.getRuoli();
                idRuoliUtente.forEach(id->ruoli.add(ruoloDao.findById(id).get()));
                Utente utente = new Utente();
                utente.setNome(utenteDto.getNome());
                utente.setCognome(utenteDto.getCognome());
                utente.setEmail(utenteDto.getEmail());
                utente.setRuoli(ruoli);
                String sha256hex = DigestUtils.sha256Hex(utenteDto.getPassword());
                utente.setPassword(sha256hex);
                utenteDao.save(utente);
                return true;
            } 
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Aggiorna i dati di un utente esistente nel sistema.
     * 
     * @param utenteDto i nuovi dettagli dell'utente
     */
    @Override
    public void updateUtenteData(UtenteDtoAggiornamento utenteDto) {
        try {
            Utente utenteFromDb = utenteDao.findById(utenteDto.getId()).get();
            String passwordFromDb = utenteFromDb.getPassword();
            Utente utente = new Utente();
            utente = mapper.map(utenteDto, Utente.class);
            utente.setPassword(passwordFromDb);
            utenteDao.save(utente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un utente dal sistema in base all'ID fornito.
     * 
     * @param id l'ID dell'utente da eliminare
     */
    @Override
    public void deleteUtenteById(int id) {
        try {
            Optional<Utente> utenteOptional = utenteDao.findById(id);
            if(utenteOptional.isPresent()) {
                utenteDao.deleteById(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Esegue il login di un utente verificando le credenziali fornite.
     * 
     * @param utenteDto i dati di login dell'utente
     * @return true se il login ha successo, false altrimenti
     */
    @Override
    public boolean loginUtente(UtenteDtoLogin utenteDto) {
        try {
            String email = utenteDto.getEmail();
            String passwordHashata = DigestUtils.sha256Hex(utenteDto.getPassword());
            if(utenteDao.existsByEmailAndPassword(email, passwordHashata)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Verifica se esiste un utente con l'email specificata nel sistema.
     * 
     * @param email l'email dell'utente da verificare
     * @return true se esiste un utente con l'email fornita, false altrimenti
     */
    @Override
    public boolean existsByEmail(String email) {
        return utenteDao.existsByEmail(email);
    }

    /**
     * Verifica se esiste un utente con l'email e la password specificate nel sistema.
     * 
     * @param email l'email dell'utente da verificare
     * @param password la password dell'utente da verificare
     * @return true se esiste un utente con l'email e la password fornite, false altrimenti
     */
	@Override
	public boolean existsByEmailAndPassword(String email, String password) {
		return utenteDao.existsByEmailAndPassword(email, password);
	}

}
