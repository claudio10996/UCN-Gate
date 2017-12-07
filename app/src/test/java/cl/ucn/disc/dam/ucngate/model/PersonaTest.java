package cl.ucn.disc.dam.ucngate.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * @author Claudio Gonzalez
 */

public final class PersonaTest {

    /**
     * Simple test del constructor via patron builder.
     */
    @Test
    public void testConstructor() {


        String rut = "19.034.687-0";
        String nombre = "Camilo Gonzales";
        String email = "algo@gmail.com";
        String telefono = "123467";
        String anexo = "23";
        String unidad = "Y1";
        String oficina = "205";
        String cargo = "Profesor";
        Persona.Tipo tipo= Persona.Tipo.académico;
        int codigo = 29;


        final Persona persona = Persona.builder()
                .rut(rut)
                .nombre(nombre)
                .email(email)
                .telefono(telefono)
                .anexo(anexo)
                .unidad(unidad)
                .oficina(oficina)
                .cargo(cargo)
                .tipo(tipo)
                .codigoEstacionamiento(codigo)
                .build();

        Assertions.assertThat(persona).isNotNull();

        Assertions.assertThat(persona.getRut()).isNotBlank();
        Assertions.assertThat(persona.getNombre()).isNotBlank();
        Assertions.assertThat(persona.getEmail()).isNotBlank();
        Assertions.assertThat(persona.getTelefono()).isNotBlank();
        Assertions.assertThat(persona.getAnexo()).isNotBlank();
        Assertions.assertThat(persona.getUnidad()).isNotBlank();
        Assertions.assertThat(persona.getOficina()).isNotBlank();
        Assertions.assertThat(persona.getCargo()).isNotBlank();
        Assertions.assertThat(persona.getTipo()).isNotNull();
        Assertions.assertThat(persona.getCodigoEstacionamiento()).isNotNull();

        Assertions.assertThat(persona.getRut()).isEqualTo(rut);
        Assertions.assertThat(persona.getNombre()).isEqualTo(nombre);
        Assertions.assertThat(persona.getEmail()).isEqualTo(email);
        Assertions.assertThat(persona.getTelefono()).isEqualTo(telefono);
        Assertions.assertThat(persona.getAnexo()).isEqualTo(anexo);
        Assertions.assertThat(persona.getUnidad()).isEqualTo(unidad);
        Assertions.assertThat(persona.getOficina()).isEqualTo(oficina);
        Assertions.assertThat(persona.getCargo()).isEqualTo(cargo);
        Assertions.assertThat(persona.getTipo()).isEqualTo(tipo);
        Assertions.assertThat(persona.getCodigoEstacionamiento()).isEqualTo(codigo);

    }

}
