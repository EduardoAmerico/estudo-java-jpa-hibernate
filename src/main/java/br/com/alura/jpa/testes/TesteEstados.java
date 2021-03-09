package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TesteEstados {
    public static void main(String[] args){
        //nomal
        Conta conta = new Conta();
        conta.setTitular("jão");
        conta.setNumero(1234567890);
        conta.setAgencia(4321);


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //nomal -> sincronizado
        em.persist(conta);

        //sincronizado -> deletado
        em.remove(conta);
        em.getTransaction().commit();
    }
}
