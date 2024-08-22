package cl.praxis.practicapruebatd.javanativotest;

import cl.praxis.practicapruebatd.javanativo.CalculoComplejo;
import cl.praxis.practicapruebatd.javanativo.Detalle;
import cl.praxis.practicapruebatd.javanativo.ICalculoDescuento;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoComplejoTest {

    public static List<Detalle> detalles = new ArrayList<>();

   @BeforeEach

   public void setUp() {

    Detalle detalle1 = new Detalle(33, 12, "cardiología", "mujer");
    Detalle detalle2 = new Detalle(58, 1, "dermatología", "hombre");
    Detalle detalle3 = new Detalle(25, 10, "medicina general", "hombre");
    Detalle detalle4 = new Detalle(65, 20, "oncología", "mujer");
    Detalle detalle5 = new Detalle(43, 22, "endocrinología", "mujer");
    Detalle detalle6 = new Detalle(53, 7, "medicina general", "mujer");
       detalles.add(detalle1);
       detalles.add(detalle2);
       detalles.add(detalle3);
       detalles.add(detalle4);
       detalles.add(detalle5);
       detalles.add(detalle6);
   }

   @Test
    public void calculoDescuentoTest() {
       ICalculoDescuento calculoDescuento = new CalculoComplejo();

       List<Double> listaResultado = calculoDescuento.calculoDescuento(detalles);
       List<Double> listaEsperada = Arrays.asList(0.05, 0.0, 0.0, 0.1, 0.1, 0.15);

       assertEquals(listaResultado, listaEsperada);
   }
}
