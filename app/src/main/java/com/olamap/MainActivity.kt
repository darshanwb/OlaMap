package com.olamap

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.ola.mapsdk.interfaces.OlaMapCallback
import com.ola.mapsdk.model.BezierCurveOptions
import com.ola.mapsdk.model.LineType
import com.ola.mapsdk.model.OlaCircleOptions
import com.ola.mapsdk.model.OlaLatLng
import com.ola.mapsdk.model.OlaMarkerOptions
import com.ola.mapsdk.model.OlaPolygonOptions
import com.ola.mapsdk.model.OlaPolylineOptions
import com.ola.mapsdk.view.OlaMap
import com.olamap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        enableEdgeToEdge()
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        //setContentView(R.layout.activity_main)


        binding.mapView.getMap(apiKey = "",
            olaMapCallback = object : OlaMapCallback {
                override fun onMapReady(olaMap: OlaMap) {
                    // Map is ready to use
                    Log.e("onMapReady : ","onMapReady")

                    // Add a marker to the map
                    var olaPoint=OlaLatLng(23.020911, 72.556294)

                    val markerOptions1 = OlaMarkerOptions.Builder()
                        .setMarkerId("marker1")
                        .setPosition(olaPoint)
                        .setIsIconClickable(true)
                        .setIconRotation(0f)
                        .setIsAnimationEnable(true)
                        .setSnippet("Parimal Garden")
                        .setIsInfoWindowDismissOnClick(true)
                        .build()

                    var marker1 = olaMap.addMarker(markerOptions1)
                    Handler(Looper.getMainLooper()).postDelayed({
                        olaMap.moveCameraToLatLong(olaPoint,15.0,1000)
                    }, 1000)



                    // Add a polyline to the map
                    val points = arrayListOf(OlaLatLng(23.020911, 72.556294),
                        OlaLatLng(23.026648, 72.560864))

                    val polylineOptions = OlaPolylineOptions.Builder()
                        .setPolylineId("pid1")
                        .setPoints(points)
                        .build()
                    var polyline1 = olaMap.addPolyline(polylineOptions)
                    olaMap.addPolyline(polylineOptions)


                    // add Circle
                    val olaCampus = OlaLatLng(23.020911, 72.556294)
                    val circleOptions = OlaCircleOptions.Builder()
                        .setOlaLatLng(olaCampus)
                        .setRadius(100f)
                        .build()
                    circleOptions.also {
                        it.colorHexCode="#00FF00"
                        it.circleOpacity=0.3F
                    }
                    olaMap.addCircle(circleOptions)


                    // add Polygon
                    val pointsForPolyGon = arrayListOf(
                        OlaLatLng(23.036676, 72.561319),
                        OlaLatLng(23.039534, 72.563988),
                        OlaLatLng(23.035369, 72.564778),
                    )
                    val polygonOptions = OlaPolygonOptions.Builder()
                        .setPolygonId("polygon1")
                        .setColor("#FF0000")
                        .setPoints(pointsForPolyGon)
                        .build()

                    var polygon = olaMap.addPolygon(polygonOptions)
                    olaMap.addPolygon(polygonOptions)


                    // Add Bezier Curve
                    val startPoint = OlaLatLng(23.036885, 72.561059)
                    val endPoint = OlaLatLng(23.037355, 72.567242)
                    val bezierCurveOptions = BezierCurveOptions.Builder()
                        .setCurveId("bcurve1")
                        .setStartPoint(startPoint)
                        .setLineType(LineType.LINE_DOTTED)
                        .setColor("#000000")
                        .setEndPoint(endPoint)
                        .build()

                    var bezierCurve = olaMap.addBezierCurve(bezierCurveOptions)
                    olaMap.addBezierCurve(bezierCurveOptions)
                }

                override fun onMapError(error: String) {
                    Log.e("onMapError : ", error)
                    // Handle map error
                }
            }
        )

    }
}