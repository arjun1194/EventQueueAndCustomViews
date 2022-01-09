import React from 'react';
import {Dimensions, requireNativeComponent} from 'react-native';
const RCTUploadProgressView = requireNativeComponent('RCTUploadProgressView');
const {height, width} = Dimensions.get('window');
const UploadProgressView = () => {
  return <RCTUploadProgressView style={{width: width, height: height / 2}} />;
};

export default UploadProgressView;
