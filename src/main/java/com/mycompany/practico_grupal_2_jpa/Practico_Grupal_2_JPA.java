package com.mycompany.practico_grupal_2_jpa;

import com.mycompany.practico_grupal_2_jpa.entities.*;
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
            
            Usuario usuario1 = new Usuario("juanperez89", "contranocifrada", "Juan", "Pérez");
            Usuario usuario2 = new Usuario("mariosantana05", "contranocifrada2", "Mario", "Santana");
            
            em.persist(usuario1);
            em.persist(usuario2); 
            
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
