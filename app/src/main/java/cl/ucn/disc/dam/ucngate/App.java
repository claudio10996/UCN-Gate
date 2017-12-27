package cl.ucn.disc.dam.ucngate;

import android.app.Application;
import android.util.Log;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

import org.joda.time.DateTime;

import java.util.Date;

import cl.ucn.disc.dam.ucngate.model.Persona;
import cl.ucn.disc.dam.ucngate.model.Registro;
import cl.ucn.disc.dam.ucngate.model.Vehiculo;

/**
 * Created by arago on 07-Dec-17.
 */

public final class App extends Application {

    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * Implementations should be as quick as possible (for example using
     * lazy initialization of state) since the time spent in this function
     * directly impacts the performance of starting the first activity,
     * service, or receiver in a process.
     * If you override this method, be sure to call super.onCreate().
     */
    @Override
    public void onCreate() {

        super.onCreate();
        FlowManager.init(this); //TODO: Verificar que esto quedara aqui

        //Construyo la persona
        String rut = "19.034.687-0";
        String nombre = "Claudio Gonzales";
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

        Log.d("", persona.toString());

        String patente = "ZZ-AA-24";
        String marca = "Chevrolet";
        String color = "rojo";
        String modelo = "Corvette";
        String anio = "2010";
        String descripcion = "El vehículo no tiene ningun detalle interesante";

        final Vehiculo vehiculo = Vehiculo.builder()
                .responsable(persona)
                .patente(patente)
                .marca(marca)
                .color(color)
                .modelo(modelo)
                .anio(anio)
                .descripcion(descripcion)
                .build();

        ModelAdapter<Vehiculo> vehiculoAdapter = FlowManager.getModelAdapter(Vehiculo.class);

        vehiculoAdapter.insert(vehiculo);

        Log.d("", vehiculo.toString());

        Date fecha = new Date();
        fecha = DateTime.now().toDate();
        Registro.Entrada entrada = Registro.Entrada.Sur;

        final Registro registo = Registro.builder()
                .vehiculoIngresado(vehiculo)
                .fecha(fecha)
                .entrada(entrada)
                .build();

        ModelAdapter<Registro> registroModelAdapter = FlowManager.getModelAdapter(Registro.class);

        registroModelAdapter.insert(registo);

    }


}
