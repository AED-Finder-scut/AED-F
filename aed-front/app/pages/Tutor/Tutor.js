import { View, Text, TouchableOpacity, StyleSheet } from 'react-native';
import { useRouter } from 'expo-router';
import { Ionicons } from '@expo/vector-icons'
import FontAwesome5 from '@expo/vector-icons/FontAwesome5';
import MaterialCommunityIcons from '@expo/vector-icons/MaterialCommunityIcons';

export default function Tutor() {
  const router = useRouter(); // 使用 expo-router 的导航

  return (
    <View style={styles.container}>
      

      {/* 按钮进入 "如何使用 AED" 页面 */}
      <TouchableOpacity 
        style={styles.button}
        onPress={() => router.push('/pages/Tutor/HowAed')}
      >
        <Text style={styles.buttonText}>如何使用 AED</Text>
        <FontAwesome5 name="heartbeat" size={23} color="white" 
          style={{
            marginLeft: 10,
          }}
        />
      </TouchableOpacity>

      <View className="divider"
        style={{
          height: 1, 
          width: '100%', 
          backgroundColor: '#cccccc', 
          marginVertical: 10, 
        }}
      >     

      </View>
      {/* 按钮进入 "如何进行 CPR" 页面 */}
      <TouchableOpacity 
        style={styles.button}
        onPress={() => router.push('/pages/Tutor/HowCpr')}
      >
        <Text style={styles.buttonText}>如何进行 CPR</Text>
        <MaterialCommunityIcons name="doctor" size={28} color="white" 
          style={{
            marginLeft: 7,
          }}
        />
      </TouchableOpacity>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'flex-start', // 从顶部开始布局
    alignItems: 'flex-start', // 水平方向从左对齐
    backgroundColor: '#283747',
    padding: 20, 
  },
  
  button: {
    backgroundColor: '#283747', // 按钮背景与容器背景一致
    flexDirection: 'row',
    alignItems: 'center',
    alignContent: 'center',
    justifyContent: 'center',
  },
  buttonText: {
    color: '#fff', // 文本颜色为白色
    fontSize: 18,
    fontWeight: '500',
  },
});

