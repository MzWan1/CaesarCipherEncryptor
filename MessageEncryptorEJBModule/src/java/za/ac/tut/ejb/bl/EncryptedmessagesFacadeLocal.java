/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.ejb.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.ejb.model.Encryptedmessages;

/**
 *
 * @author nkamb
 */
@Local
public interface EncryptedmessagesFacadeLocal {

    void create(Encryptedmessages encryptedmessages);

    void edit(Encryptedmessages encryptedmessages);

    void remove(Encryptedmessages encryptedmessages);

    Encryptedmessages find(Object id);

    List<Encryptedmessages> findAll();

    List<Encryptedmessages> findRange(int[] range);

    int count();
    
    String ViewBestPerformingFieldAgent();
    
}