package structural.facade.novice

// JsonParser.kt
class JsonParser {
    fun parse(json: String): Map<String, Any> {
        println("Parsing JSON with Gson: $json")
        return mapOf("name" to "John", "age" to 30) // Simulated parsed data
    }
}
