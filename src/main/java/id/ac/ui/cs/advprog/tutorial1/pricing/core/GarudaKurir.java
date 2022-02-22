package id.ac.ui.cs.advprog.tutorial1.pricing.core;

public class GarudaKurir implements Kurir {
    private int pricePerKilogram;
    public GarudaKurir(int pricePerKilogram) {
        this.pricePerKilogram = pricePerKilogram;
    }

    public String getName() {
        return "Garuda";
    }

    public int getPricePerKilogram(){
        return this.pricePerKilogram;
    }

    public int calculatePrice(int weight) {
        return this.pricePerKilogram * weight;
    }
}
