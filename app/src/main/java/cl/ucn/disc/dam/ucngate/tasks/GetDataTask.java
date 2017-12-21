package cl.ucn.disc.dam.ucngate.tasks;

import android.os.AsyncTask;

import java.util.List;

import cl.ucn.disc.dam.ucngate.Controller;
import cl.ucn.disc.dam.ucngate.model.Vehiculo;

/**
 * @author Claudio Gonzalez
 */

public final class GetDataTask extends AsyncTask<Void, Void, List<Vehiculo>> {

    @Override
    protected List<Vehiculo> doInBackground(Void... voids) {
        Controller controlador = new Controller();
        return controlador.getVehiculos();
    }
}
