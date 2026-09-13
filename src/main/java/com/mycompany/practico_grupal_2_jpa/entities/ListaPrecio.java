
package com.mycompany.practico_grupal_2_jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author italo
 */
@Entity
@Table (name="lista_precio")
public class ListaPrecio extends AuditoriaApp {
    @Column(nullable = false)
    private String codigo;
    @Column(nullable = false)
    private String denominacion;
}
