package com.adsulganesh.tictactoe

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buClick(view: View) {

        var buSelected = view as Button

        var cellID:Int = 0

        when(buSelected.id){

            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9

        }

        Log.d("buClick:",buSelected.id.toString())
        Log.d("buClick: CellId:",cellID.toString())

        playGame(cellID,buSelected)
    }

    var activePlayer = 1

    var player1 = arrayListOf<Int>()
    var player2 = arrayListOf<Int>()
    var count:Int = 0

    fun playGame(cellID:Int, buSelected:Button) {
        val view:View
        if(activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundResource(R.color.lightBlue)
            player1.add(cellID)
            activePlayer = 2
            count++
        }
        else{
            buSelected.text = "O"
            buSelected.setBackgroundResource(R.color.lightGreen)
            player2.add(cellID)
            activePlayer = 1
            count++
        }
        buSelected.isEnabled = false
        if(count==9) {
            buReset1()
            Toast.makeText(this,"Draw",Toast.LENGTH_LONG).show()
        }else {
            checkWinner()
        }
    }

    fun checkWinner() {
        var winner = -1
        //row one
        if(player1.contains(1) && player1.contains(2) && player1.contains(3))
        {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3))
        {
            winner = 2
        }

        //row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6))
        {
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6))
        {
            winner = 2
        }

        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9))
        {
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9))
        {
            winner = 2
        }


        //col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7))
        {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7))
        {
            winner = 2
        }

        //col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8))
        {
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8))
        {
            winner = 2
        }

        //col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9))
        {
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9))
        {
            winner = 2
        }

        //Diagonal 1
        if(player1.contains(1) && player1.contains(5) && player1.contains(9))
        {
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9))
        {
            winner = 2
        }

        //Diagonal 2
        if(player1.contains(3) && player1.contains(5) && player1.contains(7))
        {
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7))
        {
            winner = 2
        }

        if(winner == 1)
        {
            Toast.makeText(this,"Player 1 Won the game.",Toast.LENGTH_LONG).show()
            winner = -1
            buReset1()
        }else if(winner == 2)
        {
            Toast.makeText(this,"Player 2 Won the game.",Toast.LENGTH_LONG).show()
            winner = -1
            buReset1()
        }


    }

    fun buReset1() {

        player1.clear()
        player2.clear()
        activePlayer = 1
        count = 0
        var buttons = arrayListOf<Button>()
        buttons.add(findViewById(R.id.bu1))
        buttons.add(findViewById(R.id.bu2))
        buttons.add(findViewById(R.id.bu3))
        buttons.add(findViewById(R.id.bu4))
        buttons.add(findViewById(R.id.bu5))
        buttons.add(findViewById(R.id.bu6))
        buttons.add(findViewById(R.id.bu7))
        buttons.add(findViewById(R.id.bu8))
        buttons.add(findViewById(R.id.bu9))

        for (btn in buttons)
        {
            btn.isEnabled = true
            btn.text = ""
            btn.setBackgroundResource(R.color.white)
        }
    }

    fun buReset1(view: View) {
        buReset1()
    }


}
