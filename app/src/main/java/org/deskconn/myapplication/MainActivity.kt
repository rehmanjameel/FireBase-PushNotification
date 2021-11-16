package org.deskconn.myapplication


import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mSharedPrefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mSharedPrefs = Editor
        /*pushFloatingButton.setOnClickListener{view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/

        //Initializing the sharedPreferences//
        mSharedPrefs = getSharedPreferences("My App", Context.MODE_PRIVATE)
        FirebaseApp.initializeApp(this)

        //Getting token from Firebase FCM
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task: Task<String?> ->
            if (task.isSuccessful) {
                val token = task.result

                Log.e("token...", token!!)

                val mEditor = mSharedPrefs.edit()
                mEditor.putString("FCM_Token", token)
                mEditor.apply()

                /*val retrieve = mSharedPrefs.getString("Token", token)
                Log.d("Get Token", retrieve.toString())
                println("text $retrieve")*/
                Toast.makeText(baseContext, token, Toast.LENGTH_LONG).show()

                textViewId.text = "Token= $token"

            }

        }

        /*FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                return
            }

            // Get new FCM registration token
            val token = task.result

            // Log and toast
            val msg = getString(R.string.msg_token_fmt, token)
            Log.d(TAG, msg)
            Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()
        }*/
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_Settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}