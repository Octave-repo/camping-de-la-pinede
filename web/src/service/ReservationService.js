import ReservationApi from "@/api/ReservationApi";
class ReservationApi{
    postReservation(reservation){
        return ReservationApi.postReservation(reservation);
    }
}
export default new ReservationApi();