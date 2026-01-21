package sed.crappyapps.horsesexpenses.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.math.BigDecimal;



@Entity
public class Boarding
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String type;
    private int numberOfHorses;
    @Column(name = "pricePerHorse", precision = 16, scale = 2)
    private BigDecimal pricePerHorse;

    public Boarding(){};

    public Boarding(int numberOfHorses, BigDecimal pricePerHorse) {
        this.type = "Horses";
        this.numberOfHorses = numberOfHorses;
        this.pricePerHorse = pricePerHorse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberOfHorses() {
        return numberOfHorses;
    }

    public void setNumberOfHorses(int numberOfHorses) {
        this.numberOfHorses = numberOfHorses;
    }

    public BigDecimal getPricePerHorse() {
        return pricePerHorse;
    }

    public void setPricePerHorse(BigDecimal pricePerHorse) {
        this.pricePerHorse = pricePerHorse;
    }
}

