package org.ar.call

import android.app.Activity
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentResolver
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.lifecycle.*
import com.kongzue.dialogx.DialogX
import com.kongzue.dialogx.style.IOSStyle
import org.ar.call.utils.SpUtil
import kotlin.properties.Delegates
import android.media.AudioAttributes
import android.net.Uri


class CallApplication :Application(), ViewModelStoreOwner,Application.ActivityLifecycleCallbacks{

    private val appViewModel by lazy { ViewModelStore() }
    var curActivity:Activity? = null

    companion object{
        var callApp : CallApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        callApp = this
        SpUtil.init(this)
        DialogX.init(this)
        DialogX.cancelButtonText="取消"
        DialogX.globalStyle = IOSStyle.style();
        registerActivityLifecycleCallbacks(this)
    }

    override fun getViewModelStore(): ViewModelStore {
        return appViewModel
    }


    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
    }

    override fun onActivityStarted(activity: Activity) {
        curActivity = activity
    }

    override fun onActivityResumed(activity: Activity) {
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
    }

    override fun onActivityDestroyed(activity: Activity) {
    }


}