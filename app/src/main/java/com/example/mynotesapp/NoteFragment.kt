package com.example.mynotesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class NoteFragment : Fragment() {

    private lateinit var tvFragmentNote: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_note, container, false)

        tvFragmentNote = view.findViewById(R.id.tvFragmentNote)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val note = arguments?.getString("note") ?: "No Note"
        tvFragmentNote.text = note
    }

    companion object {
        fun newInstance(note: String): NoteFragment {
            val fragment = NoteFragment()
            val args = Bundle()
            args.putString("note", note)
            fragment.arguments = args
            return fragment
        }
    }
}