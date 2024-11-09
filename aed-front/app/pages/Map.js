//这里实现“地图”页面
import React from 'react'
import { View, Text, Button, Image, StyleSheet,TouchableOpacity } from 'react-native'
import { Ionicons } from '@expo/vector-icons'
import FontAwesome5 from '@expo/vector-icons/FontAwesome5';
import MapStyles from './style'
import { WebView } from 'react-native-webview';
import { useState ,useRef,useEffect } from 'react';
process.env.NODE_TLS_REJECT_UNAUTHORIZED = '0';


export default function Map() {

    

    /* Aed信息变量 */
    const [name,setName]= useState('');
    const [currentAed,setCurrentAed]= useState([]);
    const [address,setAddress]= useState('');
    const [distance,setDistance]= useState('');
    const [aedCount,setAedCount]= useState('');
    const [nerestAed,setNerestAed]= useState('');
    const webViewRef = useRef(null);

    const reloadWebView = () => {
        if (webViewRef.current) {
        webViewRef.current.reload(); // 刷新 WebView
        }
    };
    const handleNavigation = () => {
        const aed = {
          latitude: currentAed.latitude,
          longitude: currentAed.longitude,
          action:"startNavigation"
        };
    
        if (webViewRef.current) {
            webViewRef.current.postMessage(JSON.stringify(aed));
            console.log('导航到当前AED',aed);
        }
        
      };
      const handleNavigationNere = () => {
        const aed ={
          latitude: nerestAed.latitude,
          longitude: nerestAed.longitude,
          action:"startNavigation"
        };
        setAddress(nerestAed.address);
        setDistance(nerestAed.distance);
        if (webViewRef.current) {
            webViewRef.current.postMessage(JSON.stringify(
                
                aed
              ));
        }
        console.log('导航到最近的AED',aed);
      };
      const cancelNavigation = () => {
        const aed={
            action:"cancelNavigation"
        }
        if (webViewRef.current) {
            webViewRef.current.postMessage(JSON.stringify(
                
                aed
              ));
        }
      };

      
      


    const [aeds, setAeds] = useState([]);

  
   

    return (
        <View className="container"
            style={styles.container}
        > 
            {/*这里实现地图显示 */}


                 {/* <Image className="map" source={require('../../assets/imgs/maps.png')} 
                style={styles.map}
            />      */}

              <View
                style={{
                    
                    width: '100%',
                    height: '100%',
                }}
              >
               
                <WebView
                    ref={webViewRef}
                    originWhitelist={['https://*']}
                    javaScriptEnabled={true}
                    domStorageEnabled={true}
                    startInLoadingState={true}
                    scalesPageToFit={true}
                    mixedContentMode="always"
                    source={{ uri:`https://zhburger.github.io/ViteTest/` }}
                    
                    
                    
                    onError={(e) => console.log('Error loading:', e.nativeEvent)}
                    onLoad={() => console.log('Page loaded successfully')}

                    
                      onMessage={(event) => {
                        const { data } = event.nativeEvent;
                        try {
                          const message = JSON.parse(data); // 解析 JSON 消息
                          if(message.type=='INIT_AED'){
                            setNerestAed(message);
                            console.log('最近的aed信息:',nerestAed);
                          }
                            // 更新 AED 信息
                            console.log('AED信息',message);
                            setCurrentAed(message);
                            
                            setAddress(message.address);
                            setDistance(message.distance);
                          
                          
                        } catch (error) {
                          console.log('Message from WebView:', data); // 保留现有逻辑
                        }
                      }}
                      
                    />
                
                            
              </View>

            


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
                    {/* 这里到时候动态显示当前aed的数据，点击webview里面的aedMark，这里显示 */}
            <View className="sec-2">
                <Text className="text-1" > 华南理工大学（大学城城区）</Text>
                <Text className="text-2"
                    style={styles.text2}
                > {address}
                    
                </Text>
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
                    距离您 {distance*1000}m
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
                    <TouchableOpacity onPress={handleNavigation}
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
                    </TouchableOpacity>
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
                <TouchableOpacity  onPress={handleNavigationNere}
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
                        /* 一键导航按钮 */
                    >导航最近AED</Text>
                </TouchableOpacity>
            </View>


            <View className='cancel-btn'
                style={{
                    position: 'absolute', // 绝对定位
                    top: 75, // 距离顶部20像素
                    right: 20, // 距离右侧20像素
                    zIndex: 1, // 确保按钮在其他内容之上
                    width:'10'
                }}
            >
                <TouchableOpacity  onPress={cancelNavigation}
                    style={{
                        backgroundColor: 'darkred', // 按钮背景色
                        padding:5,
                        borderRadius: 5, // 圆角
                        alignItems: 'center', // 使文字居中
                    }}
                >
                     <Text
                        style={{
                            color: 'lightgray', // 文字颜色
                            fontSize: 10,
                            fontWeight: 'bold',
                        }}
                        
                    >取消导航</Text>
                </TouchableOpacity>
            </View>
            
        </View>
    )
}