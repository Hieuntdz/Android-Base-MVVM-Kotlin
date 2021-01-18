package com.nthieu.base_mvvm.utils

/**
 * Aitruck
 * Created by Nguyen Trung Hieu on 1/18/2021.
 * Phone, telegram : 0372.810.001.
 * Email : nthieuhpcntt@gmail.com
 */

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.log

class Logger {
    companion object {
        private const val isLog: Boolean = true
        private val level = LoggerType.DEBUG.ordinal
        const val tag = "Reader ConsoleLog"
        fun debug(tag: String, msg: String) = log(LoggerType.DEBUG, tag, msg)
        fun debug(msg: String) = log(LoggerType.DEBUG, tag, msg)
        fun info(tag: String, msg: String) = log(LoggerType.INFO, tag, msg)
        fun error(tag: String, msg: String) = log(LoggerType.ERROR, tag, msg)
        fun warning(tag: String, msg: String) = log(LoggerType.WARNING, tag, msg)


        private fun log(type: LoggerType, tag: String, msg: String) {
            if (isLog && type.ordinal >= level) {
                val sdf = SimpleDateFormat("yyyy/MM/dd_HH:mm:ss", Locale.getDefault())
                val now: String = sdf.format(Date())
                when (type) {
                    LoggerType.DEBUG -> Log.d(tag, "$now : $msg")
                    LoggerType.INFO -> Log.i(tag, "$now : $msg")
                    LoggerType.ERROR -> Log.e(tag, "$now : $msg")
                    LoggerType.WARNING -> Log.w(tag, "$now : $msg")
                }
            }
        }
    }


}

enum class LoggerType {
    DEBUG,
    INFO,
    WARNING,
    ERROR,
}