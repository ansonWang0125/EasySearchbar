import axios from 'axios';

const studentRequest = axios.create({
    baseURL: 'http://localhost:9090/api/enrollment'
 });

 export const apiStudentSearch = data => studentRequest.post('/search', data);
 export const apiStudentInfo = data => studentRequest.post('/inform', data);