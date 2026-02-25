package com.chocoding.pillguard

import androidx.navigation.fragment.findNavController
import com.chocoding.pillguard.databinding.FragmentRegisterBinding

class RegisterFragment : BaseFragment<FragmentRegisterBinding>(FragmentRegisterBinding::inflate) {
    override fun setupView() {
        // Prepare initial state for animation
        val viewsToAnimate = listOf(
            binding.ivLogo,
            binding.tvCreateAccount,
            binding.tvSubtitle,
            binding.tilName,
            binding.tilEmail,
            binding.tilPassword,
            binding.btnRegister,
            binding.tvLogin
        )

        viewsToAnimate.forEach { view ->
            view.alpha = 0f
            view.translationY = 50f
        }

        // Run staggered animation
        viewsToAnimate.forEachIndexed { index, view ->
            view.animate()
                .alpha(1f)
                .translationY(0f)
                .setDuration(500)
                .setStartDelay(100L * index)
                .start()
        }

        binding.btnRegister.setOnClickListener {
            // Handle registration logic
        }

        binding.tvLogin.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}
