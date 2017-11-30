package cl.ucn.disc.dam.ucngate.Model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Claudio Gonzalez
 */
@Builder
public final class Persona {

    /**
     * Rut de la {@link Persona}
     */
    @Getter String rut;

    /**
     * Nombre y apellido de la {@link Persona}
     */
    @Getter String nombre;

    /**
     * Correo electronico de la {@link Persona}
     */
    @Getter String email;

    /**
     * Telefono movil de la {@link Persona}
     */
    @Getter String telefono;

    /**
     * Numero de anexo de la {@link Persona}
     */
    @Getter String anexo;

    /**
     * Localizacion de la {@link Persona}: Unidad/Pabellon
     */
    @Getter String unidad;

    /**
     * Localizacion de la {@link Persona}: Oficina
     */
    @Getter String oficina;

    /**
     * Tipo de {@link Persona} dentro de los que esta determinado
     */
    @Getter enum tipo {académico,funcionario,apoyo,externo};

    /**
     * Cargo que tiene la {@link Persona} dentro de la universidad
     */
    @Getter String cargo;

    /**
     * Codigo que se le asigna a un estacionamiento dentro del campus y que es asociado a la {@link Persona}
     */
    @Getter int codigoEstacionamiento;


    /**
     * @return the String representation.
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }





}
