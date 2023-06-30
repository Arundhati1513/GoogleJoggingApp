package com.example.GoogleJoggingApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.hw08.R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.widget.AutocompleteSupportFragment;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.gson.Gson;
import com.google.maps.android.PolyUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/*
        #.HW08
        MainActivity.java
        Sachin Kumar and Arundhati Mishra
*/


public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    private static final String TAG = MainActivity.class.getSimpleName();
    static Place startPlace;
    static Place destinationPlace;
    OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();
    GoogleMap googleMap;
    private boolean isMapLoaded= false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String apiKey = getString(R.string.api_key);

        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), apiKey);
        }
        PlacesClient placesClient = Places.createClient(this);


        setStartLocation(R.id.start_fragment,"Enter Origin");
        setStartLocation(R.id.destinationFragment,"Enter Destination");

        findViewById(R.id.findDirectionsButton).setOnClickListener(view -> {
            getDirections();
        });

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        mapFragment.getMapAsync(this);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.map_fragment, mapFragment)
                .commit();
    }

    public void getNearByPlaces(double latitude, double longitude, String placeType){
        String url = getUrl(latitude, longitude, placeType);
        Object[] DataTransfer = new Object[2];
        DataTransfer[0] = googleMap;
        DataTransfer[1] = url;
        Log.d("onClick", url);
        GetNearbyPlacesData getNearbyPlacesData = new GetNearbyPlacesData();
        getNearbyPlacesData.execute(DataTransfer);
    }
    private String getUrl(double latitude, double longitude, String nearbyPlace) {

        StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + 20000);
        googlePlacesUrl.append("&type=" + nearbyPlace);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + getString(R.string.api_key));
        Log.d("getUrl", googlePlacesUrl.toString());
        return (googlePlacesUrl.toString());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap =googleMap;
        Log.d(TAG,"onMapReady(): latLngs.size");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        Log.d(TAG, "onCreateOptionsMenu");
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu (Menu menu) {
        if (!isMapLoaded) {
            menu.getItem(0).setEnabled(false);
            menu.getItem(1).setEnabled(false);
        }
        Log.d(TAG, "onPrepareOptionsMenu");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.gas_station:
                Log.d(TAG, "search gas_station clicked");
                getPlaceDetails(startPlace, "gas");
                getPlaceDetails(destinationPlace, "gas");
                return (true);
            case R.id.search_restaurant:
                Log.d(TAG, "search search_restaurant clicked");
                getPlaceDetails(startPlace, "restaurant");
                getPlaceDetails(destinationPlace, "restaurant");
                return (true);
        }
        return(super.onOptionsItemSelected(item));
    }

    private void getPlaceDetails(Place place, String placeType) {
        String url ="https://maps.googleapis.com/maps/api/place/details/json?place_id=" +
                place.getId() +
                "&key=" +
                getString(R.string.api_key);
        Log.d("MainActivityMap", "URL: " + url);
        Request request =  new Request.Builder()
                .url(url )
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful())
                        throw new IOException("Unexpected code " + response);
                    PlaceDetails placeDetails= gson.fromJson(responseBody.charStream(), PlaceDetails.class);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d(TAG, "URL: " + placeDetails.getResult().getGeometry().getLocation().getLat());
                            getNearByPlaces(placeDetails.getResult().getGeometry().getLocation().getLat(),
                                    placeDetails.getResult().getGeometry().getLocation().getLng(),
                                    placeType);
                        }
                    });
                }
            }

            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.d("MainActivityMap", "onFailure: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    private void getDirections() {

        if(startPlace == null ){
            Toast.makeText(this, "Please enter origin location", Toast.LENGTH_SHORT).show();
        }else if(destinationPlace == null){
            Toast.makeText(this, "Please enter destination", Toast.LENGTH_SHORT).show();
        }else {
            isMapLoaded = true;
            invalidateOptionsMenu();
            Toast.makeText(this, "Please search gas stations and restaurant from menu.", Toast.LENGTH_SHORT).show();
            String url = "https://maps.googleapis.com/maps/api/directions/json?origin=place_id:" +
                    startPlace.getId() +
                    "&destination=place_id:" +
                    destinationPlace.getId() +
                    "&key=" +
                    getString(R.string.api_key);
            Log.d("MainActivityMap", "URL: " + url);
            Log.d("MainActivityMap", "ORIGIN: " + startPlace.getName());
            Log.d("MainActivityMap", "DESTINATION: " + destinationPlace.getName());
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    try (ResponseBody responseBody = response.body()) {
                        if (!response.isSuccessful())
                            throw new IOException("Unexpected code " + response);
                        DirectionApiResponse directionResponse = gson.fromJson(responseBody.charStream(), DirectionApiResponse.class);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                loadPolyline(directionResponse);
                            }
                        });
                    }
                }

                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e) {
                    Log.d("MainActivityMap", "onFailure: " + e.getMessage());
                    e.printStackTrace();
                }
            });
        }
    }

    private void loadPolyline(DirectionApiResponse directionResponse) {
        int count = 0;
        ArrayList<LatLng> points = null;
        DirectionApiResponse.Routes route = directionResponse.getRoutes().get(0);
        // Traversing through all the routes
        for(DirectionApiResponse.Routes.Legs leg : route.getLegs()){
            PolylineOptions lineOptions = new PolylineOptions();
            points = new ArrayList<LatLng>();
            Log.e("Route", leg.getStart_address()+" "+leg.getEnd_address());

            // Fetching all the points in i-th route
            //for(DirectionApiResponse.Routes.Legs.Steps step : leg.getSteps()){
            for(int j=0;j<leg.getSteps().size();j++){
                DirectionApiResponse.Routes.Legs.Steps step = leg.getSteps().get(j);
                points.addAll(PolyUtil.decode(step.getPolyline().getPoints()));
            }

            // Adding all the points in the route to LineOptions
            lineOptions.addAll(points);
            lineOptions.width(20);
          //  lineOptions.color(colors[count]);
            //Polyline polylineFinal = gMap.addPolyline(lineOptions);
            count++;
        }


        PolylineOptions rectLine = new PolylineOptions().width(8).color(
                Color.RED);
        for (int i = 0; i < points.size(); i++) {
            rectLine.add(points.get(i));
        }

        googleMap.clear();
        // Adding route on the map
        googleMap.addPolyline(rectLine);

        googleMap.addMarker(new MarkerOptions()
                .position(points.get(0))
                .title("Start Location"));
        googleMap.addMarker(new MarkerOptions()
                .position(points.get(points.size()-1))
                .title("End Location"));
        googleMap.isBuildingsEnabled();

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng latLng : points) {
            builder.include(latLng);
        }
        LatLngBounds bounds = builder.build();
        int padding = 100; // offset from edges of the map in pixels
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        googleMap.animateCamera(cu);
    }

    private void setStartLocation(int autocomplete_fragment, String hint) {
        String apiKey = getString(R.string.api_key);
        if (!Places.isInitialized()) {
            Places.initialize(getApplicationContext(), apiKey);
        }
        PlacesClient placesClient = Places.createClient(this);

        // Initialize the AutocompleteSupportFragment.
        AutocompleteSupportFragment autocompleteFragment = (AutocompleteSupportFragment)
                getSupportFragmentManager().findFragmentById(autocomplete_fragment);


       // Places.initialize(getApplicationContext(),getString(R.string.api_key));
        autocompleteFragment.setHint(hint);

       //autocompleteFragment.

        // Specify the types of place data to return.
        autocompleteFragment.setPlaceFields(Arrays.asList(Place.Field.ID, Place.Field.NAME));

       /* autocompleteFragment.getView().getAutofillValue()
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.d(TAG, "autocompleteFragment cleared");
                        autocompleteFragment.setText("");
                        view.setVisibility(View.GONE);
                    }
                });*/

        // Set up a PlaceSelectionListener to handle the response.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {

            @Override
            public void onError(@NonNull Status status) {
                Log.i(TAG, "An error occurred: " + status);

            }

            @Override
            public void onPlaceSelected(@NonNull Place place) {
                if(autocomplete_fragment == R.id.start_fragment){
                    runOnUiThread(() -> {
                        startPlace = place;
                    });
                }else{
                    runOnUiThread(() -> {
                        destinationPlace = place;
                    });
                }
                Log.i(TAG, "Place1: " + place.getName() + ", " + place.getId());
            }
        });
    }
}