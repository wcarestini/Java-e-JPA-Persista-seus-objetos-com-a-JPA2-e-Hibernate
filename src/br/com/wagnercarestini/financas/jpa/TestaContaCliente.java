package br.com.wagnercarestini.financas.jpa;

import javax.persistence.EntityManager;

import br.com.wagnercarestini.financas.modelo.Cliente;
import br.com.wagnercarestini.financas.modelo.Conta;
import br.com.wagnercarestini.financas.util.JPAUtil;

public class TestaContaCliente {
	
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Leonardo");
		cliente.setEndereco("Rua abc, 123");
		cliente.setProfissao("Professor");
		
		Cliente cliente2 = new Cliente();
		cliente.setNome("Douglas");
		cliente.setEndereco("Rua abc, 555");
		cliente.setProfissao("Professor");
		
		
		Conta conta = new Conta();
		conta.setId(2);
		
		cliente.setConta(conta);
		cliente2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		em.persist(cliente);
//		em.persist(cliente2);
		
		em.getTransaction().commit();
		em.close();
	}
}
