package cl.praxis.practicapruebatd.javanativo;

import java.util.ArrayList;
import java.util.List;

public class CalculoComplejo implements ICalculoDescuento{
    @Override
    public List<Double> calculoDescuento(List<Detalle> detalleList) {
        List<Double> descuentos = new ArrayList<>();

        for(Detalle detalle : detalleList) {
            double desc = 0.0;
            if(detalle.getExperiencia() < 10) {
                desc = 0.15;
            } if (detalle.getEspecialidad().equals("cardiología") || detalle.getEspecialidad().equals("neurología")) {
                if((detalle.getExperiencia() > 10 && detalle.getExperiencia() < 20) || detalle.getExperiencia() > 20) {
                    desc = 0.05;
                }
            } if((detalle.getEspecialidad().equals("endocrinología") || detalle.getEspecialidad().equals("oncología")) && detalle.getExperiencia() > 5) {
                desc = 0.1;
            } if(detalle.getEspecialidad().equals("dermatología")) {
                desc = 0.0;
            }
            descuentos.add(desc);
        }
        return descuentos;
    }
}
