package com.main.exercise_sharedpref.screens

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.main.exercise_sharedpref.R
import kotlinx.android.synthetic.main.fragment_login.*


class LoginFragment : Fragment(), View.OnClickListener {

//    lateinit var navController: NavController
    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = activity?.getSharedPreferences(getString(R.string.share_preference_name),Context.MODE_PRIVATE)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        navController= Navigation.findNavController(view)
        loginButton.setOnClickListener(this)
        if (sharedPreferences?.contains(getString(R.string.username_key))!!){
            view?.findNavController()?.navigate(R.id.action_loginFragment_to_homeFragment)
        }
    }

    override fun onClick(v: View?) {
        when(v){
            loginButton -> {
                with(sharedPreferences?.edit()){
                    this?.putString(getString(R.string.username_key),usernameText.text.toString())
                    this?.commit()
                }
                v?.findNavController()?.navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
    }


}