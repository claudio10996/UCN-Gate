package cl.ucn.disc.dam.ucngate.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

import lombok.Builder;
import lombok.Getter;

/**
 * @author Claudio Gonzalez
 */

@Builder
public final class Registro {

    /**
     * {@link Vehiculo} que ingreso a la universidad
     */
    @Getter Vehiculo vehiculoIngresado;

    /**
     * Fecha y hora en la que ingreso el {@link Vehiculo}
     */
    @Getter DateTime fecha;

    /**
     * @link Entrada} por la que ingreso el {@link Vehiculo}
     */
    @Getter Entrada entrada;

    /**
     * {@link Entrada} s disponibles
     */
    public enum Entrada{Principal,Norte,Sur}





}
