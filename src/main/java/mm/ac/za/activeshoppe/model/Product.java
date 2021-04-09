package mm.ac.za.activeshoppe.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;

    @NotNull(message = "Product code is required.")
    @Basic(optional = false)
    private String code;

    @NotNull(message = "Product points cost is required.")
    @Basic(optional = false)
    private int pointsCost;

    public Product() {
    }

    public Product(@NotNull(message = "Product name is required.") String name, @NotNull(message = "Product code is required.") String code, @NotNull(message = "Product points cost is required.") int pointsCost) {
        this.name = name;
        this.code = code;
        this.pointsCost = pointsCost;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getPointsCost() {
        return pointsCost;
    }

    public void setPointsCost(int pointsCost) {
        this.pointsCost = pointsCost;
    }
}