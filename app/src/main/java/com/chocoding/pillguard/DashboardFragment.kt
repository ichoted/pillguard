package com.chocoding.pillguard

import androidx.lifecycle.lifecycleScope
import com.chocoding.pillguard.databinding.FragmentDashboardBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class DashboardFragment : BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {
    override fun setupView() {
        // Show medicine reminder dialog after 5 seconds delay
        lifecycleScope.launch {
            delay(5000)
            if (isAdded) {
                showMedicineReminderDialog()
            }
        }
    }

    private fun showMedicineReminderDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("แจ้งเตือนการทานยา")
            .setMessage("ถึงเวลาทานยาพาราเซตามอล (500 มก.) แล้วครับ")
            .setPositiveButton("ทานแล้ว") { dialog, _ ->
                // Handle medicine taken logic
                dialog.dismiss()
            }
            .setNegativeButton("เตือนภายหลัง") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}
