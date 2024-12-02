package structural.facade.pattern

import structural.facade.pattern.abstractions.IJsonParser
import structural.facade.pattern.abstractions.INetworkModule

class DataFacade(
    private val networkModule: INetworkModule,
    private val jsonParser: IJsonParser,
    private val cacheManager: CacheManager
) {
    fun fetchData(endpoint: String): Map<String, Any>? {
        val cachedData = cacheManager.getFromCache(endpoint)
        if (cachedData != null) return cachedData as Map<String, Any>

        val jsonData = networkModule.fetchData(endpoint)
        val parsedData = jsonParser.parse(jsonData)
        cacheManager.saveToCache(endpoint, parsedData)

        return parsedData
    }
}
