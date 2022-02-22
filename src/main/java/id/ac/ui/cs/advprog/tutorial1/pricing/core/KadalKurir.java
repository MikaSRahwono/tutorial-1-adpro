package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class KadalKurir implements Kurir {
    private int pricePerKilogram;
    public KadalKurir(int pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
    }

    public String getName() {
        return "Kadal";
    }

    public int getPricePerKilogram(){
        return this.pricePerKilogram;
    }

    public int calculatePrice(int weight) {
        return this.pricePerKilogram * weight;
    }
}
