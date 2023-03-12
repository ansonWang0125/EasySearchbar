import React, {useState, useEffect, useCallback, useRef} from 'react';
import { useNavigate } from "react-router-dom"
import SearchBar from '../../Components/SearchBar/SearchBar';
import Box from '@mui/material/Box';
import List from '@mui/material/List';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemText from '@mui/material/ListItemText';
import Divider from '@mui/material/Divider';
import { apiStudentSearch } from '../../axios/api';
import './css/Main.css';

export default function Main () {
    const [searchStr, setSearchStr] = useState('');
    const [studentInfo, setStudentInfo] = useState([]);
    const [notfind, setNotfind] = useState(true);
    const [searching, setSearching] = useState('');
    const [loading, setLoading] = useState(false)
    const loader = useRef(null);
    const [nomore, setNomore] = useState(false);
    const [error, setError] = useState(false)
    const [refresh, setRefresh] = useState(false);
    const [refreshCount, setRefreshCount] = useState(0);
    const navigate = useNavigate();
    async function searchStudentInfo (credentials)  {
        return apiStudentSearch(credentials)
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
    const handleObserver = useCallback((entries) => {
        const target = entries[0];
        if (target.isIntersecting) {
            setRefreshCount((prev)=>prev+1)
            setRefresh(true);
        }
      }, []);
    const refreshData = useCallback(async () => {
        try{
            setLoading(true)
            const dataNum = studentInfo.length
            const response = await searchStudentInfo({searchStr:searching,dataNum});
            if (studentInfo && !nomore) {
                var addData = response.studentInform
                if ( response.studentInform === undefined) {
                    addData = []
                }else if (response.studentInform.length < 15){
                    setNomore(true)
                }
                const newData = studentInfo.concat(addData)
                setStudentInfo(newData)
                setNotfind(false)
                setLoading(false)
            } else if (nomore) {
                setLoading(false)
            }
            else{
                setNotfind(true)
                setLoading(false)
            }
        } catch (err) {
            setError(true)
            console.log(err)
        }
    },[studentInfo, nomore, searching])

    useEffect ( ()=>{
        if (!nomore && refresh && refreshCount > 1){
            refreshData()
        }
    }, [ refreshData, refresh, nomore, studentInfo.length, refreshCount ])
    useEffect(() => {
        const option = {
            root: null,
            rootMargin: "20px",
            threshold: 0
          };
        const observer = new IntersectionObserver(handleObserver, option);
        if (loader.current) {
            observer.observe(loader.current);
        }
    }, [handleObserver])
    const handleSearch = async (e) => {
        e.preventDefault()
        console.log("searching...")
        setSearching(searchStr)
        if (searchStr){
            const response = await searchStudentInfo({searchStr: searchStr})
            console.log(response.studentInform)
            if (response.success) {
                setStudentInfo(response.studentInform)
                setNotfind(false)
                if (response.studentInform.length < 15 ){
                    setNomore(true)
                    setLoading(false)
                }
            }else {
                setNotfind(true)                              
                setNomore(true)
                setLoading(false)
            }
        }
    }
    const handleListOnClick = (e, sid, semester) =>{
        e.preventDefault()
        navigate('/information/id='+sid+",semester="+ semester)
    }
    return (
        <div className='main'>
            <SearchBar searchStr={searchStr} setSearchStr={setSearchStr} handleSearch={handleSearch}/>
            <Box sx={{ width: '60%', maxWidth: 600, bgcolor: 'background.paper', border:1 }}>
                <List sx={{padding:'0%'}}>
                    <ListItem disablePadding sx={{background:"gray"}}>
                            <ListItemText primary="Enrollments" className="Title"/>
                        </ListItem>
                    <Divider className="Divider"/>
                    <ListItem disablePadding sx={{background:"gray"}}>
                            <ListItemText primary="semester" className="Title" sx={{ width: '50%' }}/>
                            <Divider orientation="vertical" variant='fullWidth' flexItem className="Divider"/>
                            <ListItemText primary="ID/name" className="Title" sx={{ width: '50%' }}/>
                    </ListItem>
                    {notfind?
                    (
                    <ListItem disablePadding sx={{background:"white"}}>
                        <ListItemText primary="No Enrollment" className="List"/>
                    </ListItem>
                    )
                    :
                    (<>
                        {studentInfo.map((inform, i)=> {
                            return (
                                <div key={i}>
                                    <ListItem disablePadding sx={{background:"white"}}>
                                        <ListItemButton onClick={e => handleListOnClick(e,inform.sid, inform.semester)} dense className="listbutton" sx={{paddingTop:"0%", paddingBottom:"0%"}}>
                                            <ListItemText primary={inform.semester} className="List" sx={{ width: '50%' }}/>
                                            <Divider orientation="vertical" variant='fullWidth' flexItem className="Divider" sx={{ height:33}}/>
                                            <ListItemText primary={inform.sid + "/" + inform.name} className="List" sx={{ width: '50%' }}/>
                                        </ListItemButton>
                                    </ListItem>
                                {i + 1 === studentInfo.length? <></>:<Divider />}
                                </div>
                            )
                        })}
                    </>)
                    }
                </List>
            </Box>
            {notfind && loading && <p>Loading...</p>}
            {error && <p>Error!</p>}
            <div ref={loader} id='sensor'/>
        </div>
    )
}