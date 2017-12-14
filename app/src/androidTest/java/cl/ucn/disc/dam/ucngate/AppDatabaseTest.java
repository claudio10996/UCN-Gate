package cl.ucn.disc.dam.ucngate;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

//import org.assertj.core.api.Assertions;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import cl.ucn.disc.dam.ucngate.App;
import cl.ucn.disc.dam.ucngate.dao.AppDatabase;
import cl.ucn.disc.dam.ucngate.model.Persona;
import cl.ucn.disc.dam.ucngate.model.Persona_Table;

/**
 * Created by Claudio Gonzalez on 14-12-2017.
 */
@RunWith(AndroidJUnit4.class)
public final class AppDatabaseTest {

    @Test
    public void testDatabase() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        FlowManager.init(appContext);
        //Defino la base de datos
        DatabaseDefinition db = FlowManager.getDatabase(AppDatabase.class);
        //Construyo la persona
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

        ModelAdapter<Persona> personaAdapter = FlowManager.getModelAdapter(Persona.class);


        personaAdapter.insert(persona);

        // Encontrar personas
        List<Persona> personas = SQLite.select()
                .from(Persona.class)
                .queryList();

        Persona databasePersona = personas.get(0);

        System.out.print(databasePersona);

        /*Assertions.assertThat(databasePersona).isNotNull();

        Assertions.assertThat(databasePersona.getRut()).isNotBlank();
        Assertions.assertThat(databasePersona.getNombre()).isNotBlank();
        Assertions.assertThat(databasePersona.getEmail()).isNotBlank();
        Assertions.assertThat(databasePersona.getTelefono()).isNotBlank();
        Assertions.assertThat(databasePersona.getAnexo()).isNotBlank();
        Assertions.assertThat(databasePersona.getUnidad()).isNotBlank();
        Assertions.assertThat(databasePersona.getOficina()).isNotBlank();
        Assertions.assertThat(databasePersona.getCargo()).isNotBlank();
        Assertions.assertThat(databasePersona.getTipo()).isNotNull();
        Assertions.assertThat(databasePersona.getCodigoEstacionamiento()).isNotNull();

        Assertions.assertThat(databasePersona.getRut()).isEqualTo(persona.getRut());
        Assertions.assertThat(databasePersona.getNombre()).isEqualTo(persona.getNombre());
        Assertions.assertThat(databasePersona.getEmail()).isEqualTo(persona.getEmail());
        Assertions.assertThat(databasePersona.getTelefono()).isEqualTo(persona.getTelefono());
        Assertions.assertThat(databasePersona.getAnexo()).isEqualTo(persona.getAnexo());
        Assertions.assertThat(databasePersona.getUnidad()).isEqualTo(persona.getUnidad());
        Assertions.assertThat(databasePersona.getOficina()).isEqualTo(persona.getOficina());
        Assertions.assertThat(databasePersona.getCargo()).isEqualTo(persona.getCargo());
        Assertions.assertThat(databasePersona.getTipo()).isEqualTo(persona.getTipo());
        Assertions.assertThat(databasePersona.getCodigoEstacionamiento()).isEqualTo(persona.getCodigoEstacionamiento());
*/



    }



}
