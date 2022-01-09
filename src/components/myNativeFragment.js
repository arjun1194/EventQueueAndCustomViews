import React, {useEffect, useRef} from 'react';
import {
  Dimensions,
  findNodeHandle,
  PixelRatio,
  requireNativeComponent,
  UIManager,
} from 'react-native';

let MyFragmentView = requireNativeComponent('FragmentViewManager');
const {width, height} = Dimensions.get('window');

const createFragment = viewId => {
  console.log(`createFragment -- ${viewId}`);
  const commandId = UIManager.FragmentViewManager.Commands.create.toString();
  console.log('commandId ->', commandId);
  return UIManager.dispatchViewManagerCommand(viewId, commandId, [viewId]);
};

function MyFragment(props) {
  const ref = useRef(null);

  useEffect(() => {
    console.log(`height is -> ${height} - width is -> ${width}`);
    const viewId = findNodeHandle(ref.current);
    console.log('useEffect -->', viewId);
    createFragment(viewId);
  }, []);

  return (
    <MyFragmentView
      style={{
        // converts dpi to px, provide desired height
        height: height,
        // converts dpi to px, provide desired width
        width: width,
      }}
      ref={ref}
    />
  );
}

export default MyFragment;
