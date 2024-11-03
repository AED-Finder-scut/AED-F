import { Redirect } from 'expo-router';

const StartPage = () => {
  return (
    <Redirect href="/tabs" />
  );
};

export default StartPage;