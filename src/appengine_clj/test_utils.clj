(ns appengine-clj.test-utils
  (:require [clojure.contrib.test-is :as test-is])
  (:import
    (com.google.appengine.tools.development.testing LocalDatastoreServiceTestConfig)
    (com.google.appengine.tools.development.testing LocalServiceTestHelper)
    (support LocalServiceTestHelperFactory)))

(defmacro dstest [name & body]
  `(test-is/deftest ~name
    (.setUp (LocalServiceTestHelperFactory/create))
    (try
      ~@body
      (finally (.tearDown (LocalServiceTestHelperFactory/create))))))

;private final LocalServiceTestHelper helper =
;        new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

;TestLocalServerEnvironment
;(.setProperty LocalDatastoreService/NO_STORAGE_PROPERTY "true")
;(defn ds-setup []
;  (let [proxy-factory (doto (ApiProxyLocalFactory.) )
;        test-environment (TestLocalServerEnvironment.)
;        api-proxy     (doto (.create proxy-factory test-environment))]
;    (ApiProxy/setDelegate api-proxy))
;  (ApiProxy/setEnvironmentForCurrentThread
;    (proxy [com.google.apphosting.api.ApiProxy$Environment] []
;      (getAppId [] "test")
;      (getVersionId [] "1.0")
;      (getRequestNamespace [] "")
;      (getAttributes [] (java.util.HashMap.)))))
;
;(defn ds-teardown []
;  (ApiProxy/clearEnvironmentForCurrentThread)
;  (.stop (ApiProxy/getDelegate)))
;
;(defmacro dstest2 [name & body]
;  `(test-is/deftest ~name
;    (ds-setup)
;    (try
;      ~@body
;      (finally (ds-teardown)))))
