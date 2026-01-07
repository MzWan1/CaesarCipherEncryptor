/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.ejb.bl;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import za.ac.tut.ejb.model.Encryptedmessages;

/**
 *
 * @author MzWandile
 */
@Stateless
public class EncryptedmessagesFacade extends AbstractFacade<Encryptedmessages> implements EncryptedmessagesFacadeLocal {

    @PersistenceContext(unitName = "MessageEncryptorEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncryptedmessagesFacade() {
        super(Encryptedmessages.class);
    }

    @RolesAllowed("manager")
    @Override
    public String ViewBestPerformingFieldAgent() {
        String jpql = "SELECT e.agentidFk.agentid, COUNT(e.agentidFk) " +
                      "FROM Encryptedmessages e " +
                      "GROUP BY e.agentidFk.agentid " +
                      "ORDER BY COUNT(e.agentidFk) DESC";

        Query query = em.createQuery(jpql);
        query.setMaxResults(1);

        Object[] result = (Object[]) query.getSingleResult();
        String bestPerformingAgent = "Agent ID: " + result[0] + ", Total Messages Sent: " + result[1];
        return bestPerformingAgent;
    }


}