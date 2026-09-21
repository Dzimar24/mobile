package com.example.mobile15

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MahasiswaAdapter(private val datalist: ArrayList<Mahasiswa>) :
    RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder>() {

    class MahasiswaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNama: TextView = itemView.findViewById(R.id.txt_nama_mahasiswa)
        val txtNpm: TextView = itemView.findViewById(R.id.txt_npm_mahasiswa)
        val txtNoHp: TextView = itemView.findViewById(R.id.txt_nohp_mahasiswa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MahasiswaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_mahasiswa, parent, false)
        return MahasiswaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MahasiswaViewHolder, position: Int) {
        val mahasiswa = datalist[position]
        holder.txtNama.text = mahasiswa.nama
        holder.txtNpm.text = mahasiswa.npm
        holder.txtNoHp.text = mahasiswa.nohp
    }

    override fun getItemCount(): Int {
        return datalist.size
    }
}