package demos

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager

/**
 * BroadcastReceiver 广播接收器演示
 * 展示系统广播和自定义广播的使用
 */
class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView
    private lateinit var localBroadcastManager: LocalBroadcastManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.resultText)
        localBroadcastManager = LocalBroadcastManager.getInstance(this)

        // 发送自定义广播
        findViewById<Button>(R.id.sendBroadcastBtn).setOnClickListener {
            sendCustomBroadcast()
        }

        // 发送本地广播
        findViewById<Button>(R.id.sendLocalBtn).setOnClickListener {
            sendLocalBroadcast()
        }

        // 注册本地广播接收器
        val filter = IntentFilter("demos.LOCAL_ACTION")
        localBroadcastManager.registerReceiver(localReceiver, filter)
    }

    private fun sendCustomBroadcast() {
        val intent = Intent("demos.CUSTOM_ACTION")
        intent.putExtra("message", "自定义广播消息")
        sendBroadcast(intent)
        resultText.text = "已发送自定义广播"
    }

    private fun sendLocalBroadcast() {
        val intent = Intent("demos.LOCAL_ACTION")
        intent.putExtra("message", "本地广播消息")
        localBroadcastManager.sendBroadcast(intent)
        resultText.text = "已发送本地广播"
    }

    // 本地广播接收器
    private val localReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val message = intent?.getStringExtra("message") ?: ""
            resultText.text = "收到本地广播: $message"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        localBroadcastManager.unregisterReceiver(localReceiver)
    }
}
