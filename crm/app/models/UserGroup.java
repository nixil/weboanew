package models;

import java.util.Set;

import javax.persistence.Entity;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class UserGroup extends Model{
	@Required
	public String name;
}
