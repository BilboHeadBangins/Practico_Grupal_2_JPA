
package com.mycompany.practico_grupal_2_jpa.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author italo
 */
@Entity
@Table(name = "factura_venta")
public class FacturaVenta extends EntityId{
    private Long numero;
    @Column(name="fecha_emision",nullable = false)
    private Date fechaEmision;
    @ManyToOne
    @JoinColumn(name="cliente", nullable = true)
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name="condicion_iva", nullable=false)
    private CondicionIva condicionIva;
    @ManyToOne
    @JoinColumn(name="tipo_moneda", nullable=false)
    private TipoMoneda tipoMoneda;
    @ManyToOne
    @JoinColumn(name="punto_venta", nullable=false)
    private PuntoVenta puntoVenta;

    private double importeCobrado;
    private double importeSaldo;

    @Column(name="importe_total", nullable = false)
    private double importeTotal;
    private String cae;
    private Date caeFechaVencimiento;
    private String resultadoAfip;
    private String motivoRechazo;

    @Column(name = "estado", nullable = false)
    private String estado;
    private Date fechaAnulacion;
    private String observaciones;
    
    @OneToMany(mappedBy="factura", cascade=CascadeType.ALL) 
    private List<FacturaVentaDetalle> detalles;
    
}
