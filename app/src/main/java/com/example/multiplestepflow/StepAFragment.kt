package com.example.multiplestepflow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * Input: [InputA]
 * Output: [OutputA]
 */
class StepAFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_step_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.next).setOnClickListener {
            (requireActivity() as FlowNagivation).goNext()
        }
    }

    companion object {
        private const val ARG_DATA = "ARG_DATA"

        fun newInstance(inputA: InputA) =
            StepAFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_DATA, inputA)
                }
            }
    }
}