import React from 'react';
import {ScrollView, StyleSheet, Text, View} from 'react-native';
import UploadProgressView from './components/UploadProgressView';

function Home() {
  return (
    <View>
      <Text>Hello world</Text>
      <UploadProgressView />
    </View>
  );
}
const styles = StyleSheet.create({
  container: {flex: 1},
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
