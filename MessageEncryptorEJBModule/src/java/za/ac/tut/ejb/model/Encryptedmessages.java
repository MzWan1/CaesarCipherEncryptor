/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.ejb.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MzWandile
 */
@Entity
@Table(catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Encryptedmessages.findAll", query = "SELECT e FROM Encryptedmessages e")
    , @NamedQuery(name = "Encryptedmessages.findByCyphertextid", query = "SELECT e FROM Encryptedmessages e WHERE e.cyphertextid = :cyphertextid")
    , @NamedQuery(name = "Encryptedmessages.findByCyphertext", query = "SELECT e FROM Encryptedmessages e WHERE e.cyphertext = :cyphertext")
    , @NamedQuery(name = "Encryptedmessages.findByDatecreated", query = "SELECT e FROM Encryptedmessages e WHERE e.datecreated = :datecreated")})
public class Encryptedmessages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer cyphertextid;
    @Size(max = 300)
    @Column(length = 300)
    private String cyphertext;
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @JoinColumn(name = "AGENTID_FK", referencedColumnName = "AGENTID")
    @ManyToOne
    private Users agentidFk;

    public Encryptedmessages() {
    }

    public Encryptedmessages(String cyphertext) {
        this.cyphertext = cyphertext;
    }
    
    public Encryptedmessages(String cyphertext, Date datecreated, Users agentidFk) {
        this.cyphertext = cyphertext;
        this.datecreated = datecreated;
        this.agentidFk = agentidFk;
    }
    
    public Encryptedmessages(Integer cyphertextid) {
        this.cyphertextid = cyphertextid;
    }

    public Integer getCyphertextid() {
        return cyphertextid;
    }

    public void setCyphertextid(Integer cyphertextid) {
        this.cyphertextid = cyphertextid;
    }

    public String getCyphertext() {
        return cyphertext;
    }

    public void setCyphertext(String cyphertext) {
        this.cyphertext = cyphertext;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public Users getAgentidFk() {
        return agentidFk;
    }

    public void setAgentidFk(Users agentidFk) {
        this.agentidFk = agentidFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cyphertextid != null ? cyphertextid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Encryptedmessages other = (Encryptedmessages) object;
        // If either id is null, treat as not equal (transient entities)
        if (this.cyphertextid == null || other.cyphertextid == null) {
            return false;
        }
        return this.cyphertextid.equals(other.cyphertextid);
    }

    @Override
    public String toString() {
        return "za.ac.tut.ejb.model.Encryptedmessages[ cyphertextid=" + cyphertextid + " ]";
    }

}