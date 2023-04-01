class GPSService{
    toRadian(value){
        return value * (Math.PI /180);
    }
    toDegree(value){
        return value * (180/Math.PI);
    }

    findMiddle(pos1, pos2){
        let dLon = this.toRadian(pos2[1] - pos1[1]);

        let lat1 = this.toRadian(pos1[0]);
        let lat2 = this.toRadian(pos2[0]);
        let lon1 = this.toRadian(pos1[1]);

        let Bx = Math.cos(lat2) * Math.cos(dLon);
        let By = Math.cos(lat2) * Math.sin(dLon);
        let lat3 = Math.atan2(Math.sin(lat1) + Math.sin(lat2), Math.sqrt((Math.cos(lat1) + Bx) * (Math.cos(lat1) + Bx) + By * By));
        let lon3 = lon1 + Math.atan2(By, Math.cos(lat1) + Bx);
        return ([this.toDegree(lat3), this.toDegree(lon3)]);
    }
}

export default new GPSService();