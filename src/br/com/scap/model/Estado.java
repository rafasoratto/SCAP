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
@Table(name = "estado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
    @NamedQuery(name = "Estado.findByIEstado", query = "SELECT e FROM Estado e WHERE e.iEstado = :iEstado"),
    @NamedQuery(name = "Estado.findByNome", query = "SELECT e FROM Estado e WHERE e.nome = :nome")})
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "i_estado")
    private Integer iEstado;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "iEstado")
    private Collection<Fornecedores> fornecedoresCollection;

    public Estado() {
    }

    public Estado(Integer iEstado) {
        this.iEstado = iEstado;
    }

    public Estado(Integer iEstado, String nome) {
        this.iEstado = iEstado;
        this.nome = nome;
    }

    public Integer getIEstado() {
        return iEstado;
    }

    public void setIEstado(Integer iEstado) {
        this.iEstado = iEstado;
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
        hash += (iEstado != null ? iEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.iEstado == null && other.iEstado != null) || (this.iEstado != null && !this.iEstado.equals(other.iEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scap.model.Estado[ iEstado=" + iEstado + " ]";
    }
    
}
