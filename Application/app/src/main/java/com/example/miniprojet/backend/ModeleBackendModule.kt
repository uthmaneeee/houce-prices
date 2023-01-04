package com.example.miniprojet.backend

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn( ViewModelComponent :: class )
abstract class ModeleBackendModule {
    @Binds
    abstract fun bindModeleBackend ( modeleBackend: ModeleBackend ): ModeleInterface
}