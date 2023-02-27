function onGeoOk(position){
  const lat = position.coords.latitude;
  const lng = position.coords.longitude;
  console.log(position);
}

function onGeoError() {
  alert("Can")
}

navigator.geolocation.getCurrentPosition(onGeoOk, onGeoError);