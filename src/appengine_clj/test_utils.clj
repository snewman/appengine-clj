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