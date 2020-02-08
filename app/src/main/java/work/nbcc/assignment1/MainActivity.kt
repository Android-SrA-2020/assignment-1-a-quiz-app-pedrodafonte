package work.nbcc.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true)
    )

    private var questionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_next).setOnClickListener {
            questionIndex = (questionIndex + 1) % 20
            findViewById<TextView>(R.id.question_text).setText(questionBank[questionIndex].textResId)
        }

        findViewById<Button>(R.id.btn_previous).setOnClickListener {
            questionIndex = if(questionIndex == 0)
            {
                questionBank.size - 1
            } else {
                (questionIndex - 1) % 20
            }
            findViewById<TextView>(R.id.question_text).setText(questionBank[questionIndex].textResId)
        }

        findViewById<Button>(R.id.btn_true).setOnClickListener {
            answer(true)
        }

        findViewById<Button>(R.id.btn_false).setOnClickListener {
            answer(false)
        }
    }

    private fun answer(answer: Boolean) {
        if(answer == questionBank[questionIndex].answer){
            Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show()
        }
    }
}
