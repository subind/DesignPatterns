package structural.facade.novice

// NetworkModule.kt
class NetworkModule {
    fun fetchData(endpoint: String): String {
        println("Fetching data from API with Retrofit: $endpoint")
        return """{"name": "John", "age": 30}""" // Simulated JSON
    }
}
