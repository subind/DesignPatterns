package behavioural.state.novice

fun main() {
    val player = MediaPlayer()

    player.play()  // Output: Playing from the beginning.
    player.pause() // Output: Pausing playback.
    player.stop()  // Output: Stopping playback.
    player.play()  // Output: Playing from the beginning.
}
