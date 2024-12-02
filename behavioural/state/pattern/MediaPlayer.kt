package behavioural.state.pattern

import behavioural.state.pattern.states.PlayerStates

class MediaPlayer(initialState: PlayerStates) {

    /**
     * 1.
     * Pls note that the initial state is a 'StoppedState()'
     * Hence 'currentState' holds reference to 'StoppedState()
     * So whichever method of the below 3 is 1st to be called, it invokes method of that specific reference due to polymorphism
     */
    var currentState: PlayerStates = initialState

    fun play() = currentState.play(this)
    fun pause() = currentState.pause(this)
    fun stop() = currentState.stop(this)
    fun loading() = currentState.loading(this)
}