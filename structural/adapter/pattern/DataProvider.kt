package structural.adapter.pattern

interface DataProvider {
    fun fetchData(): List<DataModel>
}
