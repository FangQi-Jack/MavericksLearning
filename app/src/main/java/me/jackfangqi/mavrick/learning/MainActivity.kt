package me.jackfangqi.mavrick.learning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.mvrx.InternalMavericksApi
import me.jackfangqi.mavrick.learning.counter.CounterActivity
import me.jackfangqi.mavrick.learning.databinding.ActivityMainBinding

@InternalMavericksApi
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.openCounter.setOnClickListener {
            CounterActivity.open(this)
        }
    }
}