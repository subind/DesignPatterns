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

        // Example: Fetch data from SQLite
        val cursor: Cursor = fetchCursorFromDatabase() // Replace with actual DB query
        val sqliteAdapter = SQLiteAdapter(cursor)
        val dataFromDatabase = sqliteAdapter.fetchData()

        // Example: Fetch data from REST API
        val jsonObjects: List<JSONObject> = fetchJsonObjectsFromApi() // Replace with actual API call
        val restApiAdapter = RestApiAdapter(jsonObjects)
        val dataFromApi = restApiAdapter.fetchData()

        // Combine data and display it
        val combinedData = dataFromDatabase + dataFromApi
        val adapter = DataRecyclerViewAdapter(combinedData)
        recyclerView.adapter = adapter
    }

    private fun fetchCursorFromDatabase(): Cursor {
        // Mock implementation. Replace with actual SQLite database query.
        // Example schema: Table with columns "id" and "name".
        return SQLiteDatabase.openOrCreateDatabase(":memory:", null)
            .query("my_table", null, null, null, null, null, null)
    }

    private fun fetchJsonObjectsFromApi(): List<JSONObject> {
        // Mock implementation. Replace with actual REST API data fetching.
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
