package behavioural.state.pattern.states

import behavioural.state.pattern.MediaPlayer

/**
 * Establishes the contract to adhere to for every concrete state
 */
interface PlayerStates {

    fun play(player: MediaPlayer)
    fun pause(player: MediaPlayer)
    fun stop(player: MediaPlayer)
    fun loading(player: MediaPlayer)
}