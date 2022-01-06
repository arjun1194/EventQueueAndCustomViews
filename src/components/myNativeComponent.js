import React from 'react';
import {requireNativeComponent} from 'react-native';
let ReactView;
if (!ReactView) {
  ReactView = requireNativeComponent('MyReactView');
}

function MyView() {
  return (
    <ReactView
      myProp="ching"
      style={{height: 100, width: 100, backgroundColor: 'red', opacity: 0.5}}
    />
  );
}

export default MyView;
