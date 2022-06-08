import axios from 'axios';

export default {

    addPrize(prize) {
        return axios.post("/add-prize", prize) 
    },

    getPrizeByPrizeId(id) {
        return axios.get("/prize", id)
    },

    getPrizesByFamilyId() {
        return axios.get("/family-prize")
    },

    getWinners(prizeId) {
        return axios.get(`/${prizeId}/winners`)
    },

    getParticipants(prizeId){
        return axios.get(`/${prizeId}/participants`)
    },

    deletePrize(prizeId) {
        return axios.delete(`/deletePrize/${prizeId}`)
    }
}
