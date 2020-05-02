package pepsi.delivery.pepsidelivery.domain.model.dto;

public class UserAut {
	private String email;
	private String senha;
	
	public UserAut() {
		
	}
	
	public UserAut(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public String toString() {
		return "UserAut [email=" + email + ", senha=" + senha + "]";
	}
}
