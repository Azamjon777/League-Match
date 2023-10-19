package petto.para.leaguematch.presentation.fragments.ecuador

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import petto.para.leaguematch.R
import petto.para.leaguematch.databinding.FragmentForEcuadorBinding

class ForEcuadorFragment : Fragment() {
    private var _binding: FragmentForEcuadorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForEcuadorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.table.setOnClickListener {
            findNavController().navigate(R.id.action_forEcuadorFragment_to_tableEcuFragment)
        }
        binding.homeImg.setOnClickListener {
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.firstFragment, true) // Очистить backstack до начального фрагмента
                .build()
            findNavController().navigate(R.id.firstFragment, null, navOptions)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


