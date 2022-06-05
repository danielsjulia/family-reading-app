import axios from 'axios';

export default {

    getReadingLogByLogId(id){
        return axios.get(`/readingLog/${id}`)
    },

    getReadingLogByFamilyId(){
        return axios.get('/myFamily/readingLog')
    },

    getReadingLogByUserId(id){
        return axios.get(`/${id}/readingLog`)
    },

    getReadingLogDTOByUserId(id){
        return axios.get(`/display/${id}`)
    },

    addReadingLog(readingLog){
        return axios.post('/add-log',readingLog)
    }
}
