package com.chocoding.pillguard

import androidx.navigation.fragment.findNavController
import com.chocoding.pillguard.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    override fun setupView() {
        // Prepare initial state for animation
        val viewsToAnimate = listOf(
            binding.ivLogo,
            binding.tvWelcome,
            binding.tvSubtitle,
            binding.tilEmail,
            binding.tilPassword,
            binding.btnLogin,
            binding.tvSignUp
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

        // Set up click listener for navigation
        binding.btnLogin.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

        binding.tvSignUp.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }
}
