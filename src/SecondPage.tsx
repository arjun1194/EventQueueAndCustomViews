import React, {useState} from 'react';
import {
  Dimensions,
  FlatList,
  Image,
  StyleSheet,
  Text,
  View,
} from 'react-native';
const {height, width} = Dimensions.get('window');

function Second() {
  const [data, setData] = useState([{}, {}, {}, {}, {}, {}, {}, {}, {}, {}]);
  const _renderList = () => {
    return (
      <View style={styles.container}>
        <Image
          style={{height: 100, width: 100}}
          source={{
            uri: 'https://github.com/bumptech/glide/raw/master/static/glide_logo.png',
          }}
        />
        <Text style={{fontSize: 24}}>Hello world</Text>
      </View>
    );
  };
  return (
    <View
      style={{
        height: height / 2,
        width: width,
        justifyContent: 'flex-start',
      }}>
      <FlatList data={data} renderItem={_renderList} />
    </View>
  );
}
const styles = StyleSheet.create({
  container: {
    flexDirection: 'row',
    borderColor: '#000000',
    borderStyle: 'solid',
    borderWidth: 4,
  },
  h1: {
    textAlign: 'center',
    fontSize: 24,
    fontWeight: 'bold',
  },
  alignCenter: {
    textAlign: 'center',
  },
});
export default Second;
