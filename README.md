# Map Features with Ola Map SDK

This README covers various map features using the Ola SDK, including markers, polylines, polygons, and gestures.

## Features

- Dynamic Map
- Markers
- Polyline
- Circle
- Polygon
- Bezier Curve
- Events and Methods
- Controls and Gestures


## XML

```
<com.ola.mapsdk.view.OlaMapView
            android:id="@+id/mapView"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

```

## 1. Dynamic Map
- Dynamic Map
```
mapView = findViewById(R.id.mapView)

mapView.getMap(apiKey = "<API KEY>",
  olaMapCallback = object : OlaMapCallback {
      override fun onMapReady(olaMap: OlaMap) {
          // Map is ready to use
      }

      override fun onMapError(error: String) {
          // Handle map error
      }
  }
)
```
![App Screenshot](https://iili.io/d6texS9.md.png)


## 2. Marker
- Add a marker to the map
```
var olaPoint=OlaLatLng(23.026861, 72.524454)

    val markerOptions1 = OlaMarkerOptions.Builder()
         .setMarkerId("marker1")
        .setPosition(olaPoint)
        .setIsIconClickable(true)
        .setIconRotation(0f)
        .setIsAnimationEnable(true)
        .setSnippet("Star Bazaar")
        .setIsInfoWindowDismissOnClick(true)
        .build()

    var marker1 = olaMap.addMarker(markerOptions1)
        Handler(Looper.getMainLooper()).postDelayed({
           olaMap.moveCameraToLatLong(olaPoint,15.0,1000)
        }, 1000)
```
![App Screenshot](https://iili.io/d6DIaUX.md.png)

## 3. Polyline
- Add a polyline to the map
```
    val points = arrayListOf(OlaLatLng(23.027439, 72.507867),
        OlaLatLng(23.038755, 72.527858))

    val polylineOptions = OlaPolylineOptions.Builder()
        .setPolylineId("pid1")
        .setPoints(points)
        .setWidth(4f)
        .setColor("#FF0000")
        .build()
    var polyline1 = olaMap.addPolyline(polylineOptions)
    olaMap.addPolyline(polylineOptions)
```
![App Screenshot](https://iili.io/d6D1kep.md.png)


## 4. Circle
- Add a Circle to the map
```
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
```
![App Screenshot](https://iili.io/d6D4fUv.md.png)


## 5. Polygon
- Add a Polygon to the map
```
    val pointsForPolyGon = arrayListOf(
                        OlaLatLng(23.036676, 72.561319),
                        OlaLatLng(23.039534, 72.563988),
                        OlaLatLng(23.035369, 72.564778),
                    )
    val polygonOptions = OlaPolygonOptions.Builder()
                        .setPolygonId("polygon1")
                        .setColor("#FF0000")
                        .setOpacity(0.4f)
                        .setPoints(pointsForPolyGon)
                        .build()

    var polygon = olaMap.addPolygon(polygonOptions)
    olaMap.addPolygon(polygonOptions)
```
![App Screenshot](https://iili.io/d6DDrrP.md.png)

## 6. Bezier Curve
- Add a Bezier Curve to the map
```
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
```
![App Screenshot](https://iili.io/d6bKzIS.md.png)

## 8. Controls and Gestures
```
val mapControlSettings = MapControlSettings.Builder()
   .setRotateGesturesEnabled(true)
   .setScrollGesturesEnabled(true)
   .setZoomGesturesEnabled(false)
   .setCompassEnabled(true)
   .setTiltGesturesEnabled(true)
   .setDoubleTapGesturesEnabled(true)
   .build()

mapView.getMap(apiKey = "<API KEY>",
olaMapCallback = object : OlaMapCallback {}, mapControlSettings)
```

