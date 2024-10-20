import {Tabs } from "expo-router";
import { Ionicons } from '@expo/vector-icons';
import { setStatusBarBackgroundColor } from "expo-status-bar";

export default ()=>{
    return(
        <Tabs 
        screenOptions={{
            tabBarShowLabel: false,
            tabBarStyle: { 
               backgroundColor: 'white',
               height:50
             },
             headerStyle: {
                 backgroundColor:'darkred',
             },
             headerTitleStyle: {
                fontWeight: 'bold',                     
                fontSize: 24,                           
                color: 'white',                         
              },
              headerTitleAlign: 'center',
        }}
           
        >
            {/* <Tabs.Screen name="map" /> */}
            <Tabs.Screen
                

                name="map"
                options={{
                title: 'AED地图',
                
                tabBarIcon: ({ color, size,focused }) => (
                    <Ionicons name="map" color={focused?"darkred":"gray"} size={size} />
                ),
                }}
            />
            <Tabs.Screen
                name="sos"
                options={{
                title: 'SOS',
                tabBarIcon: ({ color, size,focused }) => (
                    <Ionicons name="alert-circle" color={focused?"darkred":"gray"} size={size} />
                ),
                }}
            />
            <Tabs.Screen
                name="tutor"
                options={{
                title: '学急救',
                tabBarIcon: ({ color, size,focused }) => (
                    <Ionicons name="book" color={focused?"darkred":"gray"} size={size} />
                ),
                }}
            />
            <Tabs.Screen
                name="user"
                options={{
                title: '用户',
                tabBarIcon: ({ color, size,focused }) => (
                    <Ionicons name="person" color={focused?"darkred":"gray"} size={size} />
                ),
                }}
            />

        </Tabs>
    )
}