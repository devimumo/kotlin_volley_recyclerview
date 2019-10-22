package com.example.second_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_volley_recycler.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.textclassifier.TextSelection
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.video_row.*
import org.json.JSONException
import org.json.JSONObject


class Volley_recycler : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley_recycler)


recycler_view.layoutManager=LinearLayoutManager(this)



        val users_list=ArrayList<User>()


loaddata(users_list);



    }



    private fun loaddata(users_list: ArrayList<User>)
    {


// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "http://project-daudi.000webhostapp.com/recycler/check_tiko.php"

// Request a string response from the provided URL.
       val stringRequest= StringRequest(Request.Method.POST,url,
           Response.Listener<String>
           { tickets_data ->

             try {

                 val json_object=JSONObject(tickets_data)
                 val data_array=json_object.getJSONArray("tickets")

                 for (i in 0..data_array.length()-1)
                 {

                     val tickets_object=data_array.getJSONObject(i)
                     val tickets_dataaa=User(
                         tickets_object.getString("passenger_name"),
                         tickets_object.getString("phone_number"),
                         tickets_object.getString("tarehe"),
                         tickets_object.getString("amount")
                       )

         users_list.add(tickets_dataaa)
                 }


                 val adap=Volley_Adapter(users_list)
                 recycler_view.adapter=adap

             }
             catch (e: JSONException)
             {
                 Toast.makeText(this,"no data received"+e,Toast.LENGTH_LONG).show()


             }

           },Response.ErrorListener
           {

           })
// Add the request to the RequestQueue.
        queue.add(stringRequest)



    }
}
