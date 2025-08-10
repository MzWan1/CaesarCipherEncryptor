/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.web.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import za.ac.tut.ejb.bl.UsersFacadeLocal;
import za.ac.tut.ejb.model.Users;
import za.ac.tut.web.exception.NotDigitException;
import za.ac.tut.web.exception.NotEmptyException;
import za.ac.tut.web.exception.NotRequiedLengthException;
import za.ac.tut.web.exception.UserExistException;

@Stateless
public class ValidateAgents implements ValidateAgentInterface {


    @EJB 
    private UsersFacadeLocal ufl;
    
    @Override
    public void validateAgentID(String agentID) throws NotRequiedLengthException, NotDigitException, UserExistException {
        if(agentID == null || agentID.length() != 3) {
            throw new NotRequiedLengthException("The Agent ID should be exactly three digits");
        }
        
        if(!agentID.matches("\\d+")) {
            throw new NotDigitException("The Agent ID should only be digits");
        }
        
        if(isAgentExist(agentID)) {
            throw new UserExistException("The " + agentID + " exists please choose a different user ID");
        }
    }

    @Override
    public void validateMessage(String plaintext) throws NotEmptyException {
        if(plaintext == null || plaintext.trim().isEmpty()) {
            throw new NotEmptyException("The text area must not be empty");
        }
    }
    
    private boolean isAgentExist(String agentID) {
        Users user = ufl.find(agentID);
        return user != null;
    }
}