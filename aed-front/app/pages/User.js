import React, { useState } from 'react';
import { View, Text, Button, TextInput, StyleSheet ,Image} from 'react-native';
import AsyncStorage from '@react-native-async-storage/async-storage';
import EvilIcons from '@expo/vector-icons/EvilIcons';
import * as ImagePicker from 'expo-image-picker';
import { TouchableOpacity } from 'react-native';
import FontAwesome6 from '@expo/vector-icons/FontAwesome6';

export default function User() {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [isLoggedIn, setIsLoggedIn] = useState(true);
    const [image, setImage] = useState(null);  // 用于存储图片URI

    const pickImage = async () => {
        // 请求相机或图库权限
        let result = await ImagePicker.requestMediaLibraryPermissionsAsync();
        
        if (result.granted === false) {
          alert('需要访问图库的权限');
          return;
        }
    
        // 打开图片选择器
        let pickerResult = await ImagePicker.launchImageLibraryAsync({
          mediaTypes: ImagePicker.MediaTypeOptions.Images,
          allowsEditing: true,
          aspect: [4, 3],
          quality: 1,
        });
    
        if (!pickerResult.cancelled) {
          setImage(pickerResult.uri);  // 将图片URI保存到状态中
        }
      };

    const login = async () => {
        try {
            // 调用后端 API 进行登录请求
            const response = await fetch('https://your-backend.com/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ username, password })
            });
            const data = await response.json();

            if (data.token) {
                // 将返回的 JWT 存储在 AsyncStorage
                await AsyncStorage.setItem('userToken', data.token);
                setIsLoggedIn(true); // 设置为登录状态
            } else {
                alert('登录失败，请检查用户名和密码');
            }
        } catch (error) {
            console.error('Login error', error);
        }
    };

    const logout = async () => {
        // 清除存储的 JWT
        await AsyncStorage.removeItem('userToken');
        setIsLoggedIn(false); // 切换到未登录状态
    };

    return (
        <View style={{
            backgroundColor: '#283747',
            flex: 1,
        }} >
            {!isLoggedIn ? (
                
                
                <View 
                    style={{
                        alignItems: 'center',
                        
                        flex: 1
                    }}
                >
                    <EvilIcons name="user" size={180} color="white" 
                        style={{
                            marginBottom: 20,
                        }}
                    />
                    <TextInput
                        style={styles.input}
                        placeholder="请输入学号"
                        value={username}
                        onChangeText={setUsername}
                    />
                    <TextInput
                        style={styles.input}
                        placeholder="密码"
                        secureTextEntry
                        value={password}
                        onChangeText={setPassword}
                    />
                    <TouchableOpacity onPress={login}
                        style={{
                            width:'45%',
                            height: 40,
                            backgroundColor: 'darkred',
                            justifyContent: 'center',
                            alignItems : 'center',
                            borderRadius: 20,
                        }}
                    >
                        <Text
                            style={{
                                color:'white',
                                fontSize: 18,
                                fontWeight: 'bold',
                            }}
                        >登录</Text>
                        
                    </TouchableOpacity>
                    
                    <Text>
                        
                    </Text>
                </View>
            ) : (
                <View style={{
                    marginTop:'5%',
                    justifyContent: 'center',
                    alignItems: 'center',
                    backgroundColor: '#283747',
                }}>
                    <View
                       
                    >
                        {image ?<Image source={{ uri: image }}  />
                        :<Image source={require('../../assets/imgs/default.png')} 
                            style={{
                                width: 140,
                                height: 140,
                                borderRadius: 70,
                            }}
                        />}

                        {/* 上传头像按钮 */}
                        <TouchableOpacity onPress={pickImage}
                            style={{
                                position: 'absolute',
                                bottom: -1,
                                right: 2,
                            }}
                        >
                            <FontAwesome6 name="add" size={18} color="white" />
                        </TouchableOpacity>

                    </View>
                    
                    <View 
                        style={{
                            
                        }}
                    >
                       
                        <Text
                            style={{
                                color:'white',
                                marginTop:5,
                            }}
                        >
                           用户 ：202330452341

                        </Text>
                        <Text
                            style={{
                                color:'white',
                                marginTop:5,
                            }}
                        >
                            状态：已登录
                        </Text>
                        <TouchableOpacity onPress={logout}
                            style={{
                                marginTop:10,
                                backgroundColor: 'darkred',
                                borderRadius: 5,
                                padding: 5,
                                alignItems: 'center',
                            }}
                        >
                            <Text
                                style={{
                                    color:'white',
                                    fontSize: 18,
                                    fontWeight: 'bold',
                                    paddingVertical: 1,
                                }}
                            >注销</Text>
                        </TouchableOpacity>
                    </View>
                    {/* <Text style={styles.loggedInText}>已登录</Text>
                    <Button title="注销" onPress={logout} /> */}
                </View>
            )}
        </View>
    );
}

const styles = StyleSheet.create({
   
    input: {
        width:'70%',
        padding: 10,
        marginBottom: 10,
        backgroundColor: '#fff',
    },
    loggedInText: {
        color: '#fff',
        fontSize: 20,
    },
    avatar:{
        width: 100,
        height: 100,
        borderRadius: 50,
    }

});
