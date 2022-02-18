import axios from 'axios';

export default {

    getLatLng(address) {
        const key = "AIzaSyAK5lkEFlfsXeuBKTAdVInZPq3pBveOZVo";
        console.log('address' + address);
        return axios.get(`https://maps.googleapis.com/maps/api/geocode/json?address=${address}&key=${key}`);
    }

}

