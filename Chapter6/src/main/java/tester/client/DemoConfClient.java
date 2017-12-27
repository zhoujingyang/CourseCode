package tester.client;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by zjy on 17/5/24.
 */
public class DemoConfClient {


    public static final  Locale locale = new Locale("zh","CN");

    public static ResourceBundle getDemoConf(){

        return ResourceBundle.getBundle("config/case/demo/demo",locale);

    }
}
