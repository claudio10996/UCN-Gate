package cl.ucn.disc.dam.ucngate.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

import java.util.UUID;

import cl.ucn.disc.dam.ucngate.Dao.AppDatabase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Claudio Gonzalez
 */

@Builder
@Table(database = AppDatabase.class)
@AllArgsConstructor
@NoArgsConstructor
public final class Registro {

    /**
     * ID
     */
    @PrimaryKey
    @Getter
    UUID id;

    /**
     * {@link Vehiculo} que ingreso a la universidad
     */
    @Column @Getter Vehiculo vehiculoIngresado;

    /**
     * Fecha y hora en la que ingreso el {@link Vehiculo}
     */
    @Column @Getter DateTime fecha;

    /**
     * @link Entrada} por la que ingreso el {@link Vehiculo}
     */
    @Column @Getter Entrada entrada;

    /**
     * {@link Entrada} s disponibles
     */
    public enum Entrada{Principal,Norte,Sur}

    /**
     * @return the String representation.
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }





}
