package com.example.debugging

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.concurrent.thread

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Khởi tạo TextView một lần
        val helloTextView: TextView = findViewById(R.id.division_textview)
        helloTextView.text = "hello, debugging"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. GỌI HÀM DIVISION TỪ ONCREATE
        division()
    }

    // 2. ĐỊNH NGHĨA HÀM DIVISION LÀ PHƯƠNG THỨC CỦA ACTIVITY
    private fun division() {
        val numerator = 60
        var denominator = 4

        thread(start = true) {
            // Đặt repeat(5) để sau 4 lần lặp, denominator sẽ bằng 0 và crash ứng dụng
            repeat(5) {
                Thread.sleep(3000)

                // 3. SỬ DỤNG runOnUiThread để cập nhật UI từ luồng nền
                runOnUiThread {
                    //findViewById hoạt động bình thường trong phương thức của Activity
                    findViewById<TextView>(R.id.division_textview).setText("${numerator / denominator}")
                    denominator--
                }
            }
        }
    }
}
// Đã xóa hàm private fun division() dư thừa ở cuối file