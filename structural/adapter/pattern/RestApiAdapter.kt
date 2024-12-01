package structural.adapter.pattern

class RestApiAdapter(private val jsonObjects: List<JSONObject>) : DataProvider {

    override fun fetchData(): List<DataModel> {
        return jsonObjects.map { jsonObject ->
            DataModel(
                id = jsonObject.getString("id"),
                name = jsonObject.getString("name")
            )
        }
    }
}
