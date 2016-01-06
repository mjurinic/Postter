package hr.foi.mjurinic.postter.dagger.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.DateTime;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.helpers.DateTimeSerializer;
import retrofit.Converter;
import retrofit.GsonConverterFactory;

/**
 * Created by mjurinic on 06.01.16..
 */
@Module
public class GsonConverterModule {

    @Provides
    @Singleton
    public Converter.Factory provideConverterFactory() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(DateTime.class, new DateTimeSerializer())
                .create();

        return GsonConverterFactory.create(gson);
    }
}
