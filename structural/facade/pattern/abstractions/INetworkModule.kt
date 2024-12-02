package structural.facade.pattern.abstractions

interface INetworkModule {
    fun fetchData(endpoint: String): String
}


