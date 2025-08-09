/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.ejb.bl;

import java.util.List;
import javax.ejb.Local;
import za.ac.tut.ejb.model.Encryptedmesaages;

/**
 *
 * @author nkamb
 */
@Local
public interface EncryptedmesaagesFacadeLocal {

    void create(Encryptedmesaages encryptedmesaages);

    void edit(Encryptedmesaages encryptedmesaages);

    void remove(Encryptedmesaages encryptedmesaages);

    Encryptedmesaages find(Object id);

    List<Encryptedmesaages> findAll();

    List<Encryptedmesaages> findRange(int[] range);

    int count();
    
    String ViewBestPerformingFieldAgent();
    
}
