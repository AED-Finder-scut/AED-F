import { View, Text, StyleSheet,Image } from 'react-native';
import { useNavigation } from 'expo-router';
import React from 'react';
import GuideStyles from './style';
export default function HowToUseCPR() {
    const navigation = useNavigation();

  // 在页面渲染时设置标题
  React.useLayoutEffect(() => {
    navigation.setOptions({
        title: '如何进行 CPR', 
        headerStyle: {
            backgroundColor: 'darkred',  
        },
        headerTintColor: '#fff',       
        headerTitleStyle: {
            fontWeight: 'bold',         
        },
    });
}, [navigation]);
  return (
    <View
    style={{
        
            flex: 1,
            backgroundColor:'#283747'
        
    }}
    >
        <View>
            <Text
                style={GuideStyles.Text1}
            >
                一、拨打紧急电话 120
            </Text>
            <Text
                style={GuideStyles.Text2}
            >
                确保现场环境安全后再继续。
            </Text>
            <Text
                style={GuideStyles.Text2}
            >
                为了防止感染，可以考虑戴上口罩或布，并用口罩或布盖住受害者的口鼻。
                
            </Text>
            <Text
                style={GuideStyles.Text2}
            >
                检查受害者是否有反应，如呼吸、心跳等。
            </Text>
            <Text
                style={GuideStyles.Text2}
            >
                如果受害者没有反应且没有呼吸、心跳，请立即呼叫120并开始胸外按压。
                
            </Text>
        </View>

        <View>
            <Text 
                style={GuideStyles.Text1}
            >
                二、开始胸外按压
            </Text>
            <Text
                style={GuideStyles.Text2}
            >
                用力并快速的按压。将你的手一只放在另一只手的上面，放在两乳头连线中心下两个手指头的位置。
            </Text>
            <Text
                style={GuideStyles.Text2}
            >
                充分利用自身体重来帮助进行每次至少5cm的深度按压，并以每分钟至少100次的速度进行按压。
            </Text>
            <Image source={require('../../../assets/imgs/cpr1.jpg')} 
                    style={GuideStyles.Image}
                />
            <Image source={require('../../../assets/imgs/cpr2.jpg')} 
                    style={GuideStyles.Image}
                />    
        </View>
    </View>
  );
}