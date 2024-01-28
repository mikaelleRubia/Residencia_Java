package pratico08;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteCoelho {

	@Test
	void test() {
		Cliente cliente = new Cliente();
		String nome = "maria";
		
		try {
			cliente.setNome(nome);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(nome, cliente.getNome());
		
		
		//------------------------------------//
		nome = "a";
		cliente = new Cliente();
		try {
			cliente.setNome(nome);
		} catch (Exception e) {
			assertEquals("Nome deve ter mais de 2 caracteres", e.getMessage());
		}
		assertNotEquals(nome, cliente.getNome());
		
		//-------------------------------------------------//
		
		String cpf = "123456789";
		cliente = new Cliente();
		try {
			cliente.setCpf(cpf);
		} catch (Exception e) {
			assertEquals("CPF deve ter mais de 11 digitos", e.getMessage());
		}
		assertNotEquals(cpf, cliente.getCpf());
		
		
		
	}

}
