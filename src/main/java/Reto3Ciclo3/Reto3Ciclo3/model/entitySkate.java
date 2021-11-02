package Reto3Ciclo3.Reto3Ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/*
 *
 * @author NadiaS
 * @version 11.0.12
 */
@Entity
@Table(name = "skate")
public class entitySkate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String brand;
    private Integer year;
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("skates")
    private entityCategory category;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "skate")
    @JsonIgnoreProperties({"skate", "client"})
    private List<entityMessage> messages;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "skate")
    @JsonIgnoreProperties({"skate", "client"})
    private List<entityReservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public entityCategory getCategory() {
        return category;
    }

    public void setCategory(entityCategory category) {
        this.category = category;
    }

    public List<entityMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<entityMessage> messages) {
        this.messages = messages;
    }

    public List<entityReservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<entityReservation> reservations) {
        this.reservations = reservations;
    }
}
