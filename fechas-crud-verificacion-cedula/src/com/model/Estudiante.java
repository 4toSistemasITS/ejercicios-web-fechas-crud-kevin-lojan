/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@Table(name = "estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiante.findAll", query = "SELECT e FROM Estudiante e")
    , @NamedQuery(name = "Estudiante.findByIdestudiante", query = "SELECT e FROM Estudiante e WHERE e.idestudiante = :idestudiante")
    , @NamedQuery(name = "Estudiante.findByNombre", query = "SELECT e FROM Estudiante e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Estudiante.findByCedula", query = "SELECT e FROM Estudiante e WHERE e.cedula = :cedula")
    , @NamedQuery(name = "Estudiante.findByEliminado", query = "SELECT e FROM Estudiante e WHERE e.eliminado = :eliminado")})
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idestudiante")
    private Integer idestudiante;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "cedula")
    private String cedula;
    @Column(name = "eliminado")
    private Boolean eliminado;
    @JoinColumn(name = "idmateria", referencedColumnName = "idmateria")
    @ManyToOne
    private Materia idmateria;

    public Estudiante(Integer idestudiante, String nombre, String cedula, Materia idmateria) {
        this.idestudiante = idestudiante;
        this.nombre = nombre;
        this.cedula = cedula;
        this.idmateria = idmateria;
    }

    public Estudiante() {
    }
    
    
  
    public Estudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    public Estudiante(String nombre, String cedula, Materia ob1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Integer idestudiante) {
        this.idestudiante = idestudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Materia getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(Materia idmateria) {
        this.idmateria = idmateria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idestudiante != null ? idestudiante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiante)) {
            return false;
        }
        Estudiante other = (Estudiante) object;
        if ((this.idestudiante == null && other.idestudiante != null) || (this.idestudiante != null && !this.idestudiante.equals(other.idestudiante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Estudiante[ idestudiante=" + idestudiante + " ]";
    }
    
}
