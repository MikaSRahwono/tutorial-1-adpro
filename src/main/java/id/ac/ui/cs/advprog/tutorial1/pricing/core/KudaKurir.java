package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class KudaKurir implements Kurir {
    private int pricePerKilogram;
    public KudaKurir(int pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
    }

    public String getName() {
        return "Kuda";
    }

    public int getPricePerKilogram(){
        return this.pricePerKilogram;
    }

    public int calculatePrice(int weight) {
        return this.pricePerKilogram * weight;
    }
}
