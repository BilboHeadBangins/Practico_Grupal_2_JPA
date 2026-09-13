
package com.mycompany.practico_grupal_2_jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author italo
 */
@Entity
@Table(name="rubro")
public class Rubro extends AuditoriaApp{
    @Column(nullable = false)
    private String denominacion;
    @Column(nullable = false)
    private Integer codigo;
}
