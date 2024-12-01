package structural.adapter.novice

class CursorRecyclerViewAdapter(private val cursor: Cursor) : RecyclerView.Adapter<CursorRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (cursor.moveToPosition(position)) {
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            holder.nameTextView.text = name
        }
    }

    override fun getItemCount(): Int {
        return cursor.count
    }
}
