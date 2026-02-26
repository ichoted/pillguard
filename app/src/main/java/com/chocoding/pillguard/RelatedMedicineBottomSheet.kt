package com.chocoding.pillguard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.chocoding.pillguard.databinding.BottomSheetRelatedMedicineBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class RelatedMedicineBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BottomSheetRelatedMedicineBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetRelatedMedicineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Handle close button click
        binding.btnCloseSheet.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "RelatedMedicineBottomSheet"

        fun newInstance(): RelatedMedicineBottomSheet {
            return RelatedMedicineBottomSheet()
        }
    }
}
