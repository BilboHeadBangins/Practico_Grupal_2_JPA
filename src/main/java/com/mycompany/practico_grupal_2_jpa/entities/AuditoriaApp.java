package com.mycompany.practico_grupal_2_jpa.entities;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author italo
 */

@MappedSuperclass
public abstract class AuditoriaApp extends EntityId{
    @Column(name="fecha_alta",nullable = false)
    protected LocalDateTime fechaAlta;
    @Column(name="fecha_baja",nullable = false)
    protected LocalDateTime fechaBaja;
    @Column(name="fecha_modificacion",nullable = false)
    protected LocalDateTime fechaModificacion;
    @ManyToOne
    @JoinColumn(name = "usuario_alta", nullable=false)
    protected Usuario usuarioCarga;
    @ManyToOne
    @JoinColumn(name = "usuario_baja")
    protected Usuario usuarioBaja;
    @ManyToOne
    @JoinColumn(name = "usuario_modificacion", nullable=false)
    protected Usuario usuarioModificacion;
}
