package structural.facade.pattern.abstractions

interface ICacheManager {

    fun getFromCache(endpoint: String)

    fun saveToCache(endpoint: String, parsedData: Map<String, Any>)
}