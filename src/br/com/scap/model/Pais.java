/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scap.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author comp16
 */
@Entity
@Table(name = "pais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
    @NamedQuery(name = "Pais.findByIPais", query = "SELECT p FROM Pais p WHERE p.iPais = :iPais"),
    @NamedQuery(name = "Pais.findByNome", query = "SELECT p FROM Pais p WHERE p.nome = :nome")})
public class Pais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "i_pais")
    private Integer iPais;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "iPais")
    private Collection<Fornecedores> fornecedoresCollection;

    public Pais() {
    }

    public Pais(Integer iPais) {
        this.iPais = iPais;
    }

    public Pais(Integer iPais, String nome) {
        this.iPais = iPais;
        this.nome = nome;
    }

    public Integer getIPais() {
        return iPais;
    }

    public void setIPais(Integer iPais) {
        this.iPais = iPais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Fornecedores> getFornecedoresCollection() {
        return fornecedoresCollection;
    }

    public void setFornecedoresCollection(Collection<Fornecedores> fornecedoresCollection) {
        this.fornecedoresCollection = fornecedoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iPais != null ? iPais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.iPais == null && other.iPais != null) || (this.iPais != null && !this.iPais.equals(other.iPais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scap.model.Pais[ iPais=" + iPais + " ]";
    }
    
}
