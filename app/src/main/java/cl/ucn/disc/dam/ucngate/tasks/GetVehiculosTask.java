package cl.ucn.disc.dam.ucngate.tasks;

import android.os.AsyncTask;

import java.util.List;

import cl.ucn.disc.dam.ucngate.VehiculoController;
import cl.ucn.disc.dam.ucngate.model.Vehiculo;

/**
 * @author Claudio Gonzalez
 */

public final class GetVehiculosTask extends AsyncTask<Void, Void, List<Vehiculo>> {

    @Override
    protected List<Vehiculo> doInBackground(Void... voids) {
        VehiculoController controlador = new VehiculoController();
        return controlador.getVehiculos();
    }
}
