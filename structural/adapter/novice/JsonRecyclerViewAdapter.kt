package structural.adapter.novice

class JsonRecyclerViewAdapter(private val jsonObjects: List<JSONObject>) : RecyclerView.Adapter<JsonRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val jsonObject = jsonObjects[position]
        val name = jsonObject.getString("name")
        holder.nameTextView.text = name
    }

    override fun getItemCount(): Int {
        return jsonObjects.size
    }
}
