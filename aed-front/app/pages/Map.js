//这里实现“地图”页面
import React from 'react'
import { View, Text, Button, Image, StyleSheet,TouchableOpacity } from 'react-native'
import { Ionicons } from '@expo/vector-icons'
import FontAwesome5 from '@expo/vector-icons/FontAwesome5';
import MapStyles from './style'

export default function Map() {


    return (
        <View className="container"
            style={styles.container}
        > 
            
            <Image className="map" source={require('../../assets/imgs/maps.png')} 
                style={styles.map}
            />

            <View className="aedIcon"
                style={styles.aedIcon}
            >
                <FontAwesome5 name="heartbeat" size={20} color="white" />
                <Text
                    style={styles.aedText}
                >AED</Text>
            </View>

           <View
           className="AED-info"
           style={styles.aedInfo}
           >
            <View className="sec-1"
                style={styles.sec1}
            >
                <View className="aedState"
                    style={styles.aedState}
                >
                    <Text
                        style={styles.aedStateText}
                    >正常</Text>
                </View>
            </View>

            <View className="sec-2">
                <Text className="text-1" > 华南理工大学（大学城城区）</Text>
                <Text className="text-2"
                    style={styles.text2}
                > 生活区运动场器材室门口</Text>
            </View>

            <View className="divider"
                style={styles.divider}
            >        
            </View>

            <View className="sec-3"
                style={styles.sec3}
            >
                {/* 位置图标 */}
                <View
                    style={styles.location}
                >
                    <Ionicons name="location-outline" size={20} color="black" 
                        style={{
                            marginRight: 5,
                        }}
                    />
                    <Text>
                    距离您 1.2km
                    </Text>
                    
                </View>
                {/* 导航图标 */}
                <View 
                    style={{
                        flex:1,
                        flexDirection: 'row',
                        paddingLeft: 15,
                    }}
                >
                    <Ionicons name="navigate-outline" size={20} color="blue" />
                    {/* 这里要实现一个导航功能 */}
                    <Text 
                        style={styles.guide}
                    >
                      导航
                    </Text>
                </View>
            </View>
            
           </View>
            
            <View className='Guide-btn'
                style={{
                    position: 'absolute', // 绝对定位
                    top: 20, // 距离顶部20像素
                    right: 20, // 距离右侧20像素
                    zIndex: 1, // 确保按钮在其他内容之上
                    width:'10'
                }}
            >
                <TouchableOpacity
                    style={{
                        backgroundColor: 'darkred', // 按钮背景色
                        padding: 15, // 按钮内边距
                        borderRadius: 5, // 圆角
                        alignItems: 'center', // 使文字居中
                        
                        
                        
                    }}
                >
                     <Text
                        style={{
                            color: 'white', // 文字颜色
                             
                        }}
                    >导航最近AED</Text>
                </TouchableOpacity>
                
            </View>
            
        </View>
    )
}