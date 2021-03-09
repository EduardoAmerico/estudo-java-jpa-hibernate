package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraSaldoJao {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        Conta contaJao = em.find(Conta.class, 1L);

        em.getTransaction().begin();
        contaJao.setSaldo(10.0);
        em.getTransaction().commit();
    }
}
