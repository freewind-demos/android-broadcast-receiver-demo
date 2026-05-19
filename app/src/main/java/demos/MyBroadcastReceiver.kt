package demos.android.broadcast.receiver.demo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 * 自定义 BroadcastReceiver
 * 用于接收自定义广播
 */
class MyBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        // 接收广播并处理
        val message = intent?.getStringExtra("message") ?: ""
        Toast.makeText(context, "收到广播: $message", Toast.LENGTH_SHORT).show()
    }
}
