package structural.facade.pattern.abstractions

class RetrofitNetworkModule : INetworkModule {
    override fun fetchData(endpoint: String): String {
        println("Fetching data from API with Retrofit: $endpoint")
        return """{"name": "John", "age": 30}"""
    }
}