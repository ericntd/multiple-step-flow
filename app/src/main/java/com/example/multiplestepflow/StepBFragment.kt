package com.example.multiplestepflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * A simple [Fragment] subclass.
 * Use the [StepBFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StepBFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_step_b, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.next).setOnClickListener {
            (requireActivity() as FlowNagivation).goNext(OutputB(45453))
        }
    }

    companion object {
        private const val ARG = "ARG"

        fun newInstance(inputB: InputB) =
            StepBFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG, inputB)
                }
            }
    }
}