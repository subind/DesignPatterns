package structural.facade.novice

// MainActivity.kt
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
