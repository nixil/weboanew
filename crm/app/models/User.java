package models;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import play.data.validation.Email;
import play.db.jpa.Model;

@Entity
public class User extends Model{
	
	@Embedded public Name name;
	
	@Email
	public String email;
	public String password; 
	
	@ManyToOne
	public UserGroup group;
	
	@Embeddable
	public class Name {
		public String first;
		public String last;
		@Override
		public String toString() {
			return first+ " "+last;
		}
	}
}
