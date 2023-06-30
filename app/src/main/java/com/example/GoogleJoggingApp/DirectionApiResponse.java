package com.example.GoogleJoggingApp;

import java.util.ArrayList;
/*
        #.HW08
        DirectionApiResponse.java
        Sachin Kumar and Arundhati Mishra
*/
public class DirectionApiResponse {
    private ArrayList<Geocoded_waypoints> geocoded_waypoints;

    private String status;

    private ArrayList<Routes> routes;

    public ArrayList<Geocoded_waypoints> getGeocoded_waypoints ()
    {
        return geocoded_waypoints;
    }

    public void setGeocoded_waypoints (ArrayList<Geocoded_waypoints> geocoded_waypoints)
    {
        this.geocoded_waypoints = geocoded_waypoints;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public ArrayList<Routes> getRoutes ()
    {
        return routes;
    }

    public void setRoutes (ArrayList<Routes> routes)
    {
        this.routes = routes;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [geocoded_waypoints = "+geocoded_waypoints+", status = "+status+", routes = "+routes+"]";
    }


    public class Geocoded_waypoints
    {
        private String place_id;

        private String geocoder_status;

        private ArrayList<String> types;

        public String getPlace_id ()
        {
            return place_id;
        }

        public void setPlace_id (String place_id)
        {
            this.place_id = place_id;
        }

        public String getGeocoder_status ()
        {
            return geocoder_status;
        }

        public void setGeocoder_status (String geocoder_status)
        {
            this.geocoder_status = geocoder_status;
        }

        public ArrayList<String> getTypes ()
        {
            return types;
        }

        public void setTypes (ArrayList<String> types)
        {
            this.types = types;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [place_id = "+place_id+", geocoder_status = "+geocoder_status+", types = "+types+"]";
        }
    }
    public class Routes {
        private String summary;

        private Bounds bounds;

        private String copyrights;

        private ArrayList<String> waypoint_order;

        private ArrayList<Legs> legs;

        private ArrayList<String> warnings;

        private Overview_polyline overview_polyline;

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public Bounds getBounds() {
            return bounds;
        }

        public void setBounds(Bounds bounds) {
            this.bounds = bounds;
        }

        public String getCopyrights() {
            return copyrights;
        }

        public void setCopyrights(String copyrights) {
            this.copyrights = copyrights;
        }

        public ArrayList<String> getWaypoint_order() {
            return waypoint_order;
        }

        public void setWaypoint_order(ArrayList<String> waypoint_order) {
            this.waypoint_order = waypoint_order;
        }

        public ArrayList<Legs> getLegs() {
            return legs;
        }

        public void setLegs(ArrayList<Legs> legs) {
            this.legs = legs;
        }

        public ArrayList<String> getWarnings() {
            return warnings;
        }

        public void setWarnings(ArrayList<String> warnings) {
            this.warnings = warnings;
        }

        public Overview_polyline getOverview_polyline() {
            return overview_polyline;
        }

        public void setOverview_polyline(Overview_polyline overview_polyline) {
            this.overview_polyline = overview_polyline;
        }

        @Override
        public String toString() {
            return "ClassPojo [summary = " + summary + ", bounds = " + bounds + ", copyrights = " + copyrights + ", waypoint_order = " + waypoint_order + ", legs = " + legs + ", warnings = " + warnings + ", overview_polyline = " + overview_polyline + "]";
        }

        public class Bounds
        {
            private Southwest southwest;

            private Northeast northeast;

            public Southwest getSouthwest ()
            {
                return southwest;
            }

            public void setSouthwest (Southwest southwest)
            {
                this.southwest = southwest;
            }

            public Northeast getNortheast ()
            {
                return northeast;
            }

            public void setNortheast (Northeast northeast)
            {
                this.northeast = northeast;
            }

            @Override
            public String toString()
            {
                return "ClassPojo [southwest = "+southwest+", northeast = "+northeast+"]";
            }

            public class Southwest
            {
                private String lng;

                private String lat;

                public String getLng ()
                {
                    return lng;
                }

                public void setLng (String lng)
                {
                    this.lng = lng;
                }

                public String getLat ()
                {
                    return lat;
                }

                public void setLat (String lat)
                {
                    this.lat = lat;
                }

                @Override
                public String toString()
                {
                    return "ClassPojo [lng = "+lng+", lat = "+lat+"]";
                }
            }

            public class Northeast
            {
                private String lng;

                private String lat;

                public String getLng ()
                {
                    return lng;
                }

                public void setLng (String lng)
                {
                    this.lng = lng;
                }

                public String getLat ()
                {
                    return lat;
                }

                public void setLat (String lat)
                {
                    this.lat = lat;
                }

                @Override
                public String toString()
                {
                    return "ClassPojo [lng = "+lng+", lat = "+lat+"]";
                }
            }
        }

        public class Overview_polyline {
            private String points;

            public String getPoints() {
                return points;
            }

            public void setPoints(String points) {
                this.points = points;
            }

            @Override
            public String toString() {
                return "ClassPojo [points = " + points + "]";
            }

        }

        public class Legs {
            private Duration duration;

            private Distance distance;

            private End_location end_location;

            private String start_address;

            private String end_address;

            private Start_location start_location;

            private ArrayList<String> traffic_speed_entry;

            private ArrayList<String> via_waypoint;

            private ArrayList<Steps> steps;

            public Duration getDuration() {
                return duration;
            }

            public void setDuration(Duration duration) {
                this.duration = duration;
            }

            public Distance getDistance() {
                return distance;
            }

            public void setDistance(Distance distance) {
                this.distance = distance;
            }

            public End_location getEnd_location() {
                return end_location;
            }

            public void setEnd_location(End_location end_location) {
                this.end_location = end_location;
            }

            public String getStart_address() {
                return start_address;
            }

            public void setStart_address(String start_address) {
                this.start_address = start_address;
            }

            public String getEnd_address() {
                return end_address;
            }

            public void setEnd_address(String end_address) {
                this.end_address = end_address;
            }

            public Start_location getStart_location() {
                return start_location;
            }

            public void setStart_location(Start_location start_location) {
                this.start_location = start_location;
            }

            public ArrayList<String> getTraffic_speed_entry() {
                return traffic_speed_entry;
            }

            public void setTraffic_speed_entry(ArrayList<String> traffic_speed_entry) {
                this.traffic_speed_entry = traffic_speed_entry;
            }

            public ArrayList<String> getVia_waypoint() {
                return via_waypoint;
            }

            public void setVia_waypoint(ArrayList<String> via_waypoint) {
                this.via_waypoint = via_waypoint;
            }

            public ArrayList<Steps> getSteps() {
                return steps;
            }

            public void setSteps(ArrayList<Steps> steps) {
                this.steps = steps;
            }

            @Override
            public String toString() {
                return "ClassPojo [duration = " + duration + ", distance = " + distance + ", end_location = " + end_location + ", start_address = " + start_address + ", end_address = " + end_address + ", start_location = " + start_location + ", traffic_speed_entry = " + traffic_speed_entry + ", via_waypoint = " + via_waypoint + ", steps = " + steps + "]";
            }


            public class Duration {
                private String text;

                private String value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                @Override
                public String toString() {
                    return "ClassPojo [text = " + text + ", value = " + value + "]";
                }
            }
            public class Start_location
            {
                private String lng;

                private String lat;

                public String getLng ()
                {
                    return lng;
                }

                public void setLng (String lng)
                {
                    this.lng = lng;
                }

                public String getLat ()
                {
                    return lat;
                }

                public void setLat (String lat)
                {
                    this.lat = lat;
                }

                @Override
                public String toString()
                {
                    return "ClassPojo [lng = "+lng+", lat = "+lat+"]";
                }
            }

            public class End_location {
                private String lng;

                private String lat;

                public String getLng() {
                    return lng;
                }

                public void setLng(String lng) {
                    this.lng = lng;
                }

                public String getLat() {
                    return lat;
                }

                public void setLat(String lat) {
                    this.lat = lat;
                }

                @Override
                public String toString() {
                    return "ClassPojo [lng = " + lng + ", lat = " + lat + "]";
                }
            }

            public class Distance {
                private String text;

                private String value;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                @Override
                public String toString() {
                    return "ClassPojo [text = " + text + ", value = " + value + "]";

                }
            }

            public class Steps
            {
                private String html_instructions;

                private Duration duration;

                private Distance distance;

                private End_location end_location;

                private Polyline polyline;

                private Start_location start_location;

                private String travel_mode;

                public String getHtml_instructions ()
                {
                    return html_instructions;
                }

                public void setHtml_instructions (String html_instructions)
                {
                    this.html_instructions = html_instructions;
                }

                public Duration getDuration ()
                {
                    return duration;
                }

                public void setDuration (Duration duration)
                {
                    this.duration = duration;
                }

                public Distance getDistance ()
                {
                    return distance;
                }

                public void setDistance (Distance distance)
                {
                    this.distance = distance;
                }

                public End_location getEnd_location ()
                {
                    return end_location;
                }

                public void setEnd_location (End_location end_location)
                {
                    this.end_location = end_location;
                }

                public Polyline getPolyline ()
                {
                    return polyline;
                }

                public void setPolyline (Polyline polyline)
                {
                    this.polyline = polyline;
                }

                public Start_location getStart_location ()
                {
                    return start_location;
                }

                public void setStart_location (Start_location start_location)
                {
                    this.start_location = start_location;
                }

                public String getTravel_mode ()
                {
                    return travel_mode;
                }

                public void setTravel_mode (String travel_mode)
                {
                    this.travel_mode = travel_mode;
                }

                @Override
                public String toString()
                {
                    return "ClassPojo [html_instructions = "+html_instructions+", duration = "+duration+", distance = "+distance+", end_location = "+end_location+", polyline = "+polyline+", start_location = "+start_location+", travel_mode = "+travel_mode+"]";
                }


                public class Polyline
                {
                    private String points;

                    public String getPoints ()
                    {
                        return points;
                    }

                    public void setPoints (String points)
                    {
                        this.points = points;
                    }

                    @Override
                    public String toString()
                    {
                        return "ClassPojo [points = "+points+"]";
                    }
                }
            }
        }
    }
}
