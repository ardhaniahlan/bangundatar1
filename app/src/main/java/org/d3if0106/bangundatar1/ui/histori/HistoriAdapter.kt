package org.d3if0106.bangundatar1.ui.histori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if0106.bangundatar1.databinding.ItemHistoriBinding
import org.d3if0106.bangundatar1.db.KelingEntity
import org.d3if0106.bangundatar1.model.hitungKeling
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter : ListAdapter<KelingEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<KelingEntity>() {
                override fun areItemsTheSame(
                    oldData: KelingEntity, newData: KelingEntity
                ): Boolean {
                    return oldData.id == newData.id
                }
                override fun areContentsTheSame(
                    oldData: KelingEntity, newData: KelingEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val dateFormatter = SimpleDateFormat("dd MMMM yyyy",
            Locale("id", "ID"))

        fun bind(item: KelingEntity) = with(binding) {
            val hasilKeling = item.hitungKeling()
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            bmiTextView.text = hasilKeling.jari.toString()
        }

    }
}