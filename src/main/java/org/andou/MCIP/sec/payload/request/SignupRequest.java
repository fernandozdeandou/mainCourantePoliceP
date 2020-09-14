package org.andou.MCIP.sec.payload.request;

import java.util.Set;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("deprecation")
public class SignupRequest {
	     @NotBlank
	     @Size(min = 3, max = 20)
	    private String matricule;
	 
	    @NotBlank
	    @Size(max = 50)
	    @Email
	    private String email;
	    
	    private Set<String> role;
	    
	    @NotBlank
	    @Size(min = 4, max = 40)
	    private String password;
	    
	    public String getRepassword() {
			return repassword;
		}

		public void setRepassword(String repassword) {
			this.repassword = repassword;
		}

		private String repassword;

		public String getUsername() {
			return matricule;
		}

		public void setUsername(String username) {
			this.matricule = username;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Set<String> getRole() {
			return role;
		}

		public void setRole(Set<String> role) {
			this.role = role;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	    

}
