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
            cliente1.setFechaModificacion(cliente1.getFechaAlta());
            cliente1.setUsuarioCarga(usuario1);
            cliente1.setUsuarioModificacion(usuario1);
            
            //requiere auditoria
            CondicionIva civa1 = new CondicionIva(8086,"Responsable inscripto");
            civa1.setFechaAlta(LocalDateTime.now().minusMinutes(5));
            civa1.setFechaModificacion(civa1.getFechaAlta());
            civa1.setUsuarioCarga(usuario1);
            civa1.setUsuarioModificacion(usuario1);
            
            //requiere auditoria
            TipoMoneda tipomoneda1 = new TipoMoneda("000", "Pesos Argentinos", "ARS");
            tipomoneda1.setFechaAlta(LocalDateTime.now().minusYears(1));
            tipomoneda1.setFechaModificacion(tipomoneda1.getFechaAlta());
            tipomoneda1.setUsuarioCarga(usuario1);
            tipomoneda1.setUsuarioModificacion(usuario1);
            
            //requiere auditoria
            PuntoVenta pdv1 = new PuntoVenta(200,"Carrefour Minimarket","RECE", "Av. Los Reyunos 844");
            pdv1.setFechaAlta(LocalDateTime.now().minusHours(24));
            pdv1.setFechaModificacion(pdv1.getFechaAlta());
            pdv1.setUsuarioCarga(usuario1);
            pdv1.setUsuarioModificacion(usuario1);
            
            //requiere auditoria
            ListaPrecio lp1 = new ListaPrecio("1003", "Lista Minorista");
            lp1.setFechaAlta(LocalDateTime.now().minusHours(24));
            lp1.setFechaModificacion(lp1.getFechaAlta());
            lp1.setUsuarioCarga(usuario1);
            lp1.setUsuarioModificacion(usuario1);
            
            //requiere auditoria
            ListaPrecio lp2 = new ListaPrecio("1004", "Lista Mayorista");
            lp2.setFechaAlta(LocalDateTime.now().minusHours(24));
            lp2.setFechaModificacion(lp2.getFechaAlta());
            lp2.setUsuarioCarga(usuario1);
            lp2.setUsuarioModificacion(usuario1);

            ListaPrecio lp3 = new ListaPrecio("1005", "Lista Promocional");
            lp3.setFechaAlta(LocalDateTime.now().minusHours(24));
            lp3.setFechaModificacion(lp3.getFechaAlta());
            lp3.setUsuarioCarga(usuario1);
            lp3.setUsuarioModificacion(usuario1);
            
            //requiere auditoria
            Rubro rubro1 = new Rubro("Entretenimiento",302);
            rubro1.setFechaAlta(LocalDateTime.now().minusHours(24));
            rubro1.setFechaModificacion(rubro1.getFechaAlta());
            rubro1.setUsuarioCarga(usuario1);
            rubro1.setUsuarioModificacion(usuario1);
            
            //requiere auditoria
            Marca marca1 = new Marca("TrekkingMaster",201);
            marca1.setFechaAlta(LocalDateTime.now().minusHours(24));
            marca1.setFechaModificacion(marca1.getFechaAlta());
            marca1.setUsuarioCarga(usuario1);
            marca1.setUsuarioModificacion(usuario1);
            
            //requiere auditoria
            Articulo articulo1 = new Articulo(rubro1,"1003","Bicicleta rodado 20",marca1);
            articulo1.setFechaAlta(LocalDateTime.now().minusHours(24));
            articulo1.setFechaModificacion(articulo1.getFechaAlta());
            articulo1.setUsuarioCarga(usuario1);
            articulo1.setUsuarioModificacion(usuario1);
            
            //requiere auditoria
            Articulo articulo2 = new Articulo(rubro1,"1004","Bicicleta rodado 23",marca1);
            articulo2.setFechaAlta(LocalDateTime.now().minusHours(24));
            articulo2.setFechaModificacion(articulo2.getFechaAlta());
            articulo2.setUsuarioCarga(usuario1);
            articulo2.setUsuarioModificacion(usuario1);
            
            //requiere auditoria
            ListaPrecioArticulo lpa1 = new ListaPrecioArticulo(lp1,20000.0,articulo1);
            lpa1.setFechaAlta(LocalDateTime.now().minusHours(24));
            lpa1.setFechaModificacion(lpa1.getFechaAlta());
            lpa1.setUsuarioCarga(usuario1);
            lpa1.setUsuarioModificacion(usuario1);
            
            //requiere auditoria
            ListaPrecioArticulo lpa2 = new ListaPrecioArticulo(lp1,30000.0,articulo2);
            lpa2.setFechaAlta(LocalDateTime.now().minusHours(24));
            lpa2.setFechaModificacion(lpa1.getFechaAlta());
            lpa2.setUsuarioCarga(usuario1);
            lpa2.setUsuarioModificacion(usuario1);
            
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
            
            //REQUIERE AUDITORIA!!
            FacturaVenta facturaventa1 = new FacturaVenta(Long.valueOf("935"),LocalDate.now(),
                    pdv1, 50000.0, 500000.0, 50152.5, "2040322012", LocalDate.now().plusDays(10),
                    "Aprobada", " ", "Aprobada", null, " ");
            facturaventa1.setFechaAlta(LocalDateTime.now());
            facturaventa1.setFechaModificacion(lpa1.getFechaAlta());
            facturaventa1.setUsuarioCarga(usuario1);
            facturaventa1.setUsuarioModificacion(usuario1);
            
            FacturaVentaDetalle detallefv1 = new FacturaVentaDetalle(facturaventa1,lpa1,"compra realizada en : Carrefour",1.0,
            20000.0,0.0,20000.0,56.0,20056);
            FacturaVentaDetalle detallefv2 = new FacturaVentaDetalle(facturaventa1,lpa2,"compra realizada en : Carrefour",1.0,
            30000.0,0.0,30000.0,96.5,30096.5);

            
            facturaventa1.getDetalles().add(detallefv1);
            facturaventa1.getDetalles().add(detallefv2);
            
            em.persist(facturaventa1);

            //Insertando más datos - 2:
            
            Usuario usuario3 = new Usuario("lauragomez77admin", "otraclave123", "Laura", "Gómez");
            Usuario usuario4 = new Usuario("fedecastro21", "clavesegura456", "Federico", "Castro");
            em.persist(usuario3);
            em.persist(usuario4);
            
            //requiere auditoria
            Contacto contactoc2 = new Contacto("laura.molina@gmail.com", "4155621", "2612345678");
            Domicilio domicilioc2 = new Domicilio("Belgrano", "1204");
            Cliente cliente2 = new Cliente("27334455661", "Laura Molina", contactoc2, domicilioc2);
            cliente2.setFechaAlta(LocalDateTime.now().minusDays(3));
            cliente2.setFechaModificacion(cliente2.getFechaAlta());
            cliente2.setUsuarioCarga(usuario3);
            cliente2.setUsuarioModificacion(usuario3);

            Contacto contactoc3 = new Contacto("nico.perez@hotmail.com", "4287733", "2617778899");
            Domicilio domicilioc3 = new Domicilio("Rivadavia", "980");
            Cliente cliente3 = new Cliente("20398765432", "Nicolás Pérez", contactoc3, domicilioc3);
            cliente3.setFechaAlta(LocalDateTime.now().minusDays(1));
            cliente3.setFechaModificacion(cliente3.getFechaAlta());
            cliente3.setUsuarioCarga(usuario3);
            cliente3.setUsuarioModificacion(usuario3);

            CondicionIva civa2 = new CondicionIva(8087, "Monotributista");
            civa2.setFechaAlta(LocalDateTime.now().minusMinutes(20));
            civa2.setFechaModificacion(civa2.getFechaAlta());
            civa2.setUsuarioCarga(usuario3);
            civa2.setUsuarioModificacion(usuario3);
            
            TipoMoneda tipomoneda2 = new TipoMoneda("001", "Dólares Estadounidenses", "USD");
            tipomoneda2.setFechaAlta(LocalDateTime.now().minusYears(1));
            tipomoneda2.setFechaModificacion(tipomoneda2.getFechaAlta());
            tipomoneda2.setUsuarioCarga(usuario4);
            tipomoneda2.setUsuarioModificacion(usuario4);

            PuntoVenta pdv2 = new PuntoVenta(201, "Carrefour Express Centro", "RECE", "Av. San Martín 1580");
            pdv2.setFechaAlta(LocalDateTime.now().minusHours(48));
            pdv2.setFechaModificacion(pdv2.getFechaAlta());
            pdv2.setUsuarioCarga(usuario3);
            pdv2.setUsuarioModificacion(usuario3);

            Rubro rubro2 = new Rubro("Deportes", 303);
            rubro2.setFechaAlta(LocalDateTime.now().minusHours(20));
            rubro2.setFechaModificacion(rubro2.getFechaAlta());
            rubro2.setUsuarioCarga(usuario3);
            rubro2.setUsuarioModificacion(usuario3);
            
            Marca marca2 = new Marca("MountainPro", 202);
            marca2.setFechaAlta(LocalDateTime.now().minusHours(20));
            marca2.setFechaModificacion(marca2.getFechaAlta());
            marca2.setUsuarioCarga(usuario4);
            marca2.setUsuarioModificacion(usuario4);

            Articulo articulo3 = new Articulo(rubro2, "1005", "Casco de ciclismo", marca2);
            articulo3.setFechaAlta(LocalDateTime.now().minusHours(18));
            articulo3.setFechaModificacion(articulo3.getFechaAlta());
            articulo3.setUsuarioCarga(usuario4);
            articulo3.setUsuarioModificacion(usuario4);
            
            Articulo articulo4 = new Articulo(rubro2, "1006", "Guantes de trekking", marca2);
            articulo4.setFechaAlta(LocalDateTime.now().minusHours(18));
            articulo4.setFechaModificacion(articulo4.getFechaAlta());
            articulo4.setUsuarioCarga(usuario4);
            articulo4.setUsuarioModificacion(usuario4);

            ListaPrecioArticulo lpa3 = new ListaPrecioArticulo(lp3, 15000.0, articulo3);
            lpa3.setFechaAlta(LocalDateTime.now().minusHours(18));
            lpa3.setFechaModificacion(lpa3.getFechaAlta());
            lpa3.setUsuarioCarga(usuario4);
            lpa3.setUsuarioModificacion(usuario4);
            
            ListaPrecioArticulo lpa4 = new ListaPrecioArticulo(lp3, 8000.0, articulo4);
            lpa4.setFechaAlta(LocalDateTime.now().minusHours(18));
            lpa4.setFechaModificacion(lpa4.getFechaAlta());
            lpa4.setUsuarioCarga(usuario4);
            lpa4.setUsuarioModificacion(usuario4);

            em.persist(contactoc2);
            em.persist(domicilioc2);
            em.persist(cliente2);

            em.persist(contactoc3);
            em.persist(domicilioc3);
            em.persist(cliente3);

            em.persist(civa2);
            em.persist(tipomoneda2);
            em.persist(pdv2);

            em.persist(lp3);

            em.persist(rubro2);
            em.persist(marca2);
            em.persist(articulo3);
            em.persist(articulo4);

            em.persist(lpa3);
            em.persist(lpa4);

            
            FacturaVenta facturaventa2 = new FacturaVenta(Long.valueOf("936"), LocalDate.now(),
                pdv2, 23000.0, 230000.0, 24000.5, "2040322013", LocalDate.now().plusDays(15),
                "Aprobada", " ", "Aprobada", null, " ");
            facturaventa2.setFechaAlta(LocalDateTime.now());
            facturaventa2.setFechaModificacion(facturaventa2.getFechaAlta());
            facturaventa2.setUsuarioCarga(usuario3);
            facturaventa2.setUsuarioModificacion(usuario3);

            FacturaVentaDetalle detallefv3 = new FacturaVentaDetalle(facturaventa2, lpa3,
                    "compra realizada en : Carrefour Express Centro", 1.0,
                    15000.0, 0.0, 15000.0, 42.0, 15042.0);
            FacturaVentaDetalle detallefv4 = new FacturaVentaDetalle(facturaventa2, lpa4,
                    "compra realizada en : Carrefour Express Centro", 2.0,
                    8000.0, 0.0, 16000.0, 22.5, 16022.5);

            facturaventa2.getDetalles().add(detallefv3);
            facturaventa2.getDetalles().add(detallefv4);

            em.persist(facturaventa2);
            
            //más datos, para validar consultas - 3
            Articulo articulo5 = new Articulo(rubro2, "1007", "Zapatillas trail running", marca2);
            articulo5.setFechaAlta(LocalDateTime.now().minusHours(15));
            articulo5.setFechaModificacion(articulo5.getFechaAlta());
            articulo5.setUsuarioCarga(usuario1);
            articulo5.setUsuarioModificacion(usuario1);

            Articulo articulo6 = new Articulo(rubro1, "1008", "Bicicleta rodado 26", marca1);
            articulo6.setFechaAlta(LocalDateTime.now().minusHours(15));
            articulo6.setFechaModificacion(articulo6.getFechaAlta());
            articulo6.setUsuarioCarga(usuario1);
            articulo6.setUsuarioModificacion(usuario1);

            Articulo articulo7 = new Articulo(rubro2, "1009", "Mochila de trekking 40L", marca2);
            articulo7.setFechaAlta(LocalDateTime.now().minusHours(10));
            articulo7.setFechaModificacion(articulo7.getFechaAlta());
            articulo7.setUsuarioCarga(usuario2);
            articulo7.setUsuarioModificacion(usuario2);

            Articulo articulo8 = new Articulo(rubro1, "1010", "Luces LED para bicicleta", marca1);
            articulo8.setFechaAlta(LocalDateTime.now().minusHours(10));
            articulo8.setFechaModificacion(articulo8.getFechaAlta());
            articulo8.setUsuarioCarga(usuario2);
            articulo8.setUsuarioModificacion(usuario2);

            ListaPrecioArticulo lpa3 = new ListaPrecioArticulo(lp3, 15000.0, articulo3);
            lpa3.setFechaAlta(LocalDateTime.now().minusHours(18));
            lpa3.setFechaModificacion(lpa3.getFechaAlta());
            lpa3.setUsuarioCarga(usuario2);
            lpa3.setUsuarioModificacion(usuario2);

            ListaPrecioArticulo lpa4 = new ListaPrecioArticulo(lp3, 8000.0, articulo4);
            lpa4.setFechaAlta(LocalDateTime.now().minusHours(18));
            lpa4.setFechaModificacion(lpa4.getFechaAlta());
            lpa4.setUsuarioCarga(usuario2);
            lpa4.setUsuarioModificacion(usuario2);

            ListaPrecioArticulo lpa5 = new ListaPrecioArticulo(lp2, 60000.0, articulo5);
            lpa5.setFechaAlta(LocalDateTime.now().minusHours(15));
            lpa5.setFechaModificacion(lpa5.getFechaAlta());
            lpa5.setUsuarioCarga(usuario1);
            lpa5.setUsuarioModificacion(usuario1);
        
            ListaPrecioArticulo lpa6 = new ListaPrecioArticulo(lp1, 35000.0, articulo6);
            lpa6.setFechaAlta(LocalDateTime.now().minusHours(15));
            lpa6.setFechaModificacion(lpa6.getFechaAlta());
            lpa6.setUsuarioCarga(usuario1);
            lpa6.setUsuarioModificacion(usuario1);
    
            ListaPrecioArticulo lpa7 = new ListaPrecioArticulo(lp3, 22000.0, articulo7);
            lpa7.setFechaAlta(LocalDateTime.now().minusHours(10));
            lpa7.setFechaModificacion(lpa7.getFechaAlta());
            lpa7.setUsuarioCarga(usuario2);
            lpa7.setUsuarioModificacion(usuario2);
    
            ListaPrecioArticulo lpa8 = new ListaPrecioArticulo(lp2, 5000.0, articulo8);
            lpa8.setFechaAlta(LocalDateTime.now().minusHours(10));
            lpa8.setFechaModificacion(lpa8.getFechaAlta());
            lpa8.setUsuarioCarga(usuario2);
            lpa8.setUsuarioModificacion(usuario2);
            
            em.persist(articulo5);
            em.persist(articulo6);
            em.persist(articulo7);
            em.persist(articulo8);
     
            em.persist(lpa3);
            em.persist(lpa4);
            em.persist(lpa5);
            em.persist(lpa6);
            em.persist(lpa7);
            em.persist(lpa8);

            //Facturas extra
            FacturaVenta facturaventa2 = new FacturaVenta(Long.valueOf("936"), LocalDate.now(),
                pdv2, 23000.0, 230000.0, 24000.5, "2040322013", LocalDate.now().plusDays(15),
                "Aprobada", " ", "Aprobada", null, " ");
            facturaventa2.setFechaAlta(LocalDateTime.now());
            facturaventa2.setFechaModificacion(facturaventa2.getFechaAlta());
            facturaventa2.setUsuarioCarga(usuario2);
            facturaventa2.setUsuarioModificacion(usuario2);
     
            FacturaVentaDetalle detallefv3 = new FacturaVentaDetalle(facturaventa2, lpa3,
                    "compra realizada en : Carrefour Express Centro", 1.0,
                    15000.0, 0.0, 15000.0, 42.0, 15042.0);
            FacturaVentaDetalle detallefv4 = new FacturaVentaDetalle(facturaventa2, lpa4,
                    "compra realizada en : Carrefour Express Centro", 2.0,
                    8000.0, 0.0, 16000.0, 22.5, 16022.5);
     
            facturaventa2.getDetalles().add(detallefv3);
            facturaventa2.getDetalles().add(detallefv4);
            em.persist(facturaventa2);

            FacturaVenta facturaventa3 = new FacturaVenta(Long.valueOf("937"), LocalDate.now().minusDays(1),
                pdv1, 60000.0, 600000.0, 66000.0, "2040322014", LocalDate.now().plusDays(20),
                "Aprobada", " ", "Aprobada", null, " ");
            facturaventa3.setFechaAlta(LocalDateTime.now().minusDays(1));
            facturaventa3.setFechaModificacion(facturaventa3.getFechaAlta());
            facturaventa3.setUsuarioCarga(usuario1);
            facturaventa3.setUsuarioModificacion(usuario1);
     
            FacturaVentaDetalle detallefv5 = new FacturaVentaDetalle(facturaventa3, lpa5,
                    "compra realizada en : Carrefour Minimarket", 1.0,
                    60000.0, 0.0, 60000.0, 168.0, 60168.0);
     
            facturaventa3.getDetalles().add(detallefv5);
            em.persist(facturaventa3);

            FacturaVenta facturaventa4 = new FacturaVenta(Long.valueOf("938"), LocalDate.now().minusDays(2),
                pdv2, 35000.0, 350000.0, 38500.0, "2040322015", LocalDate.now().plusDays(10),
                "Pendiente", " ", "Pendiente", null, " ");
            facturaventa4.setFechaAlta(LocalDateTime.now().minusDays(2));
            facturaventa4.setFechaModificacion(facturaventa4.getFechaAlta());
            facturaventa4.setUsuarioCarga(usuario2);
            facturaventa4.setUsuarioModificacion(usuario2);
     
            FacturaVentaDetalle detallefv6 = new FacturaVentaDetalle(facturaventa4, lpa6,
                    "compra realizada en : Carrefour Express Centro", 1.0,
                    35000.0, 0.0, 35000.0, 98.0, 35098.0);
     
            facturaventa4.getDetalles().add(detallefv6);
            em.persist(facturaventa4);

            FacturaVenta facturaventa5 = new FacturaVenta(Long.valueOf("939"), LocalDate.now().minusDays(3),
                pdv1, 27000.0, 270000.0, 29700.0, "2040322016", LocalDate.now().plusDays(12),
                "Aprobada", " ", "Aprobada", null, " ");
            facturaventa5.setFechaAlta(LocalDateTime.now().minusDays(3));
            facturaventa5.setFechaModificacion(facturaventa5.getFechaAlta());
            facturaventa5.setUsuarioCarga(usuario1);
            facturaventa5.setUsuarioModificacion(usuario1);
     
            FacturaVentaDetalle detallefv7 = new FacturaVentaDetalle(facturaventa5, lpa7,
                    "compra realizada en : Carrefour Minimarket", 1.0,
                    22000.0, 0.0, 22000.0, 61.6, 22061.6);
            FacturaVentaDetalle detallefv8 = new FacturaVentaDetalle(facturaventa5, lpa8,
                    "compra realizada en : Carrefour Minimarket", 1.0,
                    5000.0, 0.0, 5000.0, 14.0, 5014.0);
     
            facturaventa5.getDetalles().add(detallefv7);
            facturaventa5.getDetalles().add(detallefv8);
            em.persist(facturaventa5);

            FacturaVenta facturaventa6 = new FacturaVenta(Long.valueOf("940"), LocalDate.now().minusDays(5),
                pdv2, 44000.0, 440000.0, 48400.0, "2040322017", LocalDate.now().plusDays(18),
                "Anulada", "Cliente canceló la compra", "Anulada", null, " ");
            facturaventa6.setFechaAlta(LocalDateTime.now().minusDays(5));
            facturaventa6.setFechaModificacion(facturaventa6.getFechaAlta());
            facturaventa6.setUsuarioCarga(usuario2);
            facturaventa6.setUsuarioModificacion(usuario2);
     
            FacturaVentaDetalle detallefv9 = new FacturaVentaDetalle(facturaventa6, lpa3,
                    "compra realizada en : Carrefour Express Centro", 2.0,
                    15000.0, 0.0, 30000.0, 84.0, 30084.0);
            FacturaVentaDetalle detallefv10 = new FacturaVentaDetalle(facturaventa6, lpa4,
                    "compra realizada en : Carrefour Express Centro", 1.0,
                    8000.0, 0.0, 8000.0, 22.4, 8022.4);
     
            facturaventa6.getDetalles().add(detallefv9);
            facturaventa6.getDetalles().add(detallefv10);
            em.persist(facturaventa6);

            FacturaVenta facturaventa7 = new FacturaVenta(Long.valueOf("941"), LocalDate.now().minusDays(7),
                pdv1, 82000.0, 820000.0, 90200.0, "2040322018", LocalDate.now().plusDays(30),
                "Aprobada", " ", "Aprobada", null, " ");
            facturaventa7.setFechaAlta(LocalDateTime.now().minusDays(7));
            facturaventa7.setFechaModificacion(facturaventa7.getFechaAlta());
            facturaventa7.setUsuarioCarga(usuario1);
            facturaventa7.setUsuarioModificacion(usuario1);
     
            FacturaVentaDetalle detallefv11 = new FacturaVentaDetalle(facturaventa7, lpa6,
                    "compra realizada en : Carrefour Minimarket", 1.0,
                    35000.0, 0.0, 35000.0, 98.0, 35098.0);
            FacturaVentaDetalle detallefv12 = new FacturaVentaDetalle(facturaventa7, lpa5,
                    "compra realizada en : Carrefour Minimarket", 1.0,
                    60000.0, 5000.0, 55000.0, 154.0, 55154.0);
     
            facturaventa7.getDetalles().add(detallefv11);
            facturaventa7.getDetalles().add(detallefv12);
            em.persist(facturaventa7);

            FacturaVenta facturaventa8 = new FacturaVenta(Long.valueOf("942"), LocalDate.now().minusDays(10),
                pdv2, 19500.0, 195000.0, 21450.0, "2040322019", LocalDate.now().plusDays(9),
                "Pendiente", " ", "Pendiente", null, " ");
            facturaventa8.setFechaAlta(LocalDateTime.now().minusDays(10));
            facturaventa8.setFechaModificacion(facturaventa8.getFechaAlta());
            facturaventa8.setUsuarioCarga(usuario2);
            facturaventa8.setUsuarioModificacion(usuario2);
     
            FacturaVentaDetalle detallefv13 = new FacturaVentaDetalle(facturaventa8, lpa7,
                    "compra realizada en : Carrefour Express Centro", 1.0,
                    22000.0, 2500.0, 19500.0, 54.6, 19554.6);
     
            facturaventa8.getDetalles().add(detallefv13);
            em.persist(facturaventa8);

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
