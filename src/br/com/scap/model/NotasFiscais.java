/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.scap.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author comp16
 */
@Entity
@Table(name = "notas_fiscais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NotasFiscais.findAll", query = "SELECT n FROM NotasFiscais n"),
    @NamedQuery(name = "NotasFiscais.findByINotas", query = "SELECT n FROM NotasFiscais n WHERE n.iNotas = :iNotas"),
    @NamedQuery(name = "NotasFiscais.findByValor", query = "SELECT n FROM NotasFiscais n WHERE n.valor = :valor"),
    @NamedQuery(name = "NotasFiscais.findByIFornecedores", query = "SELECT n FROM NotasFiscais n WHERE n.iFornecedores = :iFornecedores"),
    @NamedQuery(name = "NotasFiscais.findByFormaPagamento", query = "SELECT n FROM NotasFiscais n WHERE n.formaPagamento = :formaPagamento"),
    @NamedQuery(name = "NotasFiscais.findByQtdParcelas", query = "SELECT n FROM NotasFiscais n WHERE n.qtdParcelas = :qtdParcelas"),
    @NamedQuery(name = "NotasFiscais.findByDataEmissao", query = "SELECT n FROM NotasFiscais n WHERE n.dataEmissao = :dataEmissao")})
public class NotasFiscais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "i_notas")
    private Integer iNotas;
    @Basic(optional = false)
    @Column(name = "valor")
    private double valor;
    @Basic(optional = false)
    @Column(name = "i_fornecedores")
    private int iFornecedores;
    @Basic(optional = false)
    @Column(name = "forma_pagamento")
    private char formaPagamento;
    @Basic(optional = false)
    @Column(name = "qtd_parcelas")
    private int qtdParcelas;
    @Basic(optional = false)
    @Column(name = "data_emissao")
    @Temporal(TemporalType.DATE)
    private Date dataEmissao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iNotas")
    private Collection<Duplicatas> duplicatasCollection;

    public NotasFiscais() {
    }

    public NotasFiscais(Integer iNotas) {
        this.iNotas = iNotas;
    }

    public NotasFiscais(Integer iNotas, double valor, int iFornecedores, char formaPagamento, int qtdParcelas, Date dataEmissao) {
        this.iNotas = iNotas;
        this.valor = valor;
        this.iFornecedores = iFornecedores;
        this.formaPagamento = formaPagamento;
        this.qtdParcelas = qtdParcelas;
        this.dataEmissao = dataEmissao;
    }

    public Integer getINotas() {
        return iNotas;
    }

    public void setINotas(Integer iNotas) {
        this.iNotas = iNotas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getIFornecedores() {
        return iFornecedores;
    }

    public void setIFornecedores(int iFornecedores) {
        this.iFornecedores = iFornecedores;
    }

    public char getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(char formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(Date dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    @XmlTransient
    public Collection<Duplicatas> getDuplicatasCollection() {
        return duplicatasCollection;
    }

    public void setDuplicatasCollection(Collection<Duplicatas> duplicatasCollection) {
        this.duplicatasCollection = duplicatasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iNotas != null ? iNotas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotasFiscais)) {
            return false;
        }
        NotasFiscais other = (NotasFiscais) object;
        if ((this.iNotas == null && other.iNotas != null) || (this.iNotas != null && !this.iNotas.equals(other.iNotas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.scap.model.NotasFiscais[ iNotas=" + iNotas + " ]";
    }
    
}
