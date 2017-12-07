package cl.ucn.disc.dam.ucngate.model;

import com.raizlabs.android.dbflow.annotation.Column;
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
 * @author Claudio Gonzalez
 */
@Builder
@Table(database = AppDatabase.class)
@AllArgsConstructor
@NoArgsConstructor
public final class Persona {

    /**
     * ID
     */
    @PrimaryKey @Getter UUID id;

    /**
     * Rut de la {@link Persona} con el formato xx.xxx.xxx-x
     */
    @Column @Getter String rut;

    /**
     * Nombre y apellido de la {@link Persona}
     */

    @Column @Getter String nombre;

    /**
     * Correo electronico de la {@link Persona}
     */
    @Column @Getter String email;

    /**
     * Telefono movil de la {@link Persona}
     */
    @Column @Getter String telefono;

    /**
     * Numero de anexo de la {@link Persona}
     */
    @Column @Getter String anexo;

    /**
     * Localizacion de la {@link Persona}: Unidad/Pabellon
     */
    @Column @Getter String unidad;

    /**
     * Localizacion de la {@link Persona}: Oficina
     */
    @Column @Getter String oficina;

    /**
     * Tipo de la {@link Persona} dentro de los que esta determinado
     */
    @Column @Getter Tipo tipo;

    /**
     * Cargo que tiene la {@link Persona} dentro de la universidad
     */
    @Column @Getter String cargo;

    /**
     * Codigo que se le asigna a un estacionamiento dentro del campus y que es asociado a la {@link Persona}
     */
    @Column @Getter int codigoEstacionamiento;


    /**
     * @return the String representation.
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }


    /**
     * Tipos de {@link Persona}
     */
    public enum Tipo {académico,funcionario,apoyo,externo}





}
