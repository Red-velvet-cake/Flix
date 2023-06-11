package com.red_velvet.flix.ui.login

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.red_velvet.flix.R
import com.red_velvet.flix.databinding.FragmentLoginBinding
import com.red_velvet.flix.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override val layoutIdFragment: Int = R.layout.fragment_login
    override val viewModel: LoginViewModel by viewModels()

    override fun onStart() {
        super.onStart()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loginEvent.collect { event ->
                when (event) {
                    LoginUIEvent.LoginEvent -> {
                        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
                    }

                    LoginUIEvent.GuestEvent -> {
                        findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
                    }
                }
            }
        }
    }
}