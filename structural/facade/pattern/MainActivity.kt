package structural.facade.pattern

import structural.facade.pattern.abstractions.GsonJsonParser
import structural.facade.pattern.abstractions.IJsonParser
import structural.facade.pattern.abstractions.INetworkModule
import structural.facade.pattern.abstractions.RetrofitNetworkModule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val networkModule: INetworkModule = RetrofitNetworkModule()
        val jsonParser: IJsonParser = GsonJsonParser()
        val cacheManager = CacheManager()

        val dataFacade = DataFacade(networkModule, jsonParser, cacheManager)
        val data = dataFacade.fetchData("/users/123")
        println("Data: $data")
    }
}
