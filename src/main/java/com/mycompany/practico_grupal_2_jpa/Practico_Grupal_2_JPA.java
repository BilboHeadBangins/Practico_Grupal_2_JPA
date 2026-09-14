package com.mycompany.practico_grupal_2_jpa;

import com.mycompany.practico_grupal_2_jpa.entities.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author italo
 */
public class Practico_Grupal_2_JPA {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("FacturacionPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();
            
            Usuario usuario1 = new Usuario("juanperez89sysadmin", "contranocifrada", "Juan", "Pérez");
            Usuario usuario2 = new Usuario("mariosantana008", "contranocifrada2", "Mario", "Santana");
            
            Contacto contactoc1=new Contacto("alexarce9@outlook.es","4041963","2917879898");
            Domicilio domicilioc1=new Domicilio("San Martín", "566");
            
            //requiere auditoria
            Cliente cliente1 = new Cliente("80467689992", "Alex Arce", contactoc1, domicilioc1);
            cliente1.setFechaAlta(LocalDateTime.now().minusHours(2));
            cliente1.setUsuarioCarga(usuario1);
            
            //requiere auditoria
            CondicionIva civa1 = new CondicionIva(8086,"Responsable inscripto");
            civa1.setFechaAlta(LocalDateTime.now().minusMinutes(5));
            civa1.setUsuarioCarga(usuario1);
            
            
            //requiere auditoria
            TipoMoneda tipomoneda1 = new TipoMoneda("000", "Pesos Argentinos", "ARS");
            tipomoneda1.setFechaAlta(LocalDateTime.now().minusYears(1));
            tipomoneda1.setUsuarioCarga(usuario1);
            
            //requiere auditoria
            PuntoVenta pdv1 = new PuntoVenta(200,"Carrefour Minimarket","RECE", "Av. Los Reyunos 844");
            pdv1.setFechaAlta(LocalDateTime.now().minusHours(24));
            pdv1.setUsuarioCarga(usuario1);
    
            ListaPrecio lp1 = new ListaPrecio("1003", "20000");
            ListaPrecio lp2 = new ListaPrecio("1004", "30000");
            
            Rubro rubro1 = new Rubro("Entretenimiento",302);
            Marca marca1 = new Marca("TrekkingMaster",201);
            Articulo articulo1 = new Articulo(rubro1,"1003","Bicicleta rodado 20",marca1);
            Articulo articulo2 = new Articulo(rubro1,"1004","Bicicleta rodado 23",marca1);
            
            //requiere auditoria
            ListaPrecioArticulo lpa1 = new ListaPrecioArticulo(lp1,20000.0,articulo1);
            //requiere auditoria
            ListaPrecioArticulo lpa2 = new ListaPrecioArticulo(lp1,30000.0,articulo2);
            
            em.persist(usuario1);
            em.persist(usuario2); 
            
            em.persist(contactoc1);
            em.persist(domicilioc1);
            em.persist(cliente1);
            
            em.persist(civa1);
            em.persist(tipomoneda1);
            em.persist(pdv1);
            
            em.persist(lp1);
            em.persist(lp2);
            
            em.persist(rubro1);
            em.persist(marca1);
            em.persist(articulo1);
            em.persist(articulo2);
            
            em.persist(lpa1);
            em.persist(lpa2);
            
            FacturaVenta facturaventa1 = new FacturaVenta(Long.valueOf("935"),LocalDate.now(),cliente1,civa1,
                    tipomoneda1, pdv1, 50000.0, 500000.0, 50152.5, "2040322012", LocalDate.now().plusDays(10),
                    "Aprobada", " ", "Aprobada", null, " ");
            
            
            FacturaVentaDetalle detallefv1 = new FacturaVentaDetalle(facturaventa1,lpa1,"compra realizada en : Carrefour",1.0,
            20000.0,0.0,20000.0,56.0,20056);
            FacturaVentaDetalle detallefv2 = new FacturaVentaDetalle(facturaventa1,lpa2,"compra realizada en : Carrefour",1.0,
            30000.0,0.0,30000.0,96.5,30096.5);

            
            facturaventa1.getDetalles().add(detallefv1);
            facturaventa1.getDetalles().add(detallefv2);
            
            em.persist(facturaventa1);
            
            em.getTransaction().commit();
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
