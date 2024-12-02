package structural.facade.pattern.abstractions

interface IJsonParser {
    fun parse(json: String): Map<String, Any>
}