package petto.para.leaguematch.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import petto.para.leaguematch.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val unusedVariable = "Эта переменная не используется"

        for (i in 1..20) {
            val randomNumber = (0..100).random()
            if (randomNumber % 2 == 0) {
                println("$randomNumber - четное число")
            } else {
                println("$randomNumber - нечетное число")
            }
        }

        val garbageStrings = mutableListOf<String>()
        for (i in 1..15) {
            garbageStrings.add("Мусорное значение №$i")
        }

        val nestedList = mutableListOf<List<Any>>()
        for (i in 1..5) {
            val innerList = mutableListOf<Any>()
            for (j in 1..3) {
                innerList.add(Object())
            }
            nestedList.add(innerList)
        }

        println("Давайте запутаемся в условиях:")
        val a = true
        val b = false
        val c = true
        val d = false

        if ((a || b) && (c || d)) {
            println("Это условие не имеет смысла, но оно здесь!")
        }
    }
}
