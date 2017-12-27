package cl.ucn.disc.dam.ucngate.activities;

import android.app.ListActivity;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;

import cl.ucn.disc.dam.ucngate.R;
import cl.ucn.disc.dam.ucngate.adapters.RegistroDBFlowAdapter;

public class ListaRegistrosActivity extends ListActivity {

    /**
     * Adapter de registros.
     */
    private BaseAdapter registrosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Row division
        int[] colors = {0, 0x00000000, 0};
        this.getListView().setDivider(new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, colors));
        this.getListView().setDividerHeight(5);

        // Adaptador de articles
        this.registrosAdapter = new RegistroDBFlowAdapter(this);
        super.setListAdapter(this.registrosAdapter);

    }
}


