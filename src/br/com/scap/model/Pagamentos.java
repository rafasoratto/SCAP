/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scap.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author comp16
 */
@Entity
@Table(name = "pagamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamentos.findAll", query = "SELECT p FROM Pagamentos p"),
    @NamedQuery(name = "Pagamentos.findByIPagamentos", query = "SELECT p FROM Pagamentos p WHERE p.iPagamentos = :iPagamentos"),
    @NamedQuery(name = "Pagamentos.findByValor", query = "SELECT p FROM Pagamentos p WHERE p.valor = :valor"),
    @NamedQuery(name = "Pagamentos.findByDataPagamento", query = "SELECT p FROM Pagamentos p WHERE p.dataPagamento = :dataPagamento")})
public class Pagamentos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "i_pagamentos")
    private Integer iPagamentos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor")
    private Double valor;
    @Basic(optional = false)
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @JoinColumn(name = "i_duplicatas", referencedColumnName = "i_duplicatas")
    @ManyToOne(optional = false)
    private Duplicatas iDuplicatas;

    public Pagamentos() {
    }

    public Pagamentos(Integer iPagamentos) {
        this.iPagamentos = iPagamentos;
    }

    public Pagamentos(Integer iPagamentos, Date dataPagamento) {
        this.iPagamentos = iPagamentos;
        this.dataPagamento = dataPagamento;
    }

    public Integer getIPagamentos() {
        return iPagamentos;
    }

    public void setIPagamentos(Integer iPagamentos) {
        this.iPagamentos = iPagamentos;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Duplicatas getIDuplicatas() {
        return iDuplicatas;
    }

    public void setIDuplicatas(Duplicatas iDuplicatas) {
        this.iDuplicatas = iDuplicatas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iPagamentos != null ? iPagamentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamentos)) {
            return false;
        }
        Pagamentos other = (Pagamentos) object;
        if ((this.iPagamentos == null && other.iPagamentos != null) || (this.iPagamentos != null && !this.iPagamentos.equals(other.iPagamentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scap.model.Pagamentos[ iPagamentos=" + iPagamentos + " ]";
    }
    
}
