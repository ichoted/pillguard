package com.chocoding.pillguard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chocoding.pillguard.databinding.FragmentTreatmentHistoryBinding
import com.chocoding.pillguard.databinding.ItemTreatmentHistoryBinding

class TreatmentHistoryFragment : BaseFragment<FragmentTreatmentHistoryBinding>(FragmentTreatmentHistoryBinding::inflate) {

    override fun setupView() {
        val historyList = listOf(
            TreatmentItem("15 ต.ค. 2024", "รพ. จุฬาลงกรณ์", "ไข้หวัดใหญ่", "ยาพาราเซตามอล, ยาแก้ไอ"),
            TreatmentItem("2 ก.ย. 2024", "รพ. รามาธิบดี", "ปวดศีรษะเรื้อรัง", "ยาแก้ปวดไมเกรน"),
            TreatmentItem("10 ส.ค. 2024", "รพ. ศิริราช", "ตรวจสุขภาพประจำปี", "วิตามินบำรุง")
        )

        binding.rvTreatmentHistory.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTreatmentHistory.adapter = TreatmentAdapter(historyList)
    }

    data class TreatmentItem(val date: String, val hospital: String, val disease: String, val medicines: String)

    inner class TreatmentAdapter(private val items: List<TreatmentItem>) :
        RecyclerView.Adapter<TreatmentAdapter.ViewHolder>() {

        inner class ViewHolder(val itemBinding: ItemTreatmentHistoryBinding) :
            RecyclerView.ViewHolder(itemBinding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemTreatmentHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]
            with(holder.itemBinding) {
                tvDate.text = item.date
                tvHospital.text = item.hospital
                tvDisease.text = "โรค: ${item.disease}"
                tvMedicines.text = "ยาที่ได้รับ: ${item.medicines}"
            }
        }

        override fun getItemCount() = items.size
    }
}
