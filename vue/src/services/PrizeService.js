import axios from 'axios';

export default {

    addPrize(prize) {
        return axios.post("/add-prize", prize) 
    },

    getPrizeByPrizeId(id) {
        return axios.get("/prize", id)
    },

    getPrizeByFamilyId() {
        return axios.get("/family-prize")
    },

    

}
