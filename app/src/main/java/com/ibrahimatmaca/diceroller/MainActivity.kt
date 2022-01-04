package com.ibrahimatmaca.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView
    lateinit var diceImage2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Get the button view from the layout and assign click
        // listener to it.
        val clearButton: Button = findViewById<Button>(R.id.clear_button)
        val rollButton: Button = findViewById<Button>(R.id.roll_button)
        rollButton.setOnClickListener{ rollDice() }
        clearButton.setOnClickListener{ clearDice() }
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)
    }

    private fun rollDice(){
        diceImage.setImageResource(getRandomDiceImage())
        diceImage2.setImageResource(getRandomDiceImage())
    }

    private fun clearDice(){
        diceImage.setImageResource(clearRandomDiceImage())
        diceImage2.setImageResource(clearRandomDiceImage())
    }

    private fun getRandomDiceImage(): Int {
        return when(Random().nextInt(6)+1){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun clearRandomDiceImage(): Int{
        return R.drawable.empty_dice
    }

}
