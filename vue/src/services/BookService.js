import axios from 'axios';

export default {

    getAllBooksByUserId(userId){
        return axios.get('/userBooks', userId)

    },


}
