package com.example.second_kotlin

import android.app.ProgressDialog
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_volley_recycler.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.nfc.Tag
import android.util.Log
import android.view.textclassifier.TextSelection
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.ItemTouchHelper
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.video_row.*
import org.json.JSONException
import org.json.JSONObject
import java.text.FieldPosition



class Volley_recycler : AppCompatActivity() {

    val users_list=ArrayList<User>()
    val adap=Volley_Adapter(users_list)

    private var swipeBackground: ColorDrawable=ColorDrawable(Color.parseColor("#ffffff"))
private  lateinit  var delete:Drawable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volley_recycler)




recycler_view.layoutManager=LinearLayoutManager(parent)

delete=ContextCompat.getDrawable(this,R.drawable.ic_delete_black_24dp)!!



loaddata(users_list);

recycler_view.setOnClickListener {

    Toast.makeText(this,"no data received"+it,Toast.LENGTH_LONG).show()
}

        val itemTouchHelperCallback: ItemTouchHelper.SimpleCallback=object :ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
        {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, position: Int) {

                val pos: Int=viewHolder.adapterPosition
                (adap as Volley_Adapter ).removeItem(viewHolder)

            }

            override fun onChildDraw(
                c: Canvas,
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                dX: Float,
                dY: Float,
                actionState: Int,
                isCurrentlyActive: Boolean
            ) {

                val itemview=viewHolder.itemView

                val delete_icon_margin=(itemview.height-delete.intrinsicHeight)/2
                if (dX>0)
                {


                    swipeBackground.setBounds(itemview.left,itemview.top,dX.toInt(),itemview.bottom)
               delete.setBounds(itemview.left+delete_icon_margin,itemview.top,itemview.left+delete_icon_margin+delete.intrinsicWidth,itemview.bottom-delete_icon_margin)

                }
                 else
                {
                    swipeBackground.setBounds(itemview.right+dX.toInt(),itemview.top,itemview.right,itemview.bottom)
                }
c.save()
                swipeBackground.draw(c)
                if (dX>0)
                {c.clipRect(itemview.left,itemview.top,dX.toInt(),itemview.bottom)}
                else
                {c.clipRect(itemview.right+dX.toInt(),itemview.top,itemview.right,itemview.bottom)}
                delete.draw(c)
                c.restore()
                super.onChildDraw(
                    c,
                    recyclerView,
                    viewHolder,
                    dX,
                    dY,
                    actionState,
                    isCurrentlyActive
                )
            }
        }


        val itemTouchHelper=ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(recycler_view)

    }

    private fun loaddata(users_list: ArrayList<User>)
    {
        val progressbar: ProgressDialog=ProgressDialog(this)
        progressbar.setMessage("Loading..........")
        progressbar.setCancelable(false)
        progressbar.show()

// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "http://project-daudi.000webhostapp.com/recycler/check_tiko.php"

        // val url = "http://192.168.43.121/recycler/check_tiko.php"

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

                    progressbar.dismiss()

                    recycler_view.adapter=adap



                }
                catch (e: JSONException)
                {

                    progressbar.dismiss()

                    Toast.makeText(this,"no data received"+e,Toast.LENGTH_LONG).show()
                    Log.i("catch_e",e.toString())


                }

            },Response.ErrorListener
            {


                progressbar.dismiss()

                Toast.makeText(this,"eeror"+it,Toast.LENGTH_LONG).show()
                Log.d("hhht",it.toString())

            })




        //psendind params with volley request
// Add the request to the RequestQueue.
        queue.add(stringRequest)



    }









}
