package com.chocoding.pillguard

import android.app.TimePickerDialog
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.chocoding.pillguard.databinding.DialogAddAlarmBinding
import com.chocoding.pillguard.databinding.FragmentAlarmBinding
import java.util.Calendar

class AlarmFragment : BaseFragment<FragmentAlarmBinding>(FragmentAlarmBinding::inflate) {

    private lateinit var alarmAdapter: AlarmAdapter

    override fun setupView() {
        setupRecyclerView()

        binding.fabAddAlarm.setOnClickListener {
            showAddAlarmDialog()
        }
    }

    private fun setupRecyclerView() {
        alarmAdapter = AlarmAdapter(getDummyAlarms()) // Replace with real data later
        binding.rvAlarms.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = alarmAdapter
        }
    }

    private fun showAddAlarmDialog() {
        val dialogBinding = DialogAddAlarmBinding.inflate(LayoutInflater.from(requireContext()))
        val dialog = AlertDialog.Builder(requireContext())
            .setView(dialogBinding.root)
            .create()

        var selectedHour = -1
        var selectedMinute = -1

        dialogBinding.tvSelectTime.setOnClickListener {
            val calendar = Calendar.getInstance()
            val timePickerDialog = TimePickerDialog(
                requireContext(),
                { _, hourOfDay, minute ->
                    selectedHour = hourOfDay
                    selectedMinute = minute
                    dialogBinding.tvSelectTime.text = String.format("เวลาที่เลือก: %02d:%02d น.", hourOfDay, minute)
                },
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
            )
            timePickerDialog.show()
        }

        dialogBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialogBinding.btnSave.setOnClickListener {
            val medicineName = dialogBinding.etMedicineName.text.toString()
            if (medicineName.isEmpty()) {
                Toast.makeText(requireContext(), "กรุณาใส่ชื่อยา", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (selectedHour == -1) {
                Toast.makeText(requireContext(), "กรุณาเลือกเวลา", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // รับค่าจาก CheckBox วันต่างๆ
            val days = mutableListOf<String>()
            if (dialogBinding.cbMon.isChecked) days.add("จ.")
            if (dialogBinding.cbTue.isChecked) days.add("อ.")
            if (dialogBinding.cbWed.isChecked) days.add("พ.")
            if (dialogBinding.cbThu.isChecked) days.add("พฤ.")
            if (dialogBinding.cbFri.isChecked) days.add("ศ.")
            if (dialogBinding.cbSat.isChecked) days.add("ส.")
            if (dialogBinding.cbSun.isChecked) days.add("อา.")

            val timeStr = String.format("%02d:%02d", selectedHour, selectedMinute)
            val newAlarm = Alarm(medicineName, timeStr, true)
            
            alarmAdapter.addAlarm(newAlarm)
            dialog.dismiss()
            Toast.makeText(requireContext(), "บันทึกการแจ้งเตือนเรียบร้อย", Toast.LENGTH_SHORT).show()
        }

        dialog.show()
    }

    // Dummy data for demonstration
    private fun getDummyAlarms(): MutableList<Alarm> {
        return mutableListOf(
            Alarm("ยาพาราเซตามอล", "08:00", true),
            Alarm("ยาแก้แพ้", "21:30", true)
        )
    }
}

// Data class for the alarm item
data class Alarm(val medicineName: String, val time: String, var isEnabled: Boolean)
