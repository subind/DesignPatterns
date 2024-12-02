package structural.facade.pattern.abstractions

class GsonJsonParser : IJsonParser {
    override fun parse(json: String): Map<String, Any> {
        println("Parsing JSON with Gson: $json")
        return mapOf("name" to "John", "age" to 30)
    }
}