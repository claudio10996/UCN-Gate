package cl.ucn.disc.dam.ucngate.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.structure.ModelAdapter;

import org.joda.time.DateTime;

import java.util.Date;
import java.util.zip.Inflater;

import cl.ucn.disc.dam.ucngate.R;
import cl.ucn.disc.dam.ucngate.adapters.VehiculoDBFlowAdapter;
import cl.ucn.disc.dam.ucngate.model.Persona;
import cl.ucn.disc.dam.ucngate.model.Registro;
import cl.ucn.disc.dam.ucngate.model.Vehiculo;
import cl.ucn.disc.dam.ucngate.tasks.GetDataTask;

import lombok.Getter;

public class MainActivity extends Activity {

    /**
     * Lista de la actividad
     */
    private ListView lista;

    /**
     * Texto en el cual se buscará la patente
     */
    private EditText search;

    /**
     * Adapter de {@link }.
     */
    private BaseAdapter vehiculoAdapter;

    private Spinner listaPorteria;

    private Registro.Entrada [] entradas= {Registro.Entrada.Principal,Registro.Entrada.Norte,Registro.Entrada.Sur};

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
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.lista);

        // Adaptador de vehiculos
        this.vehiculoAdapter = new VehiculoDBFlowAdapter(this, "");
//        super.setListAdapter(this.vehiculoAdapter);

        final Context context = this;

        lista.setAdapter(this.vehiculoAdapter);

        search = (EditText) findViewById(R.id.am_search);

        listaPorteria = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<Registro.Entrada> adaptadorEntrada = new ArrayAdapter<Registro.Entrada>(this,android.R.layout.simple_spinner_item,entradas);
        listaPorteria.setAdapter(adaptadorEntrada);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                vehiculoAdapter = new VehiculoDBFlowAdapter(context, s.toString());
                lista.setAdapter(vehiculoAdapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        lista.setClickable(true);//Para que se le pueda hacer click al item
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Obtener vehiculo y respondable
                final Vehiculo vehi = (Vehiculo) adapterView.getAdapter().getItem(i);
                final Persona resp = vehi.getResponsable();

                //Se crea la ventana popout
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView =getLayoutInflater().inflate(R.layout.vehiculo_dialog,null);

                //Datos a deplegar
                TextView patente = (TextView) mView.findViewById(R.id.patente_text);
                patente.append(": "+ vehi.getPatente());
                TextView color = (TextView) mView.findViewById(R.id.color_text);
                color.append(": "+ vehi.getColor());
                TextView marca = (TextView) mView.findViewById(R.id.marca_text);
                marca.append(": "+ vehi.getMarca());
                TextView modelo = (TextView) mView.findViewById(R.id.model_text);
                modelo.append(": "+ vehi.getModelo());
                TextView anio = (TextView) mView.findViewById(R.id.year_text);
                anio.append(": "+ vehi.getAnio());
                TextView descripcion = (TextView) mView.findViewById(R.id.description_text);
                descripcion.append(": "+ vehi.getDescripcion());

                TextView nombre = (TextView) mView.findViewById(R.id.nombre_text);
                nombre.append(": "+ resp.getNombre());
                TextView rut = (TextView) mView.findViewById(R.id.rut_text);
                rut.append(": "+ resp.getRut());
                TextView correo = (TextView) mView.findViewById(R.id.mail_text);
                correo.append(": "+ resp.getEmail());
                TextView telefono = (TextView) mView.findViewById(R.id.phone_text);
                telefono.append(": "+ resp.getTelefono());
                TextView anexo = (TextView) mView.findViewById(R.id.anexo_text);
                anexo.append(": "+ resp.getAnexo());
                TextView unidad = (TextView) mView.findViewById(R.id.unidad_text);
                unidad.append(": "+ resp.getUnidad());
                TextView oficina = (TextView) mView.findViewById(R.id.oficina_text);
                oficina.append(": "+ resp.getOficina());
                TextView tipo = (TextView) mView.findViewById(R.id.tipo_text);
                tipo.append(": "+ resp.getTipo());
                TextView cargo = (TextView) mView.findViewById(R.id.cargo_text);
                cargo.append(": "+ resp.getCargo());
                TextView codigo = (TextView) mView.findViewById(R.id.code_text);
                codigo.append(": "+ resp.getCodigoEstacionamiento());

                //botón registrar
                Button registrar = (Button) mView.findViewById(R.id.btn_registrar);

                //Se registrar el ingreso en la base de datos
                registrar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //TODO: REGISTRAR INGRESO
                        Date fecha = new Date();
                        fecha = DateTime.now().toDate();

                        final Registro registo = Registro.builder()
                                .vehiculoIngresado(vehi)
                                .fecha(fecha)
                                .entrada((Registro.Entrada) listaPorteria.getSelectedItem())
                                .build();

                        ModelAdapter<Registro> registroModelAdapter = FlowManager.getModelAdapter(Registro.class);

                        registroModelAdapter.insert(registo);
                    }
                });
                mBuilder.setView(mView);
                AlertDialog dialog =mBuilder.create();
                dialog.show();

            }
        });

//        ViewGroup viewG = (ViewGroup) findViewById(android.R.id.content);
//
//        final LayoutInflater inflater = getLayoutInflater();
//        inflater.inflate(R.layout.activity_main,viewG );

//        // Mostrar la barrita
//        final ActionBar actionBar = super.getActionBar();
//        if (actionBar != null) {
////            actionBar.setLogo(R.drawable.ic_launcher_foreground);
//            actionBar.setDisplayUseLogoEnabled(true);
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeButtonEnabled(true);
//            actionBar.show();
//        }

//        // Row division
//        int[] colors = {0, 0xFFFFFFFF, 0};
//        this.getListView().setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
//        this.getListView().setDividerHeight(5);

//        // Adaptador de articles
//        this.vehiculoAdapter = new VehiculoDBFlowAdapter(this);
//        super.setListAdapter(this.vehiculoAdapter);

//        // Si no hay articulos en el adaptador (y por lo tanto en la base de datos) ..
//        if (this.vehiculoAdapter.isEmpty()) {
//            // .. ejecuto la tarea para obtenerlas.
//            this.getDataTask();
//        }
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

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     * <p>
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.registros:
                startActivity(new Intent(MainActivity.this, ListaRegistrosActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


