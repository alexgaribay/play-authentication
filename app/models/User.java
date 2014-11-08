package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends Model {
    @Id
    public Integer id;
    public String username;
    public String token;

    public static Finder<Integer,User> find = new Finder(Integer.class, User.class);
}
