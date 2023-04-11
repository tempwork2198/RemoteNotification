package com.example.test.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE

import android.content.SharedPreferences




class Store(context: Context) {

    var sh: SharedPreferences = context.getSharedPreferences("MySharedPref", MODE_PRIVATE)
    var myEdit: SharedPreferences.Editor = sh.edit()

    private val SPLASH_BOOL = "SPLASH_ACTIVITY"

    fun setFirstTime(isFirstTime :Boolean){
        myEdit.putBoolean(SPLASH_BOOL, isFirstTime)
    }

    fun getFirstTime() : Boolean{
        return sh.getBoolean(SPLASH_BOOL,true)
    }

}