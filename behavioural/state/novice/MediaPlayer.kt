package behavioural.state.novice

class MediaPlayer {
    private var currentState: String = "STOP"

    fun play() {
        when (currentState) {
            "STOP" -> {
                println("Playing from the beginning.")
                currentState = "PLAY"
            }
            "PAUSE" -> {
                println("Resuming playback.")
                currentState = "PLAY"
            }
            "PLAY" -> {
                println("Already playing.")
            }
        }
    }

    fun pause() {
        when (currentState) {
            "PLAY" -> {
                println("Pausing playback.")
                currentState = "PAUSE"
            }
            "STOP" -> {
                println("Cannot pause. Media is stopped.")
            }
            "PAUSE" -> {
                println("Already paused.")
            }
        }
    }

    fun stop() {
        when (currentState) {
            "PLAY", "PAUSE" -> {
                println("Stopping playback.")
                currentState = "STOP"
            }
            "STOP" -> {
                println("Already stopped.")
            }
        }
    }
}
