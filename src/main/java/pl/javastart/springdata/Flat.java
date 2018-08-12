package pl.javastart.springdata;

import javax.persistence.*;
import java.util.List;

@Entity
public class Flat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long number;
    private double area;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Resident> residents;

    @ManyToOne()
    private Community community;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public List<Resident> getResidents() {
        return residents;
    }

    public void setResidents(List<Resident> residents) {
        this.residents = residents;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
}
