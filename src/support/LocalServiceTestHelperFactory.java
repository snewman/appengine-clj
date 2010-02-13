package support;

import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

/**
 * Needed purely because the following clojure code consistently threw ClassCastException
 * for unknown reasons:
 *
 * <pre>
 * (let [config (new LocalDatastoreServiceTestConfig)
 *       helper (new LocalServiceTestHelper config)])
 * </pre>
 */
public class LocalServiceTestHelperFactory {

    public static LocalServiceTestHelper create() {
        return new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());
    }

}
