package mm.ac.za.activeshoppe.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Customer name is required.")
    @Basic(optional = false)
    private String name;

    @NotNull(message = "Customer points is required.")
    @Basic(optional = false)
    private int pointsBalance;

    public Customer() {
    }

    public Customer(@NotNull(message = "Customer name is required.") String name, @NotNull(message = "Customer points is required.") int pointsBalance) {
        this.name = name;
        this.pointsBalance = pointsBalance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPointsBalance() {
        return pointsBalance;
    }

    public void setPointsBalance(int pointsBalance) {
        this.pointsBalance = pointsBalance;
    }
}