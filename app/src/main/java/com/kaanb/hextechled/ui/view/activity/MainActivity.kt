package com.kaanb.hextechled.ui.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import com.kaanb.hextechled.R
import com.kaanb.hextechled.data.model.LedModel
import com.kaanb.hextechled.data.network.ApiClient
import com.kaanb.hextechled.data.network.LEDApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        verilerial()

        val t = Timer()
        t.schedule(object : TimerTask() {
            override fun run() {
                verilerial()                    //Call this fuction every 15 sec.
            }
        }, 0,   15000)








    }


    @SuppressLint("UseSwitchCompatOrMaterialCode")
    fun verilerial()
    {
        var pin1 = findViewById<Switch>(R.id.pin1)
        var pin2 = findViewById<Switch>(R.id.pin2)
        var pin3 = findViewById<Switch>(R.id.pin3)
        var pin4 = findViewById<Switch>(R.id.pin4)

        var apiInterface = ApiClient.client?.create(LEDApiInterface::class.java)
        var apiCall = apiInterface?.verilerigetir()


        apiCall?.enqueue(object : Callback<LedModel>{
            override fun onFailure(call: Call<LedModel>, t: Throwable) {
                Log.e("Hata",""+ t?.printStackTrace())

            }


            override fun onResponse(call: Call<LedModel>, response: Response<LedModel>) {


                    if (response.isSuccessful) {


                        var p1String= response?.body()?.p1.toString()
                        var p2String= response?.body()?.p2.toString()
                        var p3String= response?.body()?.p3.toString()
                        var p4String= response?.body()?.p4.toString()



                        pin1.isChecked = p1String == "true"
                        pin2.isChecked = p2String == "true"
                        pin3.isChecked = p3String == "true"
                        pin4.isChecked = p4String == "true"


                    }


            }
        })




    }




}