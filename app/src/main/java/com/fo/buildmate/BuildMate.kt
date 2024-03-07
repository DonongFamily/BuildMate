package com.fo.buildmate

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BuildMate: Application() {
    val REQUEST_MAX_COUNT = 3
}