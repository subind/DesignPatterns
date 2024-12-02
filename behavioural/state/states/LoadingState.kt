package behavioural.state.states

import behavioural.state.MediaPlayer

class LoadingState: PlayerStates {

    override fun play(player: MediaPlayer) {
        println("Playing")
        player.currentState = PlayState()
    }

    override fun pause(player: MediaPlayer) {
        println("Pausing")
        player.currentState = PausedState()
    }

    override fun stop(player: MediaPlayer) {
        println("Stopped")
        player.currentState = StoppedState()
    }

    override fun loading(player: MediaPlayer) {
        println("Already loading!!!")
    }

}