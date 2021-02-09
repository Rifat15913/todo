package com.todo.app.utils.helper

import android.content.Context.BATTERY_SERVICE
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import com.todo.app.BaseApplication


object BatteryUtils {
    fun getBatteryPercentage(): Int {
        val context = BaseApplication.getBaseApplicationContext()
        return if (Build.VERSION.SDK_INT >= 21) {
            val batteryManager = context.getSystemService(BATTERY_SERVICE) as BatteryManager
            batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
        } else {
            val batteryStatus: Intent? =
                context.registerReceiver(
                    null,
                    IntentFilter(Intent.ACTION_BATTERY_CHANGED)
                )

            val level = batteryStatus?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
            val scale = batteryStatus?.getIntExtra(BatteryManager.EXTRA_SCALE, -1) ?: -1
            val batteryPercentage = level / scale.toDouble()

            (batteryPercentage * 100).toInt()
        }
    }
}