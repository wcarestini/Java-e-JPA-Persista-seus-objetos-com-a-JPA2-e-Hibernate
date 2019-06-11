package br.com.wagnercarestini.financas.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.wagnercarestini.financas.modelo.Categoria;
import br.com.wagnercarestini.financas.modelo.Movimentacao;
import br.com.wagnercarestini.financas.modelo.TipoMovimentacao;
import br.com.wagnercarestini.financas.util.JPAUtil;

public class TesteMovimentacaoPorCategoria {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		String jpql = "select m from Movimentacao m join m.categoria c where c = :pCategoria";
		
		Query query = em.createQuery(jpql);
		query.setParameter("pCategoria", categoria);
		
		List<Movimentacao> results = query.getResultList();
		
		for(Movimentacao m : results){
			System.out.println("Descrição " + m.getDescricao());
			System.out.println("Conta id " + m.getConta().getId());
		}
		
		em.getTransaction().commit();
		em.close();
		
	}
	
}
