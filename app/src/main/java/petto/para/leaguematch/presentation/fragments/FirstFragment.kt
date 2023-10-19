package petto.para.leaguematch.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import petto.para.leaguematch.R
import petto.para.leaguematch.databinding.FragmentFirstBinding
import petto.para.leaguematch.viewmodel.MyViewModel

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
        observeLockStatus()
    }

    private fun setupClickListeners() {
        binding.llKorea.setOnClickListener {
            if (viewModel.koreaImageBlocked.value == true) {
                findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            } else {
                Toast.makeText(
                    requireActivity(),
                    "Вы можете открыть Корею с 00:00 до 06:00!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.llDenmark.setOnClickListener {
            if (viewModel.denmarkImageBlocked.value == true) {
                findNavController().navigate(R.id.action_firstFragment_to_firstForDenmarkFragment2)
            } else {
                Toast.makeText(
                    requireActivity(),
                    "Вы можете открыть Данию с 06:00 до 12:00!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.llArgentina.setOnClickListener {
            if (viewModel.argentinaImageBlocked.value == true) {
                findNavController().navigate(R.id.action_firstFragment_to_firstForArgentinaFragment)
            } else {
                Toast.makeText(
                    requireActivity(),
                    "Вы можете открыть Аргентину с 12:00 до 18:00!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.llEcuador.setOnClickListener {
            if (viewModel.ecuadorImageBlocked.value == true) {
                findNavController().navigate(R.id.action_firstFragment_to_firstEcuadorFragment)
            } else {
                Toast.makeText(
                    requireActivity(),
                    "Вы можете открыть Эквадор с 18:00 до 00:00!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun observeLockStatus() {
        viewModel.koreaImageBlocked.observe(viewLifecycleOwner) { blocked ->
            binding.lockImgKorea.visibility = if (!blocked) View.VISIBLE else View.GONE
        }

        viewModel.denmarkImageBlocked.observe(viewLifecycleOwner) { blocked ->
            binding.lockImgDenmark.visibility = if (!blocked) View.VISIBLE else View.GONE
        }

        viewModel.argentinaImageBlocked.observe(viewLifecycleOwner) { blocked ->
            binding.lockImgArgentina.visibility = if (!blocked) View.VISIBLE else View.GONE
        }

        viewModel.ecuadorImageBlocked.observe(viewLifecycleOwner) { blocked ->
            binding.lockImgEcuador.visibility = if (!blocked) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}