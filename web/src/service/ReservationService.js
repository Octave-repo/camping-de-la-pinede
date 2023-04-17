import ReservationApi from "@/api/ReservationApi";
class ReservationService{
    postReservation(reservation){
        return ReservationApi.postReservation(reservation);
    }
}
export default new ReservationService();