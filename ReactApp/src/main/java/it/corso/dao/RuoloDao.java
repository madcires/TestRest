package it.corso.dao;

import org.springframework.data.repository.CrudRepository;
import it.corso.model.Ruolo;

/**
 * DAO (Data Access Object) per la gestione delle operazioni CRUD sulla tabella Ruolo.
 * Estende l'interfaccia {@link CrudRepository} fornendo i metodi base per l'interazione con il database.
 */
public interface RuoloDao extends CrudRepository<Ruolo, Integer> {

}
