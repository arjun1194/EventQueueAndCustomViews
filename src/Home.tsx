import React from 'react';
import {StyleSheet, Text, View} from 'react-native';
import MyView from './components/myNativeComponent';

function Home(props: any) {
  return (
    <View style={styles.container}>
      <Text style={styles.h1}>This is the Home page</Text>
      <Text style={styles.alignCenter}>{props.title}</Text>
      <MyView />
    </View>
  );
}
const styles = StyleSheet.create({
  container: {},
  h1: {
    textAlign: 'center',
    fontSize: 24,
    fontWeight: 'bold',
  },
  alignCenter: {
    textAlign: 'center',
  },
});
export default Home;
