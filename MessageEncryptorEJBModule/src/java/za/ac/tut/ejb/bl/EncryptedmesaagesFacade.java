/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.ejb.bl;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import za.ac.tut.ejb.model.Encryptedmesaages;
import za.ac.tut.ejb.model.Users;

/**
 *
 * @author MzWandile
 */
@Stateless
public class EncryptedmesaagesFacade extends AbstractFacade<Encryptedmesaages> implements EncryptedmesaagesFacadeLocal {

    @PersistenceContext(unitName = "MessageEncryptorEJBModulePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncryptedmesaagesFacade() {
        super(Encryptedmesaages.class);
    }

    @RolesAllowed("manager")
    @Override
    public String ViewBestPerformingFieldAgent() {
        String jpql = "SELECT e.agentidFk.agentid, COUNT(e.agentidFk) " +
                      "FROM Encryptedmesaages e " +
                      "GROUP BY e.agentidFk.agentid " +
                      "ORDER BY COUNT(e.agentidFk) DESC";

        Query query = em.createQuery(jpql);
        query.setMaxResults(1);

        Object[] result = (Object[]) query.getSingleResult();
        String bestPerformingAgent = "Agent ID: " + result[0] + ", Total Messages Sent: " + result[1];
        return bestPerformingAgent;
    }


}