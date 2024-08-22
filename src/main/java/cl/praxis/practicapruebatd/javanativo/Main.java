package cl.praxis.practicapruebatd.javanativo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Detalle> detalleList = new ArrayList<>();
        Detalle detalle1 = new Detalle(33, 25, "cardiología", "mujer");
        Detalle detalle2 = new Detalle(58, 3, "dermatología", "hombre");
        Detalle detalle3 = new Detalle(25, 4, "medicina general", "hombre");
        Detalle detalle4 = new Detalle(65, 7, "oncología", "mujer");
        Detalle detalle5 = new Detalle(43, 18, "endocrinología", "mujer");
        Detalle detalle6 = new Detalle(53, 7, "medicina general", "mujer");

        detalleList.add(detalle1);
        detalleList.add(detalle2);
        detalleList.add(detalle3);
        detalleList.add(detalle4);
        detalleList.add(detalle5);
        detalleList.add(detalle6);

        CalculoSimple calculoSimple= new CalculoSimple();
        CalculoComplejo calculoComplejo = new CalculoComplejo();

        List<Double> listaDescuentos = calculoSimple.calculoDescuento(detalleList);
        List<Double> descuentosProfesionales = calculoComplejo.calculoDescuento(detalleList);
        System.out.println("La lista de descuentos  para pacientes es de: " + listaDescuentos);
        System.out.println("La lista de descuentos para médicos es de: " + descuentosProfesionales);
    }
}
