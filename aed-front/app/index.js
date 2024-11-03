process.env.NODE_TLS_REJECT_UNAUTHORIZED = '0'

import { Redirect } from 'expo-router';

const StartPage = () => {
  return (
    <Redirect href="/tabs" />
  );
};

export default StartPage;