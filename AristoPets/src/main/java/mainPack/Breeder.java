package mainPack;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "test1")
public class Breeder implements Serializable { // Serializable Important to Hibernate!
    private static final long serialVersionUID = -8706689714326132798L;
    //<mapping class="AristoPets2.src.main.java.Breeder.java" />
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String animal_type;

    //Important to Hibernate!
    public Breeder() {}

    public Breeder(long id, String name, String animal_type) {
        this.setId(id);
        this.setName(name);
        this.setAnimalType(animal_type);
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

    public String getAnimalType() {
        return animal_type;
    }

    public void setAnimalType(String animal_tupe) {
        this.animal_type = animal_type;
    }
}
