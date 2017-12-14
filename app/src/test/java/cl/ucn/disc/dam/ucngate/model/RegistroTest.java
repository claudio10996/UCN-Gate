package cl.ucn.disc.dam.ucngate.model;

import org.assertj.core.api.Assertions;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

/**
 * @author Pablo Fontecilla Busch.
 */

public final class RegistroTest {

    /**
     * Simple test del constructor via patron builder.
     */
    @Test
    public void testConstructor() {

        String patente = "SG-NE-23";
        String marca = "Ford";
        String color = "rojo";
        String modelo = "Explorer";
        String anio = "2010";
        String descripcion = "El vehículo no tiene ningun detalle interesante";

        final Vehiculo vehiculo = Vehiculo.builder()
                .patente(patente)
                .marca(marca)
                .color(color)
                .modelo(modelo)
                .anio(anio)
                .descripcion(descripcion)
                .build();

        Date fecha = new Date(2017,12,14);

        Registro.Entrada entrada= Registro.Entrada.Norte;

        final Registro registro = Registro.builder()
                .vehiculoIngresado(vehiculo)
                .fecha(fecha)
                .entrada(entrada)
                .build();

        Assertions.assertThat(registro).isNotNull();

        Assertions.assertThat(registro.getVehiculoIngresado()).isNotNull();
        Assertions.assertThat(registro.getFecha()).isNotNull();
        Assertions.assertThat(registro.getEntrada()).isNotNull();

        Assertions.assertThat(registro.getVehiculoIngresado()).isEqualTo(vehiculo);
        Assertions.assertThat(registro.getFecha()).isEqualTo(fecha);
        Assertions.assertThat(registro.getEntrada()).isEqualTo(entrada);

    }

}
