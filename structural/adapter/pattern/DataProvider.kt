package structural.adapter.pattern

/**
 * The file is the core for achieving adapter pattern in our example.
 *
 * Since any file that inherits it, is forced to adhere to the contract.
 *
 * The contract in this case is returning data as a List<DataModel>
 */
interface DataProvider {
    fun fetchData(): List<DataModel>
}
