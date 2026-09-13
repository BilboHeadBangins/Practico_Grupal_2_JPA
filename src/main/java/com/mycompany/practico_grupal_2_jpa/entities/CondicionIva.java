
package com.mycompany.practico_grupal_2_jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author italo
 */

@Entity
@Table (name = "condicion_iva")
public class CondicionIva extends AuditoriaApp{
    @Column(nullable = false)
    private int codigoAfip;
    @Column(nullable = false)
    private String denominacion;
}
