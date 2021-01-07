package com.paigesoftware.androidfragmentfundamental

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

//Fragment doesn't have `stack`
class FirstFragment : Fragment(R.layout.fragment_first) {

    //You can replace this code below with `Constructor Argument`, `Fragment(R.layout.fragment_first)`
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_first, container, false)
//    }

    //You can't access to views with `onCreate()` in fragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    //You can access view from here
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}

