package com.example.hosseini.weatherappfinal;

/**
 * Created by hosseini on 7/22/2016.
 */
public abstract class ICallback<T> {

    public abstract void callback(final T result) throws Exception;


}
