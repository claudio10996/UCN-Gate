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

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import cl.ucn.disc.dam.ucngate.App;
import cl.ucn.disc.dam.ucngate.dao.AppDatabase;
import cl.ucn.disc.dam.ucngate.model.Persona;
import cl.ucn.disc.dam.ucngate.model.Persona_Table;

/**
 * @author Claudio Gonzalez
 */
@RunWith(AndroidJUnit4.class)
public final class AppDatabaseTest {

    @Test
    public void useAppContext() throws Exception {

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

        assertNotNull(databasePersona);
        assertEquals(persona.getNombre(), databasePersona.getNombre());
        assertEquals(persona.getCodigoEstacionamiento(),databasePersona.getCodigoEstacionamiento());



    }



}
