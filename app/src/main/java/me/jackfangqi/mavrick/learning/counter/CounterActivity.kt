package me.jackfangqi.mavrick.learning.counter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.mvrx.*
import me.jackfangqi.mavrick.learning.databinding.ActivityCounterBinding
import timber.log.Timber

/**
 * create by FangQi on 15:41, 周四, 2022/1/6
 * fangqi.jack@bytedance.com
 *
 * 描述：--
 **/
private const val TAG = "Mavericks.Counter"

@InternalMavericksApi
class CounterActivity : AppCompatActivity(), MavericksView {
    companion object {
        fun open(context: Context) = context.startActivity(
            Intent(context, CounterActivity::class.java)
        )
    }

    private val mViewModel: CounterViewModel by viewModel()

    private lateinit var mBinding: ActivityCounterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityCounterBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.counterText.setOnClickListener {
            Timber.tag(TAG).d("click to increment counter")
            mViewModel.incrementCount()
        }

        mViewModel.onEach(CounterState::count) { count ->
            Timber.tag(TAG).d("counter view model onEach count %s", count)
            mBinding.counterText.text = "$count"
        }
    }

    override fun invalidate() {
        // it is not called in activity
    }
}

class CounterViewModel(
    initialState: CounterState
) : MavericksViewModel<CounterState>(initialState) {
    fun incrementCount() {
        Timber.tag(TAG).d("increment counter")
        setState { copy(count = count + 1) }
    }
}

data class CounterState(@PersistState val count: Int = 0) : MavericksState