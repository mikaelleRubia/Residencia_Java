package pratica10;


import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;


@Entity
public class Cliente {
	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Integer id;
	
	private String nome;
	
	private String cpf;
	   
	public Cliente() {
		super();
		
	}
	public Cliente(Integer id, String nome, String cpf) {
		super();
		this.id = null;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) throws Exception {
		if(nome.length() < 3) {
            Exception e = new Exception("Nome deve ter mais de 2 caracteres");
            throw e;
		}
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) throws Exception {
		if(cpf.length() < 11) {
            Exception e = new Exception("CPF deve ter mais de 11 digitos");
            throw e;
		}
		this.cpf = cpf;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
	
	public static void main(String[] args) throws Exception {
		Cliente client1 = new Cliente(null, "ricardo", "12345678999");
		Cliente client2 = new Cliente(null,"Ro", "11145678999");
		Cliente client3 = new Cliente(null,"marlene", "12345678900");
//		Cliente client4 = new Cliente();
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit_pratica10");
		 
		 EntityManager em = emf.createEntityManager();
//		 
//		 em.getTransaction().begin();
//		 em.persist(client1);
//		 em.persist(client2);
//		 em.persist(client3);
//		 em.getTransaction().commit();
		 
		 Cliente cliente4 = em.find(Cliente.class, 14);
		 System.out.println(cliente4);
		 
		 Cliente cliente5 = em.find(Cliente.class, 15);

		 em.getTransaction().begin();
		 em.remove(cliente5);
		 em.getTransaction().commit();
		 em.close();
		 emf.close();
	}

	   
}
