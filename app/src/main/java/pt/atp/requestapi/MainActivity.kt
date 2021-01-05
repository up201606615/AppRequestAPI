package pt.atp.requestapi

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import pt.atp.requestapi.data.Request

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val urlStart = "http://e242e151aaf2.ngrok.io"
        var message: String?

        val checkSlots = findViewById<Button>(R.id.checkSlots)
        checkSlots.setOnClickListener {
            doAsync {
                message = Request("$urlStart/checkslots/").run()
                uiThread {
                    Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
                }
            }
        }

        val getPrices = findViewById<Button>(R.id.getPrices)
        getPrices.setOnClickListener {
            doAsync {
                message = Request("$urlStart/pricesAPP/202001").run()
                uiThread {
                    Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
                }
            }
        }

        val fastAvailable = findViewById<Button>(R.id.fastAvailable)
        fastAvailable.setOnClickListener {
            doAsync {
                message = Request("$urlStart/premiumavailable/202001").run()
                uiThread {
                    Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
                }
            }
        }

        val greenAvailable = findViewById<Button>(R.id.greenAvailable)
        greenAvailable.setOnClickListener {
            doAsync {
                message = Request("$urlStart/greenavailable/202001").run()
                uiThread {
                    Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
                }
            }
        }

        val checkConnection = findViewById<Button>(R.id.checkConnection)
        checkConnection.setOnClickListener {
            doAsync {
                message = Request("$urlStart/connection/202001").run()
                uiThread {
                    Toast.makeText(applicationContext,message,Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}