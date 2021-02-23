<template>
  <div id="map">
    <l-map
      :zoom="zoom"
      :center="center"
      style="height: 100%; width: 100%; top: 0; left: 0; right: 0; bottom: 0; position: absolute; z-index: 200"
    >
      <l-tile-layer :url="url" :attribution="attribution"></l-tile-layer>
      <l-marker
        v-for="item in markers"
        :lat-lng="item.latlong"
        :key="item.latlong"
        ><l-popup>{{ ` Charge : % ${item.charge}` }}</l-popup>
      </l-marker>
    </l-map>
  </div>
</template>

<script>
import L from "leaflet";
import { LMap, LTileLayer, LMarker, LPopup } from "vue2-leaflet";
import axios from "axios";

export default {
  mounted() {
    this.fetch_scooter();
  },
  name: "MyAwesomeMap",
  components: {
    LMap,
    LTileLayer,
    LMarker,
    LPopup
  },

  data: function() {
    return {
      zoom: 13,
      center: L.latLng(40.99781459079409, 39.77124742925779),
      url: "http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
      attribution:
        '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
      markers: [
        {
          charge: 45.0,
          is_active: true,
          latlong: [40.99821561189367, 39.773015925500026]
        }
      ]
    };
  },

  methods: {
    fetch_scooter() {
      /*axios.post(
        "http://scootersharing.herokuapp.com/scooters",

        {
          charge: 74.0,
          is_active: false,
          latitude: 40.9930664162835,
          longitude: 39.77555146223996
        }
      );*/

      /*axios
        .delete("http://scootersharing.herokuapp.com/scooters/23")*/

      axios
        .get("http://scootersharing.herokuapp.com/scooters")
        .then(response => {
          response.data.forEach(element => {
            let tempObj = {
              charge: element.charge,
              is_active: element.is_active,
              latlong: [element.latitude, element.longitude]
            };
            this.markers.push(tempObj);
          });
        });
      console.log(this.markers);
    }
  }
};
</script>

<style>
html,
body,
#map {
  height: 100%;
  width: 100%;
}
</style>
