package com.chocoding.pillguard

import android.app.Activity
import android.graphics.Bitmap
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.chocoding.pillguard.databinding.FragmentCameraBinding
import android.content.Intent

class CameraFragment : BaseFragment<FragmentCameraBinding>(FragmentCameraBinding::inflate) {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val takePictureLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val imageBitmap = result.data?.extras?.get("data") as? Bitmap
            if (imageBitmap != null) {
                sharedViewModel.setMedicinePhoto(imageBitmap)
                findNavController().navigate(R.id.action_cameraFragment_to_medicineDetailFragment)
            } else {
                // If for some reason bitmap is null, go back
                findNavController().popBackStack()
            }
        } else {
            // If user cancels or camera fails, go back to the previous screen
            findNavController().popBackStack()
        }
    }

    override fun setupView() {
        openCamera()
    }

    private fun openCamera() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            takePictureLauncher.launch(takePictureIntent)
        } catch (e: Exception) {
            // If camera cannot be opened, go back
            findNavController().popBackStack()
        }
    }
}
