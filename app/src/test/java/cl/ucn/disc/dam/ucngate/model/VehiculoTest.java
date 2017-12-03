package cl.ucn.disc.dam.ucngate.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author Pablo Fontecilla Busch.
 */

public final class VehiculoTest {

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

        Assertions.assertThat(vehiculo).isNotNull();

        Assertions.assertThat(vehiculo.getPatente()).isNotBlank();
        Assertions.assertThat(vehiculo.getMarca()).isNotBlank();
        Assertions.assertThat(vehiculo.getColor()).isNotBlank();
        Assertions.assertThat(vehiculo.getModelo()).isNotBlank();
        Assertions.assertThat(vehiculo.getAnio()).isNotBlank();
        Assertions.assertThat(vehiculo.getDescripcion()).isNotBlank();

        Assertions.assertThat(vehiculo.getPatente()).isEqualTo(patente);
        Assertions.assertThat(vehiculo.getMarca()).isEqualTo(marca);
        Assertions.assertThat(vehiculo.getColor()).isEqualTo(color);
        Assertions.assertThat(vehiculo.getModelo()).isEqualTo(modelo);
        Assertions.assertThat(vehiculo.getAnio()).isEqualTo(anio);
        Assertions.assertThat(vehiculo.getDescripcion()).isEqualTo(descripcion);

    }
}
