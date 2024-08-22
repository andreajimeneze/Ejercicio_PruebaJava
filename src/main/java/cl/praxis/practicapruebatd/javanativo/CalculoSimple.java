package cl.praxis.practicapruebatd.javanativo;

import java.util.ArrayList;
import java.util.List;

public class CalculoSimple implements ICalculoDescuento {

    @Override
    public List<Double> calculoDescuento(List<Detalle> detalles) {
        List<Double> descuentos = new ArrayList<>();
        for(Detalle detalle : detalles) {
            double desc = 0;
            if(detalle.getEdad() <= 5){
                desc = 0.05;
            } if(detalle.getEdad() > 5 && detalle.getEdad() < 13) {
                desc = 0.03;
            } if(detalle.getEdad() > 13 && detalle.getEdad() < 35) {
                if(detalle.getSexo().equals("hombre")) {
                    desc = 0.0;
                } else if (detalle.getSexo().equals("mujer")) {
                    desc = 1.02;
                }
            } if(detalle.getEdad() > 35 && detalle.getEdad() < 60) {
                desc = 0.1;
            } if(detalle.getEdad() > 60) {
                if(detalle.getSexo().equals("hombre")) {
                    desc = 0.2;
                } else if(detalle.getSexo().equals("mujer")) {
                    desc = 0.3;
                }
            }
            descuentos.add(desc);
        }
        return descuentos;
    }
}
