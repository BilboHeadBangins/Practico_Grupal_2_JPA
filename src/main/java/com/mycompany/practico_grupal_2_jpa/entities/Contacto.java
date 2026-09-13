
package com.mycompany.practico_grupal_2_jpa.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author italo
 */
@Entity
@Table (name = "contacto")
public class Contacto extends EntityId{
    private String email;
    private String telefono;
    private String celular;
}
