import React, {useEffect, useState} from 'react';
import {StyleSheet, View} from 'react-native';
import Home from './src/Home';
import Second from './src/SecondPage';

const App = () => {
  useEffect(() => {
    console.log('Hello world');
  }, []);

  const [first, setFirst] = useState(1);
  return (
    <View style={styles.container}>{first === 1 ? <Home /> : <Second />}</View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
});

export default App;
