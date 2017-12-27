package cl.ucn.disc.dam.ucngate.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.UUID;

import cl.ucn.disc.dam.ucngate.dao.AppDatabase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Vehiculo.
 *
 * @author Pablo Fontecilla Busch.
 */

@Builder
@Table(database = AppDatabase.class)
@AllArgsConstructor
@NoArgsConstructor
public final class Vehiculo {

    /**
     * ID
     */
    @PrimaryKey(autoincrement = true) @Getter long id;

    /**
     * Patente del {@link Vehiculo} con el formato AA-AA-11.
     */
    @Column @Getter String patente;

    /**
     * Marca del {@link Vehiculo}.
     */
    @Column @Getter String marca;

    /**
     * Color del {@link Vehiculo}.
     */
    @Column @Getter String color;

    /**
     * Modelo del {@link Vehiculo}.
     */
    @Column @Getter String modelo;

    /**
     * Anio del {@link Vehiculo}
     */
    @Column @Getter String anio;

    /**
     * Pequeña descripcion del {@link Vehiculo}.
     */
    @Column @Getter String descripcion;

    /**
     * Identificador en la base de datos de responsable del {@link Vehiculo}.
     */
    @ForeignKey @Getter Persona responsable;


    /**
     * @return the String representation.
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
