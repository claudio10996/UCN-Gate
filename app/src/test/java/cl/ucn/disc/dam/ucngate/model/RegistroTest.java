package cl.ucn.disc.dam.ucngate.model;

import org.assertj.core.api.Assertions;
import org.joda.time.DateTime;
import org.junit.Test;

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

        DateTime fecha = DateTime.now();

        final Registro registro = registro.builder()
                .vehiculo(vehiculo)
                .fecha(fecha)
                .build();

        Assertions.assertThat(registro).isNotNull();

        Assertions.assertThat(registro.getVehiculo()).isNotBlank();
        Assertions.assertThat(registro.getFecha()).isNotBlank();

        Assertions.assertThat(registro.getVehiculo()).isEqualTo(vehiculo);
        Assertions.assertThat(registro.getFecha()).isEqualTo(fecha);

    }

}
