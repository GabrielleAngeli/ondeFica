package br.com.alura.ondefica

import android.app.Application
import br.com.alura.ondefica.di.appModule
import br.com.alura.ondefica.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class OndeFicaApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@OndeFicaApplication)
            modules(appModule, networkModule)
        }
    }
}