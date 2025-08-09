/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package za.ac.tut.ejb.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MzWandile
 */
@Entity
@Table(catalog = "", schema = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByAgentid", query = "SELECT u FROM Users u WHERE u.agentid = :agentid")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(nullable = false, length = 25)
    private String agentid;
    @OneToMany(mappedBy = "agentidFk")
    private List<Encryptedmesaages> encryptedmesaagesList;

    public Users() {
    }

    public Users(String agentid) {
        this.agentid = agentid;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    @XmlTransient
    public List<Encryptedmesaages> getEncryptedmesaagesList() {
        return encryptedmesaagesList;
    }

    public void setEncryptedmesaagesList(List<Encryptedmesaages> encryptedmesaagesList) {
        this.encryptedmesaagesList = encryptedmesaagesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (agentid != null ? agentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.agentid == null && other.agentid != null) || (this.agentid != null && !this.agentid.equals(other.agentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.ejb.model.Users[ agentid=" + agentid + " ]";
    }

}