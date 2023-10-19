package petto.para.leaguematch.presentation.fragments.argentina

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import petto.para.leaguematch.R
import petto.para.leaguematch.databinding.FragmentFirstForArgentinaBinding

class FirstForArgentinaFragment : Fragment() {
    private var _binding: FragmentFirstForArgentinaBinding? = null
    private val binding get() = _binding!!
    private var isButtonClickable = true // Добавляем флаг для проверки доступности кнопки

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstForArgentinaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvFindOut.setOnClickListener {
            if (isButtonClickable) { // Проверяем доступность кнопки
                isButtonClickable = false // Блокируем кнопку
                binding.cookie2.setImageResource(R.drawable.open_cookie)

                CoroutineScope(Dispatchers.Main).launch {
                    delay(2000)
                    findNavController().navigate(R.id.action_firstForArgentinaFragment_to_forArgentinaFragment)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
