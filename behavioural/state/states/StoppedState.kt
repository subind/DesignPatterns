package behavioural.state.states

import behavioural.state.MediaPlayer

class StoppedState: PlayerStates {

    override fun play(player: MediaPlayer) {
        println("Playing")
        player.currentState = PlayState()
    }

    override fun pause(player: MediaPlayer) {
        println("Pausing")
        player.currentState = PausedState()
    }

    override fun stop(player: MediaPlayer) {
        println("Already stopped")
    }

    override fun loading(player: MediaPlayer) {
        println("Loading!!!")
        player.currentState = LoadingState()
    }

}