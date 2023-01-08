package com.example.androidactivity

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.androidactivity.viewmodel.SharedViewModel

class SecondFragment : Fragment(), View.OnClickListener {
    private var sharedViewModelInstance: SharedViewModel? = null
    private var edt_data_send: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val btnSend: Button = view.findViewById(R.id.btn_send_fr_02)
        btnSend.setOnClickListener (this)
        edt_data_send = view.findViewById(R.id.edt_data_send)

        // as soon as the button is clicked
        // send the data to ViewModel
        // and the Live data will take care of
        // updating the data inside another Fragment
        btnSend.setOnClickListener {
            sharedViewModelInstance?.setData(edt_data_send!!.text)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // create instances of the shared view model
        // when the activity is created
        sharedViewModelInstance = ViewModelProviders.of(requireActivity()).get(SharedViewModel::class.java)

        // observe the data inside the view model that is mutable
        // live of type CharSequence and set the data for edit text
        sharedViewModelInstance!!.getData().observe(viewLifecycleOwner, Observer {
            edt_data_send!!.text = it as Editable?
        })
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btn_send_fr_02 -> {
                    Toast.makeText(activity, "Send button 2", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}