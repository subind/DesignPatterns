package structural.facade.pattern

import structural.facade.pattern.abstractions.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkModule: INetworkModule = RetrofitNetworkModule()
        val jsonParser: IJsonParser = GsonJsonParser()
        val cacheManager = SharedPrefCacheManager()

        val dataFacade = DataFacade(networkModule, jsonParser, cacheManager)
        val data = dataFacade.fetchData("/users/123")
        println("Data: $data")
    }
}
