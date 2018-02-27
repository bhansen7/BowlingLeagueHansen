package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;

public class PlayerHelper {
EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("BowlingLeagueHansen");
	
	public void insertItem(Player toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
	}

	public List<Player> showAllItems() {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		TypedQuery<Player> allResults = em.createQuery("select li from Player li", Player.class);
		List<Player> allItems = allResults.getResultList();
		em.close();
		return allItems;
	}

	public void deletePlayer(Player toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery(
				"select li from Player li where li.playerId = :selectedId",
				Player.class);
		typedQuery.setParameter("selectedId", toDelete.getPlayerId());
		typedQuery.setMaxResults(1);
		Player result = typedQuery.getSingleResult(); 
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	

	public Player searchForPlayerById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Player foundItem =  em.find(Player.class, idToEdit);
		em.close();
		return foundItem; 
	}
}
