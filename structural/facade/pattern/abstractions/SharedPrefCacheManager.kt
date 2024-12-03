package structural.facade.pattern.abstractions

class SharedPrefCacheManager: ICacheManager {
    override fun getFromCache(endpoint: String) {
        println("Retrieved cache from: $endpoint")
    }

    override fun saveToCache(endpoint: String, parsedData: Map<String, Any>) {
        println("Saved to cache: $endpoint, & $parsedData")
    }
}