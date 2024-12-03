package structural.facade.pattern.abstractions

class OkHttpNetworkModule : INetworkModule {
    override fun fetchData(endpoint: String): String {
        println("Fetching data from API with OkHttp: $endpoint")
        return """{"name": "John", "age": 30}"""
    }
}