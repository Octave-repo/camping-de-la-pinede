import ReservationApi from "@/api/ReservationApi";
class ReservationService{
    postReservation(reservation){
        return ReservationApi.postReservation(reservation);
    }
    getReservationUtilisateur(id){
        return ReservationApi.getReservationUtilisateur(id)
    }
}
export default new ReservationService();