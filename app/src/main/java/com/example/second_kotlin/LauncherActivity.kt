package com.example.second_kotlin

import android.app.ProgressDialog
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_launcher.*
import kotlinx.android.synthetic.main.activity_volley_recycler.*
import kotlinx.android.synthetic.main.custom_layout.*
import org.json.JSONException
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.util.HashMap

class LauncherActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)



      textView2.setOnClickListener {
          val intent=Intent(this,Register::class.java)
          startActivity(intent)
      }

        textView2.setOnClickListener {
            val intent=Intent(this,Signup::class.java)
            startActivity(intent)

        }

        button.setOnClickListener {

login();

        }


    }



    fun login () {

//  progressBar.visibility(View.VISIBLE)
        val names = editText.text
        val password = editText2.text


        //checks whether user has entered details
        //if true,executes login code
        if (names.isNotEmpty() && password.isNotEmpty()) {
            val progressbar: ProgressDialog = ProgressDialog(this)
            progressbar.setMessage("Loading..........")
            progressbar.setCancelable(false)
            progressbar.show()


            val queue = Volley.newRequestQueue(this)
            val url = "https://project-daudi.000webhostapp.com/android_login_register/login_kotlin.php"

            // val url = "http://192.168.43.121/recycler/check_tiko.php"


         val request=object :StringRequest(Request.Method.POST, url, Response.Listener { response ->

             val response=JSONObject(response)
             val res=response.getString("response")
if (res.equals("successful"))
{
    Toast.makeText(this,"Successful login",Toast.LENGTH_SHORT).show()
    progressbar.dismiss()

    val intent=Intent(this,Volley_recycler::class.java)
    startActivity(intent)
}
             else if (res.equals("!phone_number"))
{
    Toast.makeText(this,"wrong credentials",Toast.LENGTH_SHORT).show()
    progressbar.dismiss()
}
             else{
    Toast.makeText(this,"wrong credentials",Toast.LENGTH_SHORT).show()
    progressbar.dismiss()
}
             // Your success code here
         }, Response.ErrorListener { e ->
             // Your error code here
             progressbar.dismiss()

         }) {

             @Throws(AuthFailureError::class)
             override fun getParams(): Map<String, String> {
                 val params = HashMap<String, String>()

                 params.put("phone_number","+254$names");
                 params.put("password","$password");


                 // return super.getParams();
                 return params
             }

         }


    queue.add(request)



}

        //called when edit text does not have content
        else
        {

            val phone_number: EditText=findViewById(R.id.editText)
            val password: EditText=findViewById(R.id.editText2)

            phone_number.setError("required")
            password.setError("required")

        }
}



}

