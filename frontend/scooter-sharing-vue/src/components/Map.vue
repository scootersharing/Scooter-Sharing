<template>
  <div id="map">
    <l-map :zoom="zoom" :center="center" style="height: 100%; width: 100%; top: 0; left: 0; position: absolute; z-index: 200">
      <l-tile-layer :url="url" :attribution="attribution"></l-tile-layer>
      <l-marker :lat-lng="marker"></l-marker>
    </l-map>
  </div>
</template>

<script>
import L from "leaflet";
import { LMap, LTileLayer, LMarker } from "vue2-leaflet";

export default {
  name: "MyAwesomeMap",
  components: {
    LMap,
    LTileLayer,
    LMarker
  },
  data: function() {
    return {
      zoom: 6,
      center: L.latLng(47.41322, -1.219482),
      url: "http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
      attribution:
        '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
      marker: L.latLng(47.41322, -1.219482)
    };
  }
};
</script>

<style>
html, body, #map {
  height: 100%;
  width: 100%;

}
</style>
