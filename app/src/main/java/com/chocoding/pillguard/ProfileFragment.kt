package com.chocoding.pillguard

import androidx.navigation.fragment.findNavController
import com.chocoding.pillguard.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    override fun setupView() {
        // เมื่อกดที่กล่องประวัติการรักษา
        binding.cardTreatmentHistory.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_treatmentHistoryFragment)
        }

        binding.btnEditProfile.setOnClickListener {
            // Logic สำหรับแก้ไขโปรไฟล์
        }

        binding.btnLogout.setOnClickListener {
            // ไปหน้า Login และเคลียร์ stack ของหน้าก่อนหน้าทั้งหมด
        }
        
        binding.btnChangeLanguage.setOnClickListener {
            // Logic สำหรับเปลี่ยนภาษา
        }
    }
}
