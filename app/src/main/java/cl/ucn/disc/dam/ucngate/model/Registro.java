package cl.ucn.disc.dam.ucngate.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.ForeignKeyReference;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

import java.util.Date;
import java.util.UUID;

import cl.ucn.disc.dam.ucngate.dao.AppDatabase;
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
    @PrimaryKey @Getter UUID id;

    /**
     * {@link Vehiculo} que ingreso a la universidad
     */
     @ForeignKey @Getter Vehiculo vehiculoIngresado;

//    /**
//     * Identificador en la base de datos del{@link Vehiculo} que ingreso a la universidad
//     */
//     @ForeignKey @Getter Vehiculo idVehiculo;

    /**
     * Fecha y hora en la que ingreso el {@link Vehiculo}
     */
    @Column @Getter Date fecha;


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
