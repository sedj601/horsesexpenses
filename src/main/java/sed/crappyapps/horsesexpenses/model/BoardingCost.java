package sed.crappyapps.horsesexpenses.model;

import java.math.BigDecimal;


public class BoardingCost
{
    private Long id;
    private String type;
    private int numberOfHorses;
    private BigDecimal pricePerHorse;

    public BoardingCost(){};

    public BoardingCost(Long id, String type, int numberOfHorses, BigDecimal pricePerHorse) {
        this.id = id;
        this.type = "Horse Boarding";
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

