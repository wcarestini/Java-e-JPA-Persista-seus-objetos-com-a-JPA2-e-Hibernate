package br.com.wagnercarestini.financas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wagnercarestini.financas.modelo.Conta;
import br.com.wagnercarestini.financas.modelo.TipoMovimentacao;
import br.com.wagnercarestini.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		String jpql = "SELECT avg(m.valor) FROM Movimentacao m WHERE m.conta = :pConta" + 
		" and m.tipo = :pTipo" + 
				" group by day(m.data), month(m.data), year(m.data)";
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		List<Double> media = (List<Double>) query.getResultList();
//		for(Double m : media){
			System.out.println("A media é " + media.get(0));
			System.out.println("A media é " + media.get(1));
//		}
		em.getTransaction().commit();
		
	}
	
}
