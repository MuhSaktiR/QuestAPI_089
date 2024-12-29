package com.example.activityremotedatabase

import android.app.Application
import com.example.activityremotedatabase.dependenciesinjection.AppContainer
import com.example.activityremotedatabase.dependenciesinjection.MahasiswaContainer

class MahasiswaApplications:Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}