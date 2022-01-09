import React from 'react';
import {requireNativeComponent, ScrollView, ToastAndroid} from 'react-native';
let ReactView = requireNativeComponent('MyReactView');
import {Dimensions} from 'react-native';
const windowWidth = Dimensions.get('window').width;
const windowHeight = Dimensions.get('window').height;

function MyView(props) {
  const onLoad = event => {
    console.log('event is -->', event);
    if (props.onLoaded) {
      return;
    }
    console.log('event is -->', event);
    props.onLoaded();
  };

  const longClick = () => {
    ToastAndroid.show('Long Click Performed!', 500);
  };

  return (
    <ScrollView>
      <ReactView
        style={{width: windowWidth, height: windowHeight}}
        onLoad={onLoad}
        longClick={longClick}
      />
    </ScrollView>
  );
}

export default MyView;
