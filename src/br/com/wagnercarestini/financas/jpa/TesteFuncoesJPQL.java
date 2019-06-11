package br.com.wagnercarestini.financas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wagnercarestini.financas.dao.MovimentacaoDao;
import br.com.wagnercarestini.financas.modelo.Conta;
import br.com.wagnercarestini.financas.modelo.TipoMovimentacao;
import br.com.wagnercarestini.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		TypedQuery<Double> typedQuery = em.createNamedQuery("MediasPorDiaETipo", Double.class);
		
		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		
		MovimentacaoDao dao = new MovimentacaoDao(em);
		List<Double> media = typedQuery.getResultList();
		
		for(Double m : media){
			System.out.println("A media � " + media);
		}
		em.getTransaction().commit();
		
	}
	
}
