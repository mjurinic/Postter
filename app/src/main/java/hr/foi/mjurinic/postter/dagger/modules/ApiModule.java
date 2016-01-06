package hr.foi.mjurinic.postter.dagger.modules;

import com.squareup.okhttp.OkHttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hr.foi.mjurinic.postter.network.ApiService;
import retrofit.Converter;
import retrofit.Retrofit;

/**
 * Created by mjurinic on 06.01.16..
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public ApiService provideApiService(String baseUrl, OkHttpClient okHttpClient, Converter.Factory converterFactory) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(converterFactory);

        return builder.build().create(ApiService.class);
    }
}
