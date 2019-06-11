package br.com.wagnercarestini.financas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.wagnercarestini.financas.modelo.Conta;
import br.com.wagnercarestini.financas.modelo.Movimentacao;
import br.com.wagnercarestini.financas.modelo.TipoMovimentacao;
import br.com.wagnercarestini.financas.util.JPAUtil;

public class TesteJPQL {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta" + 
		" and m.tipo = :pTipo" +
		" order by m.valor desc";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.ENTRADA);
		
		
		List<Movimentacao> results = query.getResultList();
		
		for(Movimentacao m : results){
			System.out.println("Descrição " + m.getDescricao());
			System.out.println("Conta id " + m.getConta().getId());
		}
		
		em.getTransaction().commit();
		em.close();
		
	}
	
}
