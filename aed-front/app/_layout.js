import { Stack} from "expo-router"

function StackLayout(){
    return(
        <Stack>
            <Stack.Screen name="tabs" options={{headerShown:false}} />
        </Stack>
    )
}
export default StackLayout