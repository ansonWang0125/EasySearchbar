import  React, { useRef } from "react";
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import useComponentVisible from "../../hook/useComponentVisible"
import IconButton from '@mui/material/IconButton';
import ClearIcon from '@mui/icons-material/Clear';
import SearchIcon from '@mui/icons-material/Search';
import './css/SearchBar.css';

export default function SearchBar ({searchStr, setSearchStr, handleSearch}) {
    const searchRef = useRef(null)
    const {ref, isComponentVisible} = useComponentVisible(false)
    const handleClick = () => {
        searchRef.current.focus()
    }
    const handleClearClick = () => {
        setSearchStr('')
    }
    return (
        <div className='Searchbar'>
            <Box
                sx={{
                    display: 'flex',
                    flexWrap: 'wrap',
                    '& > :not(style)': {
                    m: 1,
                    height: 50,
                    },
                }}
                id='box'
                ref={ref}
            >
                <Paper elevation={1} id='searchPaper' onClick={handleClick}>
                    <form onSubmit={handleSearch} id = 'searchForm'>
                        <input id='searchinput' 
                            placeholder='Search'
                            value={searchStr}
                            onChange={e=>setSearchStr(e.target.value)} 
                            ref={searchRef}
                            />
                        {isComponentVisible && searchStr ?
                            <IconButton
                                onClick={handleClearClick}
                            >
                                <ClearIcon fontSize="large"/>
                            </IconButton>
                        :
                            <IconButton>
                                <SearchIcon fontSize="large"/>
                            </IconButton>
                        }
                    </form>
                </Paper>
            </Box>
        </div>
    )
}