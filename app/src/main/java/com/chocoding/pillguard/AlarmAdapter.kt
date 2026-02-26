package com.chocoding.pillguard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chocoding.pillguard.databinding.ItemAlarmBinding

class AlarmAdapter(private val alarms: MutableList<Alarm>) : RecyclerView.Adapter<AlarmAdapter.AlarmViewHolder>() {

    inner class AlarmViewHolder(private val binding: ItemAlarmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(alarm: Alarm) {
            binding.tvMedicineName.text = "ชื่อยา: ${alarm.medicineName}"
            binding.tvAlarmTime.text = "เวลา: ${alarm.time}"
            binding.switchAlarm.isChecked = alarm.isEnabled

            binding.switchAlarm.setOnCheckedChangeListener { _, isChecked ->
                alarm.isEnabled = isChecked
                // You might want to save the state here
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val binding = ItemAlarmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AlarmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.bind(alarms[position])
    }

    override fun getItemCount(): Int = alarms.size

    fun addAlarm(alarm: Alarm) {
        alarms.add(alarm)
        notifyItemInserted(alarms.size - 1)
    }
}
