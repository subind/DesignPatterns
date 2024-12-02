Intro :-
It's a pattern in which an object(subject) notifies a group of dependant objects(observers),
regarding any changes in state.
This pattern ensures that the observers stay upToDate with the subject it is subscribed to,
without the subject needing to know the implementation details of its subscribers.

Benefits :-
* Promotes Loose-coupling
    Subjects need not know about the implementation details of the observers.
* Scalability
    Observers can be added/removed, without affecting the subject.
* RealTime updates
    Helps in achieving consistency across all observers.


Drawbacks :-
* Performance overhead
    Notifying large no: of observers is expensive.
* Memory leaks
    If not detached properly, could lead to memory leaks.
* Notification sequencing
    If not handled in the right lifecycle, could lead to unexpected behaviours.