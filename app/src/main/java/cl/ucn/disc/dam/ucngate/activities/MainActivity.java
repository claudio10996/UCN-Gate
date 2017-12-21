package cl.ucn.disc.dam.ucngate.activities;

import android.app.ActionBar;
import android.app.ListActivity;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.BaseAdapter;

import cl.ucn.disc.dam.ucngate.R;
import cl.ucn.disc.dam.ucngate.adapters.VehiculoDBFlowAdapter;
import cl.ucn.disc.dam.ucngate.tasks.GetDataTask;

import lombok.Getter;

public class MainActivity extends ListActivity {

    /**
     * Adapter de {@link }.
     */
    private BaseAdapter vehiculoAdapter;

    /**
     * Running background task
     */
    @Getter private GetDataTask dataTask;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Mostrar la barrita
        final ActionBar actionBar = super.getActionBar();
        if (actionBar != null) {
            actionBar.setLogo(R.drawable.ic_launcher_foreground);
            actionBar.setDisplayUseLogoEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }

        // Row division
        int[] colors = {0, 0x00000000, 0};
        this.getListView().setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        this.getListView().setDividerHeight(5);

        // Adaptador de articles
        this.vehiculoAdapter = new VehiculoDBFlowAdapter(this);
        super.setListAdapter(this.vehiculoAdapter);

        // Si no hay articulos en el adaptador (y por lo tanto en la base de datos) ..
        if (this.vehiculoAdapter.isEmpty()) {
            // .. ejecuto la tarea para obtenerlas.
            this.getDataTask();
        }
    }
//
//    /**
//     * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when
//     * the activity had been stopped, but is now again being displayed to the
//     * user.  It will be followed by {@link #onResume}.
//     * <p>
//     * <p><em>Derived classes must call through to the super class's
//     * implementation of this method.  If they do not, an exception will be
//     * thrown.</em></p>
//     *
//     * @see #onCreate
//     * @see #onStop
//     * @see #onResume
//     */
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        // Show the database size!
//        Toast.makeText(this, "Vehiculos in BD: " + this.vehiculoAdapter.getCount(), Toast.LENGTH_SHORT).show();
//
//    }
//
//    /**
//     * Metodo que realiza la ejecucion en segundo plano de la tarea que obtiene los
//     * {@link com.durrutia.dnews.model.Article} desde Internet.
//     */
//    private void runGetAndSaveArticlesTask() {
//
//        // Si ya hay una tarea de obtencion de articulos corriendo no ejecuto una nueva!
//        if (this.getSaveVehiculosTask != null) {
//            Toast.makeText(this, "Already downloading Articles ..", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        // Show little message
//        Toast.makeText(this, "Downloading Articles ..", Toast.LENGTH_LONG).show();
//
//        // Inicio la tarea
//        Log.d("","Starting GetSaveArticlesTask ..");
//        this.getSaveVehiculosTask = new GetSaveVehiculosTask(this);
//        this.getSaveVehiculosTask.execute();
//
//    }
//
//    /**
//     * Aviso que se termino la obtencion de los {@link com.durrutia.dnews.model.Article}.
//     *
//     * @param nuevosVehiculos numero de articulos nuevos obtenidos.
//     */
//    @Override
//    public void taskFinished(Integer nuevosVehiculos) {
//
//        // Show little message
//        Toast.makeText(this, "New Vehiculos: " + nuevosVehiculos, Toast.LENGTH_LONG).show();
//
//        Log.d("","Finished!");
//        this.vehiculoAdapter.notifyDataSetChanged();
//
//        // Clean the task!
//        this.getSaveVehiculosTask = null;
//
//    }

    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.
     * <p>
     * <p>This is only called once, the first time the options menu is
     * displayed.  To update the menu every time it is displayed, see
     * {@link #onPrepareOptionsMenu}.
     * <p>
     * <p>The default implementation populates the menu with standard system
     * menu items.  These are placed in the {@link Menu#CATEGORY_SYSTEM} group so that
     * they will be correctly ordered with application-defined menu items.
     * Deriving classes should always call through to the base implementation.
     * <p>
     * <p>You can safely hold on to <var>menu</var> (and any items created
     * from it), making modifications to it as desired, until the next
     * time onCreateOptionsMenu() is called.
     * <p>
     * <p>When you add items to the menu, you can implement the Activity's
     * {@link #onOptionsItemSelected} method to handle them there.
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed;
     * if you return false it will not be shown.
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        final MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
//
//    /**
//     * This hook is called whenever an item in your options menu is selected.
//     * The default implementation simply returns false to have the normal
//     * processing happen (calling the item's Runnable or sending a message to
//     * its Handler as appropriate).  You can use this method for any items
//     * for which you would like to do processing without those other
//     * facilities.
//     * <p>
//     * <p>Derived classes should call through to the base class for it to
//     * perform the default menu handling.</p>
//     *
//     * @param item The menu item that was selected.
//     * @return boolean Return false to allow normal menu processing to
//     * proceed, true to consume it here.
//     * @see #onCreateOptionsMenu
//     */
//    @Override
//    public boolean onOptionsItemSelected(final MenuItem item) {
//
//    }
}
