package controllers;

import java.util.List;
import models.UserGroup;
import play.mvc.Controller;
import play.i18n.Messages;
import play.data.validation.Validation;
import play.data.validation.Valid;

public class UserGroups extends Controller {
    public static void index() {
        List<UserGroup> entities = models.UserGroup.all().fetch();
        render(entities);
    }

    public static void create(UserGroup entity) {
        render(entity);
    }

    public static void show(java.lang.Long id) {
        UserGroup entity = UserGroup.findById(id);
        render(entity);
    }

    public static void edit(java.lang.Long id) {
        UserGroup entity = UserGroup.findById(id);
        render(entity);
    }

    public static void delete(java.lang.Long id) {
        UserGroup entity = UserGroup.findById(id);
        entity.delete();
        index();
    }
    
    public static void save(@Valid UserGroup entity) {
        if (validation.hasErrors()) {
            flash.error(Messages.get("scaffold.validation"));
            render("@create", entity);
        }
        entity.save();
        flash.success(Messages.get("scaffold.created", "UserGroup"));
        index();
    }

    public static void update(@Valid UserGroup entity) {
        if (validation.hasErrors()) {
            flash.error(Messages.get("scaffold.validation"));
            render("@edit", entity);
        }
        
              entity = entity.merge();
        
        entity.save();
        flash.success(Messages.get("scaffold.updated", "UserGroup"));
        index();
    }
}
