package me.jackfangqi.mavrick.learning

import android.app.Application
import com.airbnb.mvrx.Mavericks
import timber.log.Timber

/**
 * create by FangQi on 15:33, 周四, 2022/1/6
 * fangqi.jack@bytedance.com
 *
 * 描述：--
 **/
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        Timber.tag("Mavericks").d("initialize Mavericks")
        Mavericks.initialize(this)
    }
}