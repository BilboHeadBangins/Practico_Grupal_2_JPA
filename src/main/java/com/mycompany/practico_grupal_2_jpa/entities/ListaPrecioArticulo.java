
package com.mycompany.practico_grupal_2_jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author italo
 */
@Entity
@Table (name="lista_precio_articulo")
public class ListaPrecioArticulo extends AuditoriaApp{
    @ManyToOne
    @JoinColumn(name="lista_precio", nullable = false)
    private ListaPrecio listaPrecio;
    @Column(name="precio_venta", nullable = false)
    private double precioVenta;
    @ManyToOne
    @JoinColumn(name="articulo", nullable = false)
    private Articulo articulo;
}
