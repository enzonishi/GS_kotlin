package enzonishi.com.github

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PraiaAdapter(private val praiaList: MutableList<Praia>) : RecyclerView.Adapter<PraiaAdapter.PraiaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PraiaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_praia, parent, false)
        return PraiaViewHolder(view)
    }

    override fun onBindViewHolder(holder: PraiaViewHolder, position: Int) {
        val praia = praiaList[position]
        holder.nomePraia.text = praia.nome
        holder.btnExcluir.setOnClickListener {
            praiaList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun getItemCount(): Int {
        return praiaList.size
    }

    inner class PraiaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomePraia: TextView = itemView.findViewById(R.id.nome_praia)
        val btnExcluir: Button = itemView.findViewById(R.id.btn_excluir)
    }
}