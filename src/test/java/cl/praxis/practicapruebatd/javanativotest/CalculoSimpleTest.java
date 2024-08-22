package cl.praxis.practicapruebatd.javanativotest;

import cl.praxis.practicapruebatd.javanativo.CalculoSimple;
import cl.praxis.practicapruebatd.javanativo.Detalle;
import cl.praxis.practicapruebatd.javanativo.ICalculoDescuento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoSimpleTest {
    public static List<Detalle> detalleList = new ArrayList<>();

    @BeforeEach

    public void setUp() {

        Detalle detalle1 = new Detalle(13, 0, "", "mujer");
        Detalle detalle2 = new Detalle(35, 1, "dermatología", "hombre");
        Detalle detalle3 = new Detalle(35, 10, "medicina general", "mujer");
        Detalle detalle4 = new Detalle(60, 20, "oncología", "mujer");
        Detalle detalle5 = new Detalle(63, 22, "endocrinología", "mujer");
        Detalle detalle6 = new Detalle(66, 7, "medicina general", "hombre");
        Detalle detalle7 = new Detalle(5, 7, "", "hombre");
        detalleList.addAll(Arrays.asList(detalle1, detalle2, detalle3, detalle4, detalle5, detalle6, detalle7));
    }

    @Test
    public void calculoSimpleTest() {
        ICalculoDescuento calculoSimple = new CalculoSimple();
        List<Double> listaResultado = calculoSimple.calculoDescuento(detalleList);
        List<Double> listaEsperada = Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.3, 0.2, 0.05);

        assertEquals(listaResultado, listaEsperada);
    }
}
