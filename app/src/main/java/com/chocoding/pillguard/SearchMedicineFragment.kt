package com.chocoding.pillguard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chocoding.pillguard.databinding.FragmentSearchMedicineBinding
import com.chocoding.pillguard.databinding.ItemMedicineSearchBinding

class SearchMedicineFragment : BaseFragment<FragmentSearchMedicineBinding>(FragmentSearchMedicineBinding::inflate) {

    override fun setupView() {
        // ข้อมูลตัวอย่าง 2 รายการ
        val medicineList = listOf(
            MedicineSearchItem(
                "พาราเซตามอล (Paracetamol)",
                "ฟรี",
                "สรรพคุณ: บรรเทาอาการปวด ลดไข้",
                "ที่มา: รพ.รัฐบาลโครงการ 30 บาท"
            ),
            MedicineSearchItem(
                "วิตามินบำรุงร่างกาย (Premium)",
                "พรีเมียม",
                "สรรพคุณ: เสริมสร้างภูมิคุ้มกันและบำรุงประสาท",
                "ที่มา: นำเข้าจากโรงพยาบาลเอกชนชั้นนำ"
            )
        )

        // ตั้งค่า RecyclerView
        binding.rvMedicineList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMedicineList.adapter = MedicineAdapter(medicineList)
    }

    // Data class สำหรับข้อมูลยา
    data class MedicineSearchItem(
        val name: String,
        val priceType: String,
        val properties: String,
        val origin: String
    )

    // Adapter แบบง่ายสำหรับแสดงผลรายการยา
    inner class MedicineAdapter(private val items: List<MedicineSearchItem>) :
        RecyclerView.Adapter<MedicineAdapter.ViewHolder>() {

        inner class ViewHolder(val itemBinding: ItemMedicineSearchBinding) :
            RecyclerView.ViewHolder(itemBinding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemMedicineSearchBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = items[position]
            with(holder.itemBinding) {
                tvMedicineName.text = item.name
                tvPriceType.text = item.priceType
                tvProperties.text = item.properties
                tvOrigin.text = item.origin

                // ปรับสีตามประเภทราคา
                if (item.priceType == "ฟรี") {
                    tvPriceType.setBackgroundColor(android.graphics.Color.parseColor("#E8F5E9"))
                    tvPriceType.setTextColor(android.graphics.Color.parseColor("#2E7D32"))
                } else {
                    tvPriceType.setBackgroundColor(android.graphics.Color.parseColor("#FFF3E0"))
                    tvPriceType.setTextColor(android.graphics.Color.parseColor("#E65100"))
                }
            }
        }

        override fun getItemCount() = items.size
    }
}
