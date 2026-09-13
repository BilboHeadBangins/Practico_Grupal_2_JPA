
package com.mycompany.practico_grupal_2_jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author italo
 */
@Entity
@Table(name = "tipo_moneda")
public class TipoMoneda extends AuditoriaApp{
    @Column(nullable = false)
    private String codigoAfip;
    @Column(nullable = false)
    private String denominacion;
    @Column(nullable = false)
    private String simbolo;
}
