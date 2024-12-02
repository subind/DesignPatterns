package behavioural.state.pattern.states

import behavioural.state.pattern.MediaPlayer

class PlayState: PlayerStates {

    override fun play(player: MediaPlayer) {
        println("Already playing")
    }

    override fun pause(player: MediaPlayer) {
        println("Pausing")
        player.currentState = PausedState()
    }

    override fun stop(player: MediaPlayer) {
        println("Stopping")
        player.currentState = StoppedState()
    }

    override fun loading(player: MediaPlayer) {
        println("Loading!!!")
        player.currentState = LoadingState()
    }

}