package structural.adapter.novice

/**
 * Problems in the Novice Approach :-
 *
 * * Separate Adapters for Each Data Source:
 *
 * * CursorRecyclerViewAdapter and JsonRecyclerViewAdapter are implemented separately, duplicating logic for binding data to the RecyclerView.
 * Hardcoding the Data Source Switching Logic:
 *
 * * The logic to decide which adapter to use (useDatabase toggle) is hardcoded in the Activity. This makes the code inflexible and difficult to scale.
 * Low Reusability:
 *
 * * Adding a new data source (e.g., Firebase) would require creating yet another adapter and modifying the Activity.
 * Data Conversion Logic is Implicit:
 *
 * * The adapters directly handle raw data (Cursor or List<JSONObject>), instead of converting it into a common format like DataModel. This makes testing harder and reduces clarity.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Toggle between data sources
        val useDatabase = true

        if (useDatabase) {
            // Fetch data from SQLite and bind it to CursorRecyclerViewAdapter
            val cursor: Cursor = fetchCursorFromDatabase()
            val cursorAdapter = CursorRecyclerViewAdapter(cursor)
            recyclerView.adapter = cursorAdapter
        } else {
            // Fetch data from REST API and bind it to JsonRecyclerViewAdapter
            val jsonObjects: List<JSONObject> = fetchJsonObjectsFromApi()
            val jsonAdapter = JsonRecyclerViewAdapter(jsonObjects)
            recyclerView.adapter = jsonAdapter
        }
    }

    private fun fetchCursorFromDatabase(): Cursor {
        // Mock implementation. Replace with actual SQLite database query.
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
