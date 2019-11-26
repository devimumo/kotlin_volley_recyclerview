package com.example.second_kotlin

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_launcher.*
import kotlinx.android.synthetic.main.activity_signup.*
import org.json.JSONObject
import java.util.HashMap

class Signup : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)



signUp.setOnClickListener {
    signUpss()
}


    }



    fun signUpss() {


        val progressbar: ProgressDialog = ProgressDialog(this)
        progressbar.setMessage("Loading..........")
        progressbar.setCancelable(false)
        progressbar.show()



        val firstNames = firstName.text
        val lastNames = lastName.text
        val mobile_nos = mobileNumber.text
        val emails = email.text

        val passWords = passWord.text
        val confirmPasswords = confirmPassword.text




        if (firstNames.isNotEmpty() && lastNames.isNotEmpty() && mobile_nos.isNotEmpty() && passWords.isNotEmpty()  && confirmPasswords.isNotEmpty())
        {

            if(!passWords.equals(confirmPasswords))
            {


                val queue = Volley.newRequestQueue(this)
                val url = "https://project-daudi.000webhostapp.com/android_login_register/register_kotlin.php"

                // val url = "http://192.168.43.121/recycler/check_tiko.php"


                val request=object : StringRequest(Request.Method.POST, url, Response.Listener { response ->
Log.i("bbb",response)
                    val response= JSONObject(response)
                    val res=response.getString("response")
                    if (res.equals("successful"))
                    {
                        Toast.makeText(this,"Successful registration",Toast.LENGTH_SHORT).show()
                        progressbar.dismiss()

                        val intent= Intent(this,LauncherActivity::class.java)
                        startActivity(intent)
                    }
                    else if (res.equals("!phone_number_exists"))
                    {
                        Toast.makeText(this,"wrong credentials",Toast.LENGTH_SHORT).show()
                        progressbar.dismiss()
                    }
                    else{
                        Toast.makeText(this,"registration unsuccessful",Toast.LENGTH_SHORT).show()
                        progressbar.dismiss()
                    }
                    // Your success code here
                }, Response.ErrorListener { e ->
                    // Your error code here
                }) {

                    @Throws(AuthFailureError::class)
                    override fun getParams(): Map<String, String> {
                        val params = HashMap<String, String>()



                        params.put("firstname","$firstNames");
                        params.put("lastname","$lastNames");
                        params.put("mobile_no","+254$mobile_nos");
                        params.put("email","$emails");
                        params.put("password","$passWords");


                        // return super.getParams();
                        return params
                    }

                }


                queue.add(request)
            }
            else
            {
                Toast.makeText(applicationContext,"Passwords must match",Toast.LENGTH_LONG).show()
                progressbar.dismiss()

            }



        }
        else
        {

            Toast.makeText(applicationContext,"field required",Toast.LENGTH_LONG).show()
            progressbar.dismiss()

        }
    }
}
