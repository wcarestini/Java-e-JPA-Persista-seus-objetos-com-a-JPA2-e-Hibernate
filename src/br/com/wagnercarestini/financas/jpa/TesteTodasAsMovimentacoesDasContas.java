package br.com.wagnercarestini.financas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.wagnercarestini.financas.modelo.Conta;
import br.com.wagnercarestini.financas.util.JPAUtil;

public class TesteTodasAsMovimentacoesDasContas {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		String jpql = "select distinct c from Conta c left join fetch c.movimentacoes";
		
		Query query = em.createQuery(jpql);
		
		List<Conta> todasAsContas = query.getResultList();
		
		for(Conta c : todasAsContas){
			System.out.println("Titular: " + c.getTitular());
			System.out.println("Movimentacoes: ");
			System.out.println(c.getMovimentacoes().toString());
		}
		
	}
	
}
