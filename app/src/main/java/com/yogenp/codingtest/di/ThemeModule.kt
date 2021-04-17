package com.yogenp.codingtest.di

import android.content.Context
import com.yogenp.codingtest.persistence.ThemePreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ThemeModule {

    /*
    * Provide Theme Control
    * */
    @Singleton
    @Provides
    fun provideThemePreferences(@ApplicationContext app: Context): ThemePreferences{
        return ThemePreferences(app)
    }
}