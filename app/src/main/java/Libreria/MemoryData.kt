package Libreria

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import java.nio.channels.spi.AbstractSelectionKey

class MemoryData(context: Context):AppCompatActivity() {
    //private var memoryData: MemoryData? = null
    private var sharedPreferences: SharedPreferences? = null

    init {
        sharedPreferences = context.getSharedPreferences("adoptme", Context.MODE_PRIVATE)
    }

    companion object{
        private var memoryData: MemoryData? = null
        @JvmStatic
        fun getInstance(context: Context):MemoryData{
            if(memoryData == null){
                memoryData = MemoryData(context)
            }
            return memoryData as MemoryData
        }
    }

    fun saveData(key: String, value: String){
        val prefesEditor = sharedPreferences!!.edit()
        prefesEditor.putString(key, value)
        prefesEditor.commit()
    }
    fun getData(key: String): String?{
        return if (sharedPreferences != null){
            sharedPreferences!!.getString(key, "")
        }else ""
    }
}