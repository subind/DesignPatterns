package creational.builder.pattern

/**
 * Using the Builder Pattern, the process of creating complex objects becomes structured, readable, and easy to maintain
 *
 * * Validation: Builders allow validation of mandatory fields during object construction (e.g., checking if name or age is set).
 *
 * * Ease of Maintenance: Adding a new parameter only requires adding a new method to the builder, without breaking existing code.
 *
 * * Readability: Each attribute is set explicitly with clear method names. This makes code easier to read and understand.
 *
 * * Immutability: The final object can be made immutable (val properties), improving safety.
 *
 * * Optional Parameters: No need to pass null for optional parameters.
 */

class User private constructor(
    val name: String,
    val age: Int,
    val email: String?,
    val phone: String?,
    val address: String?
) {
    class Builder {
        private var name: String = ""
        private var age: Int = 0
        private var email: String? = null
        private var phone: String? = null
        private var address: String? = null

        fun setName(name: String) = apply { this.name = name }
        fun setAge(age: Int) = apply { this.age = age }
        fun setEmail(email: String?) = apply { this.email = email }
        fun setPhone(phone: String?) = apply { this.phone = phone }
        fun setAddress(address: String?) = apply { this.address = address }

        fun build(): User {
            if (name.isBlank() || age <= 0) {
                throw IllegalStateException("Name and age must be set")
            }
            return User(name, age, email, phone, address)
        }
    }
}

fun main() {
    val user = User.Builder()
        .setName("John Doe")
        .setAge(25)
        .setEmail("john.doe@example.com")
        .setAddress("123 Main St")
        .build()

    println("Name: ${user.name}, Age: ${user.age}, Email: ${user.email}, Address: ${user.address}")
}

