package com.fadzrian.tictactoe

import kotlin.random.Random

class MoveUtils {
    companion object {
        fun getNextMove(
            player1: ArrayList<Int>,
            player2: ArrayList<Int>,
            computer: ArrayList<Int>
        ) : Int {
            //algortima dapeting comMove
            var comMove = Random.nextInt(1, 10)
            // pola serang saat komputer bergerak
            // row 1
            if (computer.contains(1) && player2.contains(2) && player2.contains(3)) comMove = 1
            else if (player2.contains(1) && computer.contains(2) && player2.contains(3)) comMove = 2
            else if (player2.contains(1) && player2.contains(2) && computer.contains(3)) comMove = 3
            // row 2
            else if (computer.contains(4) && player2.contains(5) && player2.contains(6)) comMove = 4
            else if (player2.contains(4) && computer.contains(5) && player2.contains(6)) comMove = 5
            else if (player2.contains(4) && player2.contains(5) && computer.contains(6)) comMove = 6
            // row 3
            else if (computer.contains(7) && player2.contains(8) && player2.contains(9)) comMove = 7
            else if (player2.contains(7) && computer.contains(8) && player2.contains(9)) comMove = 8
            else if (player2.contains(7) && player2.contains(8) && computer.contains(9)) comMove = 9
            // diagonal 1
            else if (computer.contains(1) && player2.contains(5) && player2.contains(9)) comMove = 1
            else if (player2.contains(1) && computer.contains(5) && player2.contains(9)) comMove = 5
            else if (player2.contains(1) && player2.contains(5) && computer.contains(9)) comMove = 9
            // diagonal 2
            else if (computer.contains(3) && player2.contains(5) && player2.contains(7)) comMove = 3
            else if (player2.contains(3) && computer.contains(5) && player2.contains(7)) comMove = 5
            else if (player2.contains(3) && player2.contains(5) && computer.contains(7)) comMove = 7
            // col 1
            else if (computer.contains(1) && player2.contains(4) && player2.contains(7)) comMove = 1
            else if (player2.contains(1) && computer.contains(4) && player2.contains(7)) comMove = 4
            else if (player2.contains(1) && player2.contains(4) && computer.contains(7)) comMove = 7
            // col 2
            else if (computer.contains(2) && player1.contains(5) && player1.contains(8)) comMove = 2
            else if (player1.contains(2) && computer.contains(5) && player1.contains(8)) comMove = 5
            else if (player1.contains(2) && player1.contains(5) && computer.contains(8)) comMove = 8
            // col 3
            else if (computer.contains(3) && player2.contains(6) && player2.contains(9)) comMove = 3
            else if (player2.contains(3) && computer.contains(6) && player2.contains(9)) comMove = 6
            else if (player2.contains(3) && player2.contains(6) && computer.contains(9)) comMove = 9

            // pola bertahan saat computer bergerak
            // row 1
            else if (computer.contains(1) && player1.contains(2) && player1.contains(3)) comMove = 1
            else if (player1.contains(1) && computer.contains(2) && player1.contains(3)) comMove = 2
            else if (player1.contains(1) && player1.contains(2) && computer.contains(3)) comMove = 3
            // row 2
            else if (computer.contains(4) && player1.contains(5) && player1.contains(6)) comMove = 4
            else if (player1.contains(4) && computer.contains(5) && player1.contains(6)) comMove = 5
            else if (player1.contains(4) && player1.contains(5) && computer.contains(6)) comMove = 6
            // row 3
            else if (computer.contains(7) && player1.contains(8) && player1.contains(9)) comMove = 7
            else if (player1.contains(7) && computer.contains(8) && player1.contains(9)) comMove = 8
            else if (player1.contains(7) && player1.contains(8) && computer.contains(9)) comMove = 9
            // diagonal 1
            else if (computer.contains(1) && player1.contains(5) && player1.contains(9)) comMove = 1
            else if (player1.contains(1) && computer.contains(5) && player1.contains(9)) comMove = 5
            else if (player1.contains(1) && player1.contains(5) && computer.contains(9)) comMove = 9
            // diagonal 2
            else if (computer.contains(3) && player1.contains(5) && player1.contains(7)) comMove = 3
            else if (player1.contains(3) && computer.contains(5) && player1.contains(7)) comMove = 5
            else if (player1.contains(3) && player1.contains(5) && computer.contains(7)) comMove = 7
            // col 1
            else if (computer.contains(1) && player1.contains(4) && player1.contains(7)) comMove = 1
            else if (player1.contains(1) && computer.contains(4) && player1.contains(7)) comMove = 4
            else if (player1.contains(1) && player1.contains(4) && computer.contains(7)) comMove = 7
            // col 2
            else if (computer.contains(2) && player1.contains(5) && player1.contains(8)) comMove = 2
            else if (player1.contains(2) && computer.contains(5) && player1.contains(8)) comMove = 5
            else if (player1.contains(2) && player1.contains(5) && computer.contains(8)) comMove = 8
            // col 3
            else if (computer.contains(3) && player1.contains(6) && player1.contains(9)) comMove = 3
            else if (player1.contains(3) && computer.contains(6) && player1.contains(9)) comMove = 6
            else if (player1.contains(3) && player1.contains(6) && computer.contains(9)) comMove = 9

            else if (computer.contains(5) && comMove < 5 ) comMove = 5

            else {
                while (player1.contains(comMove) || player2.contains(comMove)) {
                    comMove = Random.nextInt(1, 10)
                }
            }
            return comMove
        }
        /*
        fun winLogic(player1: ArrayList<Int>, player2: ArrayList<Int>,computer: ArrayList<Int>): Int {
            var playerWin = 0
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

            return playerWin
        } */
    }
}