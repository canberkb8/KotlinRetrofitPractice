package com.canberkbbc.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.canberkbbc.recyclerview.Adapters.DogListAdapter
import com.canberkbbc.recyclerview.Models.DogModel
import com.canberkbbc.recyclerview.Models.UserModel
import com.canberkbbc.recyclerview.Services.ApiClient
import com.canberkbbc.recyclerview.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val dogListAdapter = DogListAdapter()

    var mainActBinding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initDogListRecycler()
        getData()
        onDogItemClicked()

    }

    private fun initDogListRecycler() {
        mainActBinding?.mainRecycler?.apply {
            setHasFixedSize(true)
            adapter = dogListAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun getData() {
        ApiClient.getDogClient.getDogList().enqueue(object:Callback<List<DogModel>>{
            override fun onResponse(call: Call<List<DogModel>>, response: Response<List<DogModel>>) {
                if (response.isSuccessful){
                    Log.e("DogRequest","response is success")
                    Log.e("DogRequest",response.body()?.get(0).toString())
                }else{
                    Log.e("DogRequest","response is NOT success")
                }
            }
            override fun onFailure(call: Call<List<DogModel>>, t: Throwable) {
                Log.e("DogRequest","onFailure")
                Log.e("asd", call.toString())
            }
        })

        ApiClient.getUserClient.getUserList().enqueue(object:Callback<Map<String,UserModel>>{
            override fun onResponse(call: Call<Map<String,UserModel>>, response: Response<Map<String,UserModel>>) {
                if (response.isSuccessful){
                    Log.e("UserResponse","response is success")
                    Log.e("UserResponse",response.body()?.keys.toString()+"---"+response.body()?.values)

                }else{
                    Log.e("UserResponse","response is NOT success")
                }
            }
            override fun onFailure(call: Call<Map<String,UserModel>>, t: Throwable) {
                Log.e("UserRequest","onFailure")
                Log.e("asd", call.toString())

            }
        })

}
    private fun onDogItemClicked() {
        dogListAdapter.setOnItemClickListener {
            Log.i("DogItem","dog name : "+ it.name)
        }
    }
}