package usuarios;

import java.util.ArrayList;

public class ListaUsuario extends CredenciaisInvalidasException{
	
	private ArrayList<Usuarios> usuarios;

	public ArrayList<Usuarios> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}
	public ListaUsuario() {
		super();
	}

	public ListaUsuario(ArrayList<Usuarios> usuarios) {
		super();
		this.usuarios = usuarios;
	}
	
	public void addUsuario(Usuarios usuario) {

		if (usuario.getNome() == null || usuario.getSenha().length() < 6 ) {
			CredenciaisInvalidasException();
        }else {
        	if(usuarios == null) {
        		this.usuarios = new ArrayList<>();
        	}
        	this.usuarios.add(usuario);	
        }
        
	}
	
	@Override
	public String toString() {
		return "ListaUsuario:" +  "\n"+usuarios ;
	
	}
	

}
