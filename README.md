# Ola Map

Basic functionality of ola map.

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
