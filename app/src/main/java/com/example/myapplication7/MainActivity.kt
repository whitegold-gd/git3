package com.example.myapplication7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.databinding.DataBindingUtil
import com.example.myapplication7.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var image: ImageView
    private lateinit var vevent: EditText
    private lateinit var vdate: EditText
    private lateinit var vtime: EditText
    private lateinit var post: EditText

    val text = """
                Записано!
                Событие: ${vevent.text}
                Дата: ${vdate.text}
                Время: ${vtime.text}
                Заметки: ${post.text}
            """

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vevent = findViewById(R.id.vevent)
        vdate = findViewById(R.id.vdate)
        vtime = findViewById(R.id.vtime)
        image = findViewById(R.id.mood)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        post = findViewById(R.id.post)

        DataBindingUtil.setContentView<ActivityMainBinding>(
            this, R.layout.activity_main
        ).apply { mainActivity = this@MainActivity   }

        moodChange(findViewById(radioGroup.checkedRadioButtonId))
    }

    fun moodChange(view: View) {
        if (view is RadioButton) {

            val image = when (view.getId()) {
                R.id.good -> R.drawable.cheerful
                else -> R.drawable.cry
            }

            if (view.isChecked)
                this.image.setImageResource(image)
        }
    }

    fun update(view: View) {
        if (view is Button) {
            text.trimIndent()

            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
            vevent.text.clear()
            vdate.text.clear()
            vtime.text.clear()
            post.text.clear()
        }
    }
}