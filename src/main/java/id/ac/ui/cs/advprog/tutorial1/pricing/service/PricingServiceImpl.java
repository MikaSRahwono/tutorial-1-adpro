package id.ac.ui.cs.advprog.tutorial1.pricing.service;

import id.ac.ui.cs.advprog.tutorial1.pricing.core.Asuransi;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.KurirRepository;
import id.ac.ui.cs.advprog.tutorial1.pricing.repository.AsuransiRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;
import id.ac.ui.cs.advprog.tutorial1.pricing.core.Kurir;


@Service
public class PricingServiceImpl implements PricingService {
    
    @Autowired
    private KurirRepository kurirRepository;

    @Autowired
    private AsuransiRepository asuransiRepository;

    @Override
    public List<String> calculatePrice(int weight, int value) {
        List<String> ret = new ArrayList<>();
        Kurir kurir = null;
        int price = 0;
        int PpK = 0;
        Asuransi asuransi = null;
        int total = 0;
        if (weight < 10){
            kurir = kurirRepository.findByName("Kadal");
        }
        else if (weight > 50){
            kurir = kurirRepository.findByName("Garuda");
        }
        else {
            kurir = kurirRepository.findByName("Kuda");
        }

        if(value<1000){
            asuransi = asuransiRepository.findByName("Beta");
        }
        else if (value>50000){
            asuransi = asuransiRepository.findByName("Sigma");
        }
        else{
            asuransi = asuransiRepository.findByName("Alpha");
        }

        price = kurir.calculatePrice(weight);
        PpK = kurir.getPricePerKilogram();

        ret.add("Menggunakan Kurir " + kurir.getName());
        ret.add("Harga jasa kurir: "+weight+" x "+PpK+" = "+price+" civil credits");
        ret.add("Menggunakan Asuransi "+asuransi.getName());
        ret.add("Harga jasa asuransi: "+asuransi.getPrice()+" civil credits");
        total = price + asuransi.getPrice();
        ret.add("total harga: "+price+" + "+asuransi.getPrice()+" = "+total+" civil credits");
        return ret;
    }

}
