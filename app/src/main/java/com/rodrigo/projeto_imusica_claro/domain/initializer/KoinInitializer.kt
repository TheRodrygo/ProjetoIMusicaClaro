package com.rodrigo.projeto_imusica_claro.domain.initializer

import android.content.Context
import androidx.startup.Initializer
import com.rodrigo.projeto_imusica_claro.data.di.repositoryModules
import com.rodrigo.projeto_imusica_claro.data.network.service.serviceModules
import com.rodrigo.projeto_imusica_claro.domain.di.useCaseModules
import com.rodrigo.projeto_imusica_claro.presentation.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

class KoinInitializer : Initializer<KoinApplication> {
    override fun create(context: Context): KoinApplication {
        return startKoin {
            androidContext(context)
            androidFileProperties()
            modules(
                viewModelModules,
                serviceModules,
                repositoryModules,
                useCaseModules
            )
        }
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return mutableListOf()
    }
}