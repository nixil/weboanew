package controllers;

import java.util.List;
import models.Role;
import play.mvc.Controller;
import play.i18n.Messages;
import play.data.validation.Validation;
import play.data.validation.Valid;

public class Roles extends Controller {
    public static void index() {
        List<Role> entities = models.Role.all().fetch();
        render(entities);
    }

    public static void create(Role entity) {
        render(entity);
    }

    public static void show(java.lang.Long id) {
        Role entity = Role.findById(id);
        render(entity);
    }

    public static void edit(java.lang.Long id) {
        Role entity = Role.findById(id);
        render(entity);
    }

    public static void delete(java.lang.Long id) {
        Role entity = Role.findById(id);
        entity.delete();
        index();
    }
    
    public static void save(@Valid Role entity) {
        if (validation.hasErrors()) {
            flash.error(Messages.get("scaffold.validation"));
            render("@create", entity);
        }
        entity.save();
        flash.success(Messages.get("scaffold.created", "Role"));
        index();
    }

    public static void update(@Valid Role entity) {
        if (validation.hasErrors()) {
            flash.error(Messages.get("scaffold.validation"));
            render("@edit", entity);
        }
        
              entity = entity.merge();
        
        entity.save();
        flash.success(Messages.get("scaffold.updated", "Role"));
        index();
    }
}
