package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Carrega uma lista de earthquakes usando uma AsyncTask para realizar a
 * requisição de rede para a dada URL.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /** Tag para mensagens de log */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    /** URL da busca */
    private String mUrl;

    /**
     * Constrói um novo {@link EarthquakeLoader}.
     *
     * @param context O contexto da activity
     * @param url A URL de onde carregaremos dados
     */
    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.d(LOG_TAG, "Called onStartLoading()");
        forceLoad();
    }

    /**
     * Está e uma thread de background.
     */
    @Override
    public List<Earthquake> loadInBackground() {

        Log.d(LOG_TAG, "Called loadInBackground()");

        if (mUrl == null) {
            return null;
        }

        // Realiza requisição de rede, decodifica a resposta, e extrai uma lista de earthquakes.
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakesData(mUrl);
        return earthquakes;
    }
}