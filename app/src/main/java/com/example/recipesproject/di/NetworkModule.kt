package com.example.recipesproject.di

import com.example.recipesproject.recipes.data.remote.RecipesRemoteDataSource
import com.example.recipesproject.retrofit.RecipesApi
import com.example.recipesproject.util.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get()) }
    single { provideRecipesApi(get()) }
    single { RecipesRemoteDataSource(get()) }
}

fun provideInterceptor(): Interceptor {
    return Interceptor { chain ->
        val url = chain.request()
                                .url()
                                .newBuilder()
                                .addQueryParameter("key", Constants.API_KEY)
                                .build()

        val request = chain.request()
                                    .newBuilder()
                                    .url(url)
                                    .build()

        chain.proceed(request)
    }
}

fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
}

fun provideRecipesApi(retrofit: Retrofit): RecipesApi {
    return retrofit.create(RecipesApi::class.java)
}
