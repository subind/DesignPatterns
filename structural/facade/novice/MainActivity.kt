package structural.facade.novice

/**
 * Here the fetch data function is tightly coupled with the client(in our case MainActivity) code
 * Any changes in requirement in the fetchData() involves altering the client.
 * If the same logic is required somewhere else in the application, this code needs to be duplicated.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkModule = NetworkModule()
        val jsonParser = JsonParser()
        val cacheManager = CacheManager()

        val data = fetchData(networkModule, jsonParser, cacheManager)
        println("Data: $data")
    }

    private fun fetchData(networkModule: NetworkModule,
                          jsonParser: JsonParser,
                          cacheManager: CacheManager): Map<String, Any>? {
        val cachedData = cacheManager.getFromCache(endpoint)
        if (cachedData != null) return cachedData as Map<String, Any>

        val jsonData = networkModule.fetchData(endpoint)
        val parsedData = jsonParser.parse(jsonData)
        cacheManager.saveToCache(endpoint, parsedData)

        return parsedData
    }

}
