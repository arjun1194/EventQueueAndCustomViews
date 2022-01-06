import React, {useEffect} from 'react';
import {StyleSheet, View} from 'react-native';
import Home from './src/Home';

const App = () => {
  useEffect(() => {
    console.log('Hello world');
  }, []);
  return (
    <View style={styles.container}>
      <Home title={'Hello world this is my home'} />
    </View>
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
