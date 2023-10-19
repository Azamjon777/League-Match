package petto.para.leaguematch.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

class MyViewModel : ViewModel() {
    private val viewModelScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    var koreaImageBlocked: MutableLiveData<Boolean> = MutableLiveData(false)
    var denmarkImageBlocked: MutableLiveData<Boolean> = MutableLiveData(false)
    var argentinaImageBlocked: MutableLiveData<Boolean> = MutableLiveData(false)
    var ecuadorImageBlocked: MutableLiveData<Boolean> = MutableLiveData(false)

    init {
        startPeriodicUpdate()
    }

    private fun startPeriodicUpdate() {
        viewModelScope.launch {
            while (isActive) {
                updateLiveDataValues()
                delay(TimeUnit.MINUTES.toMillis(1)) // Повторяем каждую минуту
            }
        }
    }

    private fun updateLiveDataValues() {
        val currentTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())

        koreaImageBlocked.postValue(isWithinInterval(currentTime, "00:00", "06:00"))
        denmarkImageBlocked.postValue(isWithinInterval(currentTime, "06:00", "12:00"))
        argentinaImageBlocked.postValue(isWithinInterval(currentTime, "12:00", "18:00"))
        ecuadorImageBlocked.postValue(isWithinInterval(currentTime, "18:00", "23:59"))
    }

    private fun isWithinInterval(currentTime: String, start: String, end: String): Boolean {
        return currentTime >= start && currentTime < end
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}