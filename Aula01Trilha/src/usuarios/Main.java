package usuarios;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Usuarios usuario = new Usuarios("mikae", "123456789", "as3659");
		Usuarios usuari1 = new Usuarios("mikaell", "123456789", "sdf");
		Usuarios usuari2 = new Usuarios("mikaell3", "123456789","123bvdsbfdsbfdsbfds");
		Usuarios usuari3 = new Usuarios("mikaelle rubia", "123456789", "mnflsdmkfldsçmvfldsvbfdsv");
		Usuarios usuari4 = new Usuarios();
		
		ListaUsuario lista = new ListaUsuario();
		lista.addUsuario(usuario);
		lista.addUsuario(usuari1);
		lista.addUsuario(usuari2);
		lista.addUsuario(usuari3);
		lista.addUsuario(usuari4);
		
		System.out.println(lista.toString());
	}

}