import { StyleSheet } from "react-native"

export  default  styles= StyleSheet.create({
    container:{
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center'
    },
    map:{
        width:'100%',
        height:'100%',
        position: 'absolute',
    },
    aedIcon:{
        backgroundColor: 'darkred',
        justifyContent: 'center',
        alignItems: 'center',
        width: 60, 
        height: 60, 
        borderRadius: 30, 
        marginBottom: 10,
        position: 'absolute',
        bottom: 110,
        left: 40,
        zIndex: 1,
    },
    aedText:{
        color: 'white',
        fontSize: 16,
    },
    aedInfo:{
        position: 'absolute', 
        bottom:30,
        width: '85%', 
        backgroundColor: 'white',
        padding: 10, 
        borderRadius: 10,
    },
    sec1:{
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent:'center',
    },
    aedState:{
        marginLeft:250,
        backgroundColor: 'green',
        borderRadius: 10,
    },
    aedStateText:{
        color: 'white',
        paddingHorizontal: 15,
        paddingVertical: 2,
        fontSize: 12,
    },
    text2:{
        fontSize: 13,
        color:'#999999',
        fontWeight: '500',
    },
    divider:{
        height: 1, 
        width: '100%', 
        backgroundColor: '#cccccc', 
        marginVertical: 10, 
    },
    sec3:{
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent:'center',
    },
    location:{
        flex:1,
        flexDirection: 'row',
        paddingLeft: 10,
    },
    guide:{
        marginLeft: 10,
        color:'blue'

    }
})