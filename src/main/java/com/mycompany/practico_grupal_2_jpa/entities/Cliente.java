package com.mycompany.practico_grupal_2_jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author italo
 */
@Entity
@Table (name="cliente")
public class Cliente extends AuditoriaApp{
    @Column(nullable = false)
    private String cuitCuil;
    @Column(nullable = false)
    private String denominacion;
    @OneToOne
    @JoinColumn(name = "contacto", nullable = false)
    private Contacto contacto;
    @OneToOne
    @JoinColumn(name="domicilio", nullable = false)
    private Domicilio domicilio;  
}
