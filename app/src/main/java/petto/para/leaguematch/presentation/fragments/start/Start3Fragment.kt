package petto.para.leaguematch.presentation.fragments.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import petto.para.leaguematch.R
import petto.para.leaguematch.databinding.FragmentStart3Binding

class Start3Fragment : Fragment() {

    private lateinit var binding: FragmentStart3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStart3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.skipButton.setOnClickListener {
            findNavController().navigate(R.id.action_start3Fragment_to_firstFragment)
        }
    }
}