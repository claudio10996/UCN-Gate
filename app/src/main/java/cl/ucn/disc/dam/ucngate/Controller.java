package cl.ucn.disc.dam.ucngate;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

import java.util.Date;
import java.util.List;

import cl.ucn.disc.dam.ucngate.model.Registro;
import cl.ucn.disc.dam.ucngate.model.Vehiculo;

/**
 * @author Claudio Gonzalez
 */

public final class Controller {

    public List <Vehiculo> getVehiculos (){
        return null;
    }

    public void ingresarRegistro (Vehiculo vehiculo, Date fecha, Registro.Entrada entrada){
        ModelAdapter<Registro> registroAdapter = FlowManager.getModelAdapter(Registro.class);
        Registro regis = Registro.builder()
                .entrada(entrada)
                .fecha(fecha)
                .vehiculoIngresado(vehiculo)
                .build();
        registroAdapter.insert(regis);

    }
}
