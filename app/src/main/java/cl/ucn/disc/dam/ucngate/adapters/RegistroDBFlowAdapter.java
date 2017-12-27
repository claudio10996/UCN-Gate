package cl.ucn.disc.dam.ucngate.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.raizlabs.android.dbflow.list.FlowCursorList;
import com.raizlabs.android.dbflow.sql.language.OrderBy;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.w3c.dom.Text;

import cl.ucn.disc.dam.ucngate.R;
import cl.ucn.disc.dam.ucngate.model.Registro;
import cl.ucn.disc.dam.ucngate.model.Registro_Table;
import cl.ucn.disc.dam.ucngate.model.Vehiculo;
import cl.ucn.disc.dam.ucngate.model.Vehiculo_Table;
import lombok.NonNull;

/**
 * Created by arago on 27-Dec-17.
 */

public final class RegistroDBFlowAdapter extends BaseAdapter {
    /**
     * FlowDB
     */
    private final FlowCursorList<Registro> flowCursorList;

    /**
     * Context
     */
    private final Context context;

    /**
     *
     * @param context to get the {@link LayoutInflater}.
     */
    public RegistroDBFlowAdapter(@NonNull final Context context) {

        this.context = context;
            // SQL to get data
            this.flowCursorList = new FlowCursorList.Builder<>(
                    SQLite.select()
                            .from(Registro.class)
                            .orderBy(OrderBy.fromProperty(Registro_Table.fecha))
            ).build();

    }

    /**
     * How many items are in the data set represented by this Adapter.
     *
     * @return Count of items.
     */
    @Override
    public int getCount() {
        return (int) flowCursorList.getCount();
    }

    /**
     * Get the data item associated with the specified position in the data set.
     *
     * @param position Position of the item whose data we want within the adapter's
     *                 data set.
     * @return The data at the specified position.
     */
    @Override
    public Registro getItem(int position) {
        return flowCursorList.getItem(position);
    }

    /**
     * Get the row id associated with the specified position in the list.
     *
     * @param position The position of the item within the adapter's data set whose row id we want.
     * @return The id of the item at the specified position.
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * Get a View that displays the data at the specified position in the data set. You can either
     * create a View manually or inflate it from an XML layout file. When the View is inflated, the
     * parent View (GridView, ListView...) will apply default layout parameters unless you use
     * {@link LayoutInflater#inflate(int, ViewGroup, boolean)}
     * to specify a root view and to prevent attachment to the root.
     *
     * @param position    The position of the item within the adapter's data set of the item whose view
     *                    we want.
     * @param convertView The old view to reuse, if possible. Note: You should check that this view
     *                    is non-null and of an appropriate type before using. If it is not possible to convert
     *                    this view to display the correct data, this method can create a new view.
     *                    Heterogeneous lists can specify their number of view types, so that this View is
     *                    always of the right type (see {@link #getViewTypeCount()} and
     *                    {@link #getItemViewType(int)}).
     * @param parent      The parent that this view will eventually be attached to
     * @return A View corresponding to the data at the specified position.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final RegistroDBFlowAdapter.ViewHolder viewHolder;
        final View view;

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_registro, parent, false);
            viewHolder = new RegistroDBFlowAdapter.ViewHolder(view);
            view.setTag(viewHolder);

        } else {
            view = convertView;
            viewHolder = (RegistroDBFlowAdapter.ViewHolder) convertView.getTag();
        }

        final Registro registro = this.getItem(position);
        if (registro != null) {

            viewHolder.fecha.setText((CharSequence) registro.getFecha());
            viewHolder.hora.setText((int) registro.getFecha().getTime());
            viewHolder.patente.setText(registro.getVehiculoIngresado().getPatente());
            viewHolder.nombre.setText(registro.getVehiculoIngresado().getResponsable().getNombre());
            viewHolder.marca.setText(registro.getVehiculoIngresado().getMarca());
            viewHolder.anio.setText(registro.getVehiculoIngresado().getAnio());
            viewHolder.tipo.setText(registro.getVehiculoIngresado().getResponsable().getTipo().toString());

        }

        return view;
    }

    /**
     * Viewholder pattern
     */
    private static class ViewHolder {

        TextView fecha;
        TextView hora;
        TextView patente;
        TextView nombre;
        TextView marca;
        TextView anio;
        TextView tipo;

        ViewHolder(final View view) {
            this.fecha = view.findViewById(R.id.rr_fecha);
            this.hora = view.findViewById(R.id.rr_hora);
            this.patente = view.findViewById(R.id.rr_patente);
            this.nombre = view.findViewById(R.id.rr_nombre);
            this.marca = view.findViewById(R.id.rr_marca);
            this.anio = view.findViewById(R.id.rr_anio);
            this.tipo = view.findViewById(R.id.rr_tipo);
        }

    }
}
