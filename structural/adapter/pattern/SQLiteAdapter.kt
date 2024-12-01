package structural.adapter.pattern

class SQLiteAdapter(private val cursor: Cursor) : DataProvider {

    override fun fetchData(): List<DataModel> {
        val dataList = mutableListOf<DataModel>()

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(cursor.getColumnIndexOrThrow("id"))
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                dataList.add(DataModel(id, name))
            } while (cursor.moveToNext())
        }

        return dataList
    }
}
