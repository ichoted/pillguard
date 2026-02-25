package com.chocoding.pillguard

import androidx.fragment.app.activityViewModels
import com.chocoding.pillguard.databinding.FragmentMedicineDetailBinding

class MedicineDetailFragment : BaseFragment<FragmentMedicineDetailBinding>(FragmentMedicineDetailBinding::inflate) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun setupView() {
        // Observe and display the photo from SharedViewModel
        sharedViewModel.medicinePhoto.observe(viewLifecycleOwner) { photo ->
            photo?.let {
                binding.ivMedicinePhoto.setImageBitmap(it)
            }
        }
    }
}
