package core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "co_number")
@NamedQueries({
        @NamedQuery(
                name = "findAllNumber.list",
                query = "select o from CoNumber o  "
        )})
public class CoNumber extends BaseEntity {

    private long id;
    private double number;
    private double unit;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    @Column(name = "ID")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "number")
    public double getNumber() {
        return number;
    }
    public void setNumber(double number) {
        this.number = number;
    }

    @Column(name = "unit")
    public double getUnit() {
        return unit;
    }
    public void setUnit(double unit) {
        this.unit = unit;
    }
}
