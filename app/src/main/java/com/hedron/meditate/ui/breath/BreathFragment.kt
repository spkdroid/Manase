package com.hedron.meditate.ui.breath

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.github.ybq.android.spinkit.style.MultiplePulse
import com.github.ybq.android.spinkit.style.Pulse
import com.github.ybq.android.spinkit.style.PulseRing
import com.hedron.meditate.R
import io.github.erehmi.countdown.CountDownTask
import io.github.erehmi.countdown.CountDownTimers.OnCountDownListener
import kotlinx.android.synthetic.main.breath_fragment.*
import kotlinx.android.synthetic.main.breath_fragment.view.*
import kotlinx.android.synthetic.main.music_fragment.*
import kotlinx.android.synthetic.main.music_fragment.view.*
import java.lang.String
import java.util.function.DoublePredicate


class BreathFragment : Fragment() {

    companion object {
        fun newInstance() = BreathFragment()
    }

    private lateinit var viewModel: BreathViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v:View = inflater.inflate(R.layout.breath_fragment, container, false)
        v.breathSpinnerView.setIndeterminateDrawable(MultiplePulse())
        v.breathSpinnerView.setColor(R.color.colorAccent)

        var countDownTask:CountDownTask = CountDownTask.create()
        val targetMillis = CountDownTask.elapsedRealtime() + 1000 * 400
        var CD_INTERVAL:Long = 1000
        var flag = true

        v.breathPlayCard.setOnClickListener{
           if(v.breathSpinnerView.visibility == View.VISIBLE) {
               v.breathSpinnerView.visibility = View.INVISIBLE
               countDownTask.cancel()
               v.breathStartStopText.text = "Play"
               v.breathStatusText.text = "Breath"
           } else {
               v.breathSpinnerView.visibility = View.VISIBLE
               v.breathStartStopText.text = "Pause"
               countDownTask.until(
                   breathStatusText,
                   targetMillis,
                   CD_INTERVAL.toLong(),
                   object : OnCountDownListener {
                       override fun onTick(
                           view: View,
                           millisUntilFinished: Long
                       ) {

                           var flagCode = millisUntilFinished/CD_INTERVAL
                           var p = ""

                           if(flagCode % 7 == 0L) {
                               flag = !flag;
                           }

                           when(flagCode%7) {
                               0L -> p = ""
                               6L -> p = "."
                               5L -> p = ".."
                               4L -> p = ".."
                               3L -> p = ".."
                               2L -> p = "..."
                               1L -> p = "..."
                           }
                           if(flag) (view as TextView).text = "Inhale" + p
                           else (view as TextView).text = "Exhale" + p

                           //(view as TextView).text =
                             //  String.valueOf(millisUntilFinished / CD_INTERVAL)
                       }

                       override fun onFinish(view: View) {
                           (view as TextView).text = "DONE."
                       }
                   })


           }
        }

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BreathViewModel::class.java)
        // TODO: Use the ViewModel
    }

}