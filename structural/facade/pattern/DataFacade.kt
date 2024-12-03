package structural.facade.pattern

import structural.facade.pattern.abstractions.ICacheManager
import structural.facade.pattern.abstractions.IJsonParser
import structural.facade.pattern.abstractions.INetworkModule

/**
 * This class's function is responsible for multiple operations,
 * the client(in our case MainActivity) doesn't need to know about it's internal complexity
 * Thus extracting this to a separate class, is all that is required to make it adhere to the 'facade' pattern
 *
 * The abstraction followed here is the 'Liskov Substitution Principle' from SOLID
 * The advantage of utilising L.S.P is that, in the future if the requirement changes, where for
 * network request, instead of retrofit we are supposed to use OKHttp.
 * Then there won't be any change required to be made in this class, whereas the client(MainActivity)
 * would accept instance of OKHttpNetworkModule() instead of RetrofitNetworkModule(), without throwing any compilation error
 * since it's a INetworkModule as well.
 */
class DataFacade(
    private val networkModule: INetworkModule,
    private val jsonParser: IJsonParser,
    private val cacheManager: ICacheManager
) {
    //In-charge of fetching data from network.
    //Parsing it utilizing a parser library.
    //And then storing it into cache
    //If network is un-available, it will retrieve existing data from cache
    fun fetchData(endpoint: String): Map<String, Any>? {
        if(!MyUtils.isOnline()) {
            val cachedData = cacheManager.getFromCache(endpoint)
            if (cachedData != null) return cachedData as Map<String, Any>
        }

        val jsonData = networkModule.fetchData(endpoint)
        val parsedData = jsonParser.parse(jsonData)
        cacheManager.saveToCache(endpoint, parsedData)

        return parsedData
    }
}
