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
    @NamedQuery(name = "Encryptedmesaages.findAll", query = "SELECT e FROM Encryptedmesaages e")
    , @NamedQuery(name = "Encryptedmesaages.findByCyphertextid", query = "SELECT e FROM Encryptedmesaages e WHERE e.cyphertextid = :cyphertextid")
    , @NamedQuery(name = "Encryptedmesaages.findByCyphertext", query = "SELECT e FROM Encryptedmesaages e WHERE e.cyphertext = :cyphertext")
    , @NamedQuery(name = "Encryptedmesaages.findByDatecreated", query = "SELECT e FROM Encryptedmesaages e WHERE e.datecreated = :datecreated")})
public class Encryptedmesaages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Encryptedmesaages() {
    }

    public Encryptedmesaages(String cyphertext) {
        this.cyphertext = cyphertext;
    }
    
    public Encryptedmesaages(String cyphertext, Date datecreated, Users agentidFk) {
        this.cyphertext = cyphertext;
        this.datecreated = datecreated;
        this.agentidFk = agentidFk;
    }
    
    public Encryptedmesaages(Integer cyphertextid) {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Encryptedmesaages)) {
            return false;
        }
        Encryptedmesaages other = (Encryptedmesaages) object;
        if ((this.cyphertextid == null && other.cyphertextid != null) || (this.cyphertextid != null && !this.cyphertextid.equals(other.cyphertextid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.ejb.model.Encryptedmesaages[ cyphertextid=" + cyphertextid + " ]";
    }

}