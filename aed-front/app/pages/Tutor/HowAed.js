import { View, Text, StyleSheet,Image,ScrollView, } from 'react-native';
import { useNavigation } from 'expo-router';
import React from 'react';
import GuideStyleS from './style'
export default function HowToUseAED() {
    const navigation = useNavigation();

  
  React.useLayoutEffect(() => {
    navigation.setOptions({
        title: '如何使用 AED', 
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
    <ScrollView>
        <View 
            style={{
                flex: 1,
                backgroundColor:'#283747'
            }}
        >
            <View className="sec-1">
                <Text 
                    style={GuideStyles.Text1}
                >一、致电：识别心脏骤停并致电 120</Text>
                <Text
                    style={GuideStyles.Text2}
                >检查反应能力：如果受害者没有反应并且呼吸不正常，他们可能处于心脏骤停状态。如果您有立即可用的电话，请拨打 120。否则，请让其他人拨打 120。无论哪种情况，请尽快开始心肺复苏。</Text>
            </View>

            <View className="sec-2">
                <Text style={GuideStyles.Text1}>
                    二、准备工作
                </Text>
                <Text style={GuideStyles.Text2}>
                    放置AED于受害者身旁。启动AED，并人为裸露受害者胸膛。
                </Text>
                <Image source={require('../../../assets/imgs/aed1.jpg')} 
                    style={GuideStyles.Image}
                />
            </View>

            <View className="sec-3">
                <Text
                    style={GuideStyles.Text1}
                >
                    三、撕开并使用电极片
                </Text>

                <Text 
                    style={GuideStyles.Text2}
                >
                    如图所示，撕开并使用电极片。注：粘贴时一定要用力，使电极片完全吸附在受害者胸部。
                </Text>
                <Image source={require('../../../assets/imgs/aed2.jpg')} 
                    style={GuideStyles.Image}
                />

                <View className="sec-4"
                >
                    <Text style={GuideStyles.Text1}>
                        四、按照AED语音指令执行
                    </Text>
                    <Text style={GuideStyles.Text2}>
                        遵循AED语音指令，直到紧急医疗人员到达
                    </Text>
                    <Image source={require('../../../assets/imgs/aed3.jpg')} 
                    style={{
                        width: 200,
                        height: 200,
                        margin: 10,
                        alignSelf: 'center',
                        marginTop:20,
                        marginBottom:40,
                    }}
                />
                </View>
            </View>
        </View>
    </ScrollView>
  );
}


