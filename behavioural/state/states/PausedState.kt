package behavioural.state.states

import behavioural.state.MediaPlayer

class PausedState: PlayerStates {

    override fun play(player: MediaPlayer) {
        println("Playing")
        player.currentState = PlayState()
    }

    override fun pause(player: MediaPlayer) {
        println("Already paused")
    }

    override fun stop(player: MediaPlayer) {
        println("Stopped")
        player.currentState = StoppedState()
    }

    override fun loading(player: MediaPlayer) {
        println("Loading!!!")
        player.currentState = LoadingState()
    }

}