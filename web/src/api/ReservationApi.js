import InstanceAxios from "./index";

//Pour changer entre le chemin réel et le chemin mock
const url = 'http://localhost:'
const mock_port = '8082'

const path = `${url}${mock_port}`
class ReservationApi{
    postReservation(reservation){
        return InstanceAxios.post(`${path}/reservation/`, reservation);
    }
}
export default new ReservationApi();