package br.com.wagnercarestini.financas.jpa;

import javax.persistence.EntityManager;

import br.com.wagnercarestini.financas.modelo.Conta;
import br.com.wagnercarestini.financas.util.JPAUtil;

public class TesteBuscaConta {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);

//		em.remove(conta);
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		
		
	}

}
