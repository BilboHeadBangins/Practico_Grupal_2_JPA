
package com.mycompany.practico_grupal_2_jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author italo
 */
@Entity
@Table (name="articulo")
public class Articulo extends AuditoriaApp {
    @ManyToOne
    private Rubro rubro;
    @Column(nullable = false)
    private String codigo;
    @Column(nullable = false)
    private String denominacion;
    @ManyToOne
    private Marca marca;
}
