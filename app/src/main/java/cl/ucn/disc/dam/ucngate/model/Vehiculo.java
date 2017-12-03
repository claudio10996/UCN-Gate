package cl.ucn.disc.dam.ucngate.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Builder;
import lombok.Getter;

/**
 * Vehiculo.
 *
 * @author Pablo Fontecilla Busch.
 */

@Builder
public final class Vehiculo {

    /**
     * Patente del {@link Vehiculo} con el formato AA-AA-11.
     */
    @Getter String patente;

    /**
     * Marca del {@link Vehiculo}.
     */
    @Getter String marca;

    /**
     * Color del {@link Vehiculo}.
     */
    @Getter String color;

    /**
     * Modelo del {@link Vehiculo}.
     */
    @Getter String modelo;

    /**
     * Anio del {@link Vehiculo}
     */
    @Getter String anio;

    /**
     * Pequeña descripcion del {@link Vehiculo}.
     */
    @Getter String descripcion;


    /**
     * @return the String representation.
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
