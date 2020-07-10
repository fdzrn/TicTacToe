package com.fadzrian.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var listCell = ArrayList<Button>()
    var gamemode = 1

    var win = 0
    var lose = 0
    var draw = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listCell = arrayListOf(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)

        play_with_com.setOnClickListener {
            tv_info_gameplay.text = getString(R.string.single_player)
            gamemode = 1
            restartGame(btn_restart)
            win = 0
            lose = 0
            draw = 0
            tv_result_win.text = "0"
            tv_result_lose.text = "0"
            tv_result_draw.text = "0"
            tv_win.text = "Win = "
            tv_lose.text = "Lose = "
        }

        play_with_friend.setOnClickListener {
            tv_info_gameplay.text = getString(R.string.multi_player)
            gamemode = 2
            restartGame(btn_restart)
            win = 0
            lose = 0
            draw = 0
            tv_result_win.text = "0"
            tv_result_lose.text = "0"
            tv_result_draw.text = "0"
            tv_win.text = "Player 1 Win = "
            tv_lose.text = "Player 2 Win = "
        }

    }

    fun cellSelected(view: View) {
        val placeSelected = view as Button
        var cellID = 0
        when (placeSelected.id) {
            R.id.btn1 -> cellID = 1
            R.id.btn2 -> cellID = 2
            R.id.btn3 -> cellID = 3
            R.id.btn4 -> cellID = 4
            R.id.btn5 -> cellID = 5
            R.id.btn6 -> cellID = 6
            R.id.btn7 -> cellID = 7
            R.id.btn8 -> cellID = 8
            R.id.btn9 -> cellID = 9
        }
        playGame(cellID, placeSelected)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1

    private fun playGame(cellID: Int, placeSelected: Button) {
        when (activePlayer) {
            1 -> {
                placeSelected.text = "O"
                player1.add(cellID)
                activePlayer = 2
            }
            2 -> {
                placeSelected.text = "X"
                player2.add(cellID)
                activePlayer = 1
            }
        }
        placeSelected.isEnabled = false
        checkWinner()

        // buat komputerbiar bisa jalan sendiri
        if (gamemode == 1 && activePlayer == 2 && playerWin == 0) {
            Handler().postDelayed({ autoPlay() }, 300)
        }
    }

    var computer = ArrayList<Int>()
    private fun autoPlay() {
        computer.clear()
        for (i in 1..9) {
            if (!player1.contains(i) && !player2.contains(i)) {
                computer.add(i)
            }
        }
        // cell yang di pilih computer secara random
        val comMove = MoveUtils.getNextMove(player1,player2,computer)
        playGame(comMove,listCell[comMove - 1])
    }


    var playerWin = 0
    private fun checkWinner() {
        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) playerWin = 1
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) playerWin = 2
        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) playerWin = 1
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) playerWin = 2
        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) playerWin = 1
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) playerWin = 2

        //col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) playerWin = 1
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) playerWin = 2

        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) playerWin = 1
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) playerWin = 2

        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) playerWin = 1
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) playerWin = 2

        // diagonal 1
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) playerWin = 1
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) playerWin = 2

        // diagonal 2
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) playerWin = 1
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) playerWin = 2

        // menentukan hasil pertandingan
        if (playerWin != 0) {
            when (playerWin) {
                1 -> {
                    if (playerWin == 1 && gamemode == 1 || gamemode == 2) {
                        updateResultWin()
                        tv_info_gameplay.text = getString(R.string.player1_win)
                    }

                }
                2 -> {
                    if (playerWin == 2 &&  gamemode == 1) {
                        updateResultLose()
                        tv_info_gameplay.text = "Computer Win"
                    } else if(playerWin == 2 && gamemode == 2) {
                        updateResultLose()
                        tv_info_gameplay.text = getString(R.string.player2_win)
                    }
                }
            }
            for (i in 0..8) {
                listCell[i].isEnabled = false
            }
        }
        // ini yang menentukan pertandingan berakhir seri
        if (playerWin == 0 && player1.size + player2.size == 9) {
            playerWin = 3
            tv_info_gameplay.text = getString(R.string.draw)
            updateResultDraw()
        }
    }

    fun restartGame(view: View) {
        player1.clear()
        player2.clear()
        playerWin = 0
        activePlayer = 1

        when (gamemode) {
            1 -> tv_info_gameplay.text = getString(R.string.single_player)
            2 -> tv_info_gameplay.text = getString(R.string.multi_player)
        }
        for (i in 0..8) {
            listCell[i].text = ""
            listCell[i].isEnabled = true
        }
    }

    //fungsi untuk update data win,lose,draw
    fun updateResultWin() {
        win++
        tv_result_win.text = win.toString()
    }

    fun updateResultLose() {
        lose++
        tv_result_lose.text = lose.toString()
    }

    fun updateResultDraw() {
        draw++
        tv_result_draw.text = draw.toString()
    }
}
