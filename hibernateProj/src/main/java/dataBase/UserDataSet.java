package dataBase;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "2user")
public class UserDataSet implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String pass;

    @Column(name = "email")
    private String email;

    //Important to Hibernate!
    public UserDataSet() {
    }

    public UserDataSet(long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public UserDataSet(String email, String name, String pass) {
        this.setId(-1);
        this.setName(name);
        this.setPass(pass);
        this.setEmail(email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDataSet{" +
                "id = " + id +
                ", name = " + name + ", pass = " + pass + '\'' +
                '}';
    }
}

