import React from 'react';
import { View, Text, TouchableOpacity, StyleSheet, Alert } from 'react-native';
import { FontAwesome5 } from '@expo/vector-icons'; // 导入图标库

export default function Sos() {
  // 弹出确认框
  const showAlert = () => {
    Alert.alert(
      '紧急报警',
      '是否确认发出报警？',
      [
        { text: '取消', style: 'cancel' },
        { text: '确认', onPress: () => alert('报警成功') },
      ]
    );
  };
    const location="广东省广州市番禺区大学城穗石大道"
  return (

    
    
    <View style={styles.container}>

        <View 
            style={{
                 position: 'absolute',
                top:'10%'
            }}
        >
            <Text
                style={{
                    fontSize: 25,
                    fontWeight:'bold',
                    color: '#fff',
                    textAlign: 'center',
                }}
            >
                SOS紧急救援 切勿谎报
            </Text>
        </View>
        <View
            style={{
                position: 'absolute',
                top:'20%'
            }}
        >
            
            <Text
            style={styles.instructionText}>
                紧急援助发起将会通知周围用户并且拨打急救电话 120
            </Text>
            <Text
            style={styles.instructionText}>
            
                目前呼叫位置：{location}
            </Text>
        </View>

      {/* 大圆形SOS按钮 */}
      <TouchableOpacity style={styles.sosButton} onPress={showAlert}>
        <FontAwesome5 name="phone" size={50} color="white" />
      </TouchableOpacity>

      {/* 按钮下方的说明文本 */}
      <Text style={styles.instructionText}>按下按钮来发出紧急报警</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignContent: 'center',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#283747',
  },
  sosButton: {
    width: 200,
    height: 200,
    borderRadius: 100, // 半径为宽度的一半，形成圆形
    backgroundColor: 'darkred',
    justifyContent: 'center',
    alignItems: 'center',
    marginBottom: 20, // 距离下方的文本有些间距
  },
  instructionText: {
    fontSize: 16,
    color: '#fff',
    textAlign: 'center',
    marginBottom:10,
  },
});
