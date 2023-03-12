import axios from 'axios';

const studentRequest = axios.create({
    // baseURL: 'https://post-articles.onrender.com/api/env',
    baseURL: 'http://localhost:9090/api/enrollment'
 });

 export const apiStudentSearch = data => studentRequest.post('/search', data);
 export const apiStudentInfo = data => studentRequest.post('/inform', data);