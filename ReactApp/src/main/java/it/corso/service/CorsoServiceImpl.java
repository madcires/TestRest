package it.corso.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.corso.dao.CategoriaDao;
import it.corso.dao.CorsoDao;
import it.corso.dto.CorsoAggiornamentoDto;
import it.corso.dto.CorsoCreazioneDto;
import it.corso.dto.CorsoDto;
import it.corso.model.Categoria;
import it.corso.model.Corso;

/**
 * Implementazione del servizio per la gestione dei corsi.
 * Fornisce metodi per creare, aggiornare, eliminare e recuperare i corsi, oltre a verificare l'esistenza di un corso per nome.
 */
@Service
public class CorsoServiceImpl implements CorsoService {
    
    @Autowired
    private CorsoDao corsoDao;
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    private ModelMapper mapper = new ModelMapper();

    /**
     * Restituisce i dettagli di un corso specifico in base all'ID fornito.
     * 
     * @param id l'ID del corso da recuperare
     * @return un oggetto {@link CorsoDto} contenente i dettagli del corso, o null se non trovato
     */
    @Override
    public CorsoDto getCorsoById(int id) {
        try {
            Optional<Corso> corsoOptional = corsoDao.findById(id);
            if(corsoOptional.isPresent()) {
                Corso corso = corsoOptional.get();
                Categoria categoria = categoriaDao.findById(corso.getCategoria().getId()).get();
                String nomeCategoria = categoria.getNomeCategoria().toString();
                CorsoDto corsoDto = mapper.map(corso, CorsoDto.class);
                corsoDto.setCategoria(nomeCategoria);
                return corsoDto;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Restituisce una lista di tutti i corsi disponibili nel sistema.
     * 
     * @return una lista di oggetti {@link CorsoDto} contenente i dettagli di tutti i corsi, o null in caso di errore
     */
    @Override
    public List<CorsoDto> getAllCorsi() {
        try {
            List<Corso> corsi = (List<Corso>) corsoDao.findAll();
            List<CorsoDto> corsiDto = new ArrayList<>();
            for(int i= 0; i< corsi.size(); i++) {
                Categoria categoria = categoriaDao.findById(corsi.get(i).getCategoria().getId()).get();
                String nomeCategoria = categoria.getNomeCategoria().toString();
                corsiDto.add(mapper.map(corsi.get(i), CorsoDto.class));
                corsiDto.get(i).setCategoria(nomeCategoria);
            }
            return corsiDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Crea un nuovo corso nel sistema.
     * 
     * @param corsoDto i dettagli del nuovo corso da creare
     */
    @Override
    public void createCorso(CorsoCreazioneDto corsoDto) {
		try {
			Corso corso = mapper.map(corsoDto, Corso.class);
			Optional<Categoria> optionalCategoria = categoriaDao.findById(corsoDto.getCategoria());
			if (optionalCategoria.isPresent()) {
				corso.setCategoria(optionalCategoria.get());
				corsoDao.save(corso);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}     
    }

    /**
     * Aggiorna i dettagli di un corso esistente nel sistema.
     * 
     * @param corsoDto i nuovi dettagli del corso da aggiornare
     */
    @Override
    public void updateCorso(CorsoAggiornamentoDto corsoDto) {
        try {
            Optional<Corso> corsoOptional = corsoDao.findById(corsoDto.getId());
            if(corsoOptional.isPresent()) {
                Corso corso = corsoOptional.get();
                corso.setNomeCorso(corsoDto.getNomeCorso());
                corso.setDescrizioneBreve(corsoDto.getDescrizioneBreve());
                corso.setDescrizioneCompleta(corsoDto.getDescrizioneCompleta());
                corso.setDurata(corsoDto.getDurata());
                Categoria categoria = categoriaDao.findById(corsoDto.getCategoria()).get();
                corso.setCategoria(categoria);
                corsoDao.save(corso);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Elimina un corso dal sistema in base all'ID fornito.
     * 
     * @param id l'ID del corso da eliminare
     */
    @Override
    public void deleteCorsoById(int id) {
        try {
            Optional<Corso> corsoOptional = corsoDao.findById(id);
            if(corsoOptional.isPresent()) {
                corsoDao.delete(corsoOptional.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica se esiste un corso con il nome specificato nel sistema.
     * 
     * @param nomeCorso il nome del corso da verificare
     * @return true se esiste un corso con il nome fornito, false altrimenti
     */
    public boolean existsByNomeCorso(String nomeCorso) {
        try {
            return corsoDao.existsByNomeCorso(nomeCorso);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
