
package com.mycompany.practico_grupal_2_jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author italo
 */
@Entity
@Table (name="domicilio")
public class Domicilio extends EntityId{
    @Column (name="nombre_calle")
    private String nombreCalle;
    @Column (name="numero_calle")
    private String numeroCalle;
}
