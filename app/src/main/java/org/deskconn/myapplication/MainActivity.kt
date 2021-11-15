package org.deskconn.myapplication


import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseApp
import com.google.firebase.installations.FirebaseInstallations


class MainActivity : AppCompatActivity() {

    //lateinit var mSharedPrefs: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*pushFloatingButton.setOnClickListener{view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/

       /* FirebaseApp.initializeApp(this)

        FirebaseInstallations.getInstance().id.addOnCompleteListener {task: Task<String?> ->
            if (task.isSuccessful) {
                val token = task.result

                Log.e("token...", token!!)

                val mEditor = mSharedPrefs.edit()
                mEditor.putString("FCM_Token", token)
                mEditor.apply()
            }

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