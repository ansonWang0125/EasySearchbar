import React, { useState, useEffect } from 'react';
import Box from '@mui/material/Box';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemText from '@mui/material/ListItemText';
import { apiStudentInfo } from '../../axios/api';
import Divider from '@mui/material/Divider';
import './css/Information.css';

export default function Information () {
    const href = window.location.href
    const id = href.substring(href.lastIndexOf('/')+1).split("=")[1].split(",")[0] !== undefined? href.substring(href.lastIndexOf('/')+1).split("=")[1].split(",")[0] : -1;
    const semester = href.substring(href.lastIndexOf('/')+1).split("=")[2] !== undefined? href.substring(href.lastIndexOf('/')+1).split("=")[2] : -1;
    console.log('id = ', id)
    console.log('semester = ', semester)
    const [studentInfo, setStudentInfo] = useState("");
    const [notfind, setNotfind] = useState(true);
    async function showArticles (credentials)  {
        return apiStudentInfo(credentials)
         .then(response=> {
            if (response.status === 200) {
                return response.data
            }
            if (!response.ok) {throw new Error(response.status)}
         })
         .catch((error) => {
            console.log('error: ' + error);
         })
    }
    useEffect( ()=>{
        const fetchData = async () => {
            const response = await showArticles({sid:id, semester});
            console.log(response.success)
            if (response.success) {
                setStudentInfo(response.studentInform)
                console.log(response.studentInform)
                setNotfind(false)
            }else {
                setNotfind(true)
            }
        }
        fetchData()
    },[id, semester])
    return (
        <div className='information'>
            <Box sx={{ width: '60%', maxWidth: 600, bgcolor: 'background.paper', border:1 }}>
                <List sx={{padding:'0%'}}>
                    <ListItem disablePadding sx={{background:"gray"}}>
                        <ListItemText primary="Enrollments" className="Title"/>
                    </ListItem>
                    {notfind?
                    (
                    <ListItem disablePadding sx={{background:"white"}}>
                        <ListItemText primary="No Enrollment" className="List"/>
                    </ListItem>
                    )
                    :
                    (<>
                        <ListItem disablePadding sx={{background:"white"}}>
                            <ListItemText primary="semester" className="List" sx={{ width: '50%' }}/>
                            <Divider orientation="vertical" variant='fullWidth' flexItem className="Divider" sx={{ height:33}}/>
                            <ListItemText primary={semester} className="List" sx={{ width: '50%' }}/>
                        </ListItem>
                        <Divider className="Divider"/>
                        <ListItem disablePadding sx={{background:"white"}}>
                            <ListItemText primary="ID/name" className="List" sx={{ width: '50%' }}/>
                            <Divider orientation="vertical" variant='fullWidth' flexItem className="Divider" sx={{ height:33}}/>
                            <ListItemText primary={id + "/" + studentInfo[0].name} className="List" sx={{ width: '50%' }}/>
                        </ListItem>
                        <Divider className="Divider"/>
                        <ListItem disablePadding sx={{background:"white"}}>
                            <ListItemText primary="courses" className="List" sx={{ width: '50%' }}/>
                            <Divider orientation="vertical" variant='fullWidth' flexItem className="Divider" sx={{ height:200}}/>
                            <List sx={{padding:'0%',width: '50%'}}>
                                {studentInfo.map(inform=>{return(
                                    <ListItem disablePadding sx={{background:"white"}}>
                                        <ListItemText primary={inform.course} className="List"/>
                                    </ListItem>
                                )})
                                }
                            </List>
                        </ListItem>
                    </>)
                    }
                </List>
            </Box>
        </div>
    )
}