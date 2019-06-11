package br.com.wagnercarestini.financas.jpa;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.wagnercarestini.financas.modelo.Categoria;
import br.com.wagnercarestini.financas.modelo.Conta;
import br.com.wagnercarestini.financas.modelo.Movimentacao;
import br.com.wagnercarestini.financas.modelo.TipoMovimentacao;
import br.com.wagnercarestini.financas.util.JPAUtil;

public class TesteMovimentacoesComCategoria {

	public static void main(String[] args){
		
		Categoria c1 = new Categoria("Viagem");
		Categoria c2 = new Categoria("negocios");
		
		Conta conta= new Conta();
		conta.setId(2);
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("Viagem á SP");
		movimentacao1.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("100.00"));
		movimentacao1.setCategorias(Arrays.asList(c1, c2));
		movimentacao1.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("Viagem ao RJ");
		movimentacao2.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("300.00"));
		movimentacao2.setCategorias(Arrays.asList(c1, c2));
		movimentacao2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(c1);
		em.persist(c2);
		
		em.persist(movimentacao1);
		em.persist(movimentacao2);
		
		em.getTransaction().commit();
		em.close();
		
		
		
	}
}
