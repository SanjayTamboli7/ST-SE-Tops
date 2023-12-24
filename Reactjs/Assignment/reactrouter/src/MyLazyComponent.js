import React, { lazy, Suspense } from 'react';

const LazyReactLogo = lazy(()=>{return new Promise (resolve => {
  setTimeout(() => {
     resolve(import("./Como"))
  }, 4000);
})});

const MyLazyComponent = () => (
  <div style={{textAlign:"center"}}>

    <h1>Welcome Lazy loading React Component!</h1>

    {/* "Suspense" is generally used to refer to a new way of building React apps using the concurrent rendering engine 
        introduced in React 18. It's also a specific React API, <Suspense /> , a component that lets you display a fallback 
        until its children have finished loading. */}

    <Suspense fallback={<h1>Please wait...Children components are being loaded...</h1>} >
      <LazyReactLogo/>
    </Suspense>

  </div>
);

export default MyLazyComponent;
