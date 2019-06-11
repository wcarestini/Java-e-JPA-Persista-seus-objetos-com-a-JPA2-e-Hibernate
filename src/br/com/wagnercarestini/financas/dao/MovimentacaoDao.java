package br.com.wagnercarestini.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.wagnercarestini.financas.modelo.Conta;
import br.com.wagnercarestini.financas.modelo.TipoMovimentacao;
import br.com.wagnercarestini.financas.util.JPAUtil;

public class MovimentacaoDao {

	
	private EntityManager em;
	
	public MovimentacaoDao(EntityManager em) {
		this.em = em;		
	}

	public List<Double> getMediasPorDiaETipo(TipoMovimentacao saida, Conta conta) {
		
		String jpql = "SELECT avg(m.valor) FROM Movimentacao m WHERE m.conta = :pConta" + 
				" and m.tipo = :pTipo" + 
						" group by day(m.data), month(m.data), year(m.data)";
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		return query.getResultList();
	}

}
