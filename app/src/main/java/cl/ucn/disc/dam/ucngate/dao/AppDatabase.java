package cl.ucn.disc.dam.ucngate.dao;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * @author Claudio Gonzalez
 */

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION, foreignKeyConstraintsEnforced = true)
public final class AppDatabase {


    public static final String NAME = "AppDatabase";

    /**
     * La version
     */
    public static final int VERSION = 1;
}

