package structural.adapter.pattern

/**
 * Key Points :-
 * * Adapters (SQLiteAdapter and RestApiAdapter) convert data from their respective sources (Cursor and List<JSONObject>) into a unified format (List<DataModel>).
 * * The RecyclerView adapter (DataRecyclerViewAdapter) only handles List<DataModel>, making it reusable for any data source.
 * * Adding a new data source in the future (e.g., Firebase) would simply involve creating a new adapter that implements DataProvider.
 */

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val cursor: Cursor = fetchCursorFromDatabase()
        /** Adapter pattern: Provides data in a desired format */
        val sqliteAdapter = SQLiteAdapter(cursor)
        val dataFromDatabase = sqliteAdapter.fetchData()

        val jsonObjects: List<JSONObject> = fetchJsonObjectsFromApi()
        /** Adapter pattern: Provides data in a desired format */
        val restApiAdapter = RestApiAdapter(jsonObjects)
        val dataFromApi = restApiAdapter.fetchData()

        val combinedData = dataFromDatabase + dataFromApi

        /** The usual recycler-view adapter */
        val commonAdapter = CommonRecyclerViewAdapter(combinedData)
        recyclerView.adapter = commonAdapter
    }

    private fun fetchCursorFromDatabase(): Cursor {
        return SQLiteDatabase.openOrCreateDatabase(":memory:", null)
            .query("my_table", null, null, null, null, null, null)
    }

    private fun fetchJsonObjectsFromApi(): List<JSONObject> {
        return listOf(
            JSONObject().apply { put("id", "1"); put("name", "Item 1 from API") },
            JSONObject().apply { put("id", "2"); put("name", "Item 2 from API") }
        )
    }
}

data class DataModel(
    val id: String,
    val name: String
)
