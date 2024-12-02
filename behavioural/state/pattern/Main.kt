package behavioural.state.pattern

import behavioural.state.pattern.states.StoppedState

fun main() {

    val mediaPlayer = MediaPlayer(StoppedState())

    mediaPlayer.apply {
        /**
         * 2.
         * Here play() of StoppedState classes reference is invoked, since the currentState variable of MediaPlayer
         * holds reference of StoppedState on start-up
         */
        //User clicks play
        play()

        //User clicks pause
        pause()

        //User clicks stop
        stop()

        loading()

        loading()

        //User clicks play
        play()

        //User clicks play again
        play()

    }

}