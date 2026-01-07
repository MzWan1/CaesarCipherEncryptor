/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web.service;

import javax.ejb.Local;
import za.ac.tut.web.exception.NotDigitException;
import za.ac.tut.web.exception.NotEmptyException;
import za.ac.tut.web.exception.NotRequiredLengthException;
import za.ac.tut.web.exception.UserExistException;

/**
 *
 * @author nkamb
 */
@Local
public interface ValidateAgentInterface {
    public void validateAgentID(String agentID) throws NotRequiredLengthException, NotDigitException, UserExistException;
    public void validateMessage(String plaintext) throws NotEmptyException;
}
