package creational.builder.novice

fun main() {

    /**
     * 1st approach :-
     * Using a Constructor with All Parameters
     * ---------------------------------------
     * Issues with this approach :-
     *  * Hard to maintain: Adding or removing parameters requires changing all usages.
     *  * Hard to read: What do all these parameters mean?.
     *  * Optional parameters result in many null values.
     */

    class UserA(val name: String, val age: Int, val email: String?, val phone: String?, val address: String?)

    //Object creation
    val userAobj = UserA("John", 25, "john@example.com", null, "123 Main St")



    /**
     * 2nd approach :-
     * Using Overloaded Constructors
     * -----------------------------
     * Issues with this approach :-
     *  * Leads to constructor overloading, which becomes unmanageable as the number of parameters increases.
     *  * The intent of each constructor becomes unclear.
     */

    class UserB {
        constructor(name: String, age: Int)
        constructor(name: String, age: Int, email: String)
        constructor(name: String, age: Int, email: String, phone: String)
    }


    /**
     * 3rd approach :-
     * Using Setter Methods After Object Creation
     * ------------------------------------------
     * Issues with this approach :-
     *  * Objects can be in an incomplete state if not all required properties are set.
     *  * Debugging becomes harder when objects aren't properly initialized.
     */

    class UserC {
        var name: String = ""
        var age: Int = 0
        var email: String? = null
        var phone: String? = null
        var address: String? = null
    }

    val userCobj = UserC().apply {
        name = "John"
        age = 25
        email = "john@example.com"
        address = "123 Main St"
    }



}