package sed.crappyapps.horsesexpenses.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class HorseExpense
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "costPerHorse", precision = 16, scale = 2)
    private BigDecimal costPerHorse;

    public HorseExpense(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCostPerHorse() {
        return costPerHorse;
    }

    public void setCostPerHorse(BigDecimal costPerHorse) {
        this.costPerHorse = costPerHorse;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Item{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", costPerHorse=").append(costPerHorse);
        sb.append('}');
        return sb.toString();
    }
}
