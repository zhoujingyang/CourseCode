package tester.client;

import com.google.common.base.Objects;
import com.tester.model.HttpMethod;
import org.json.JSONObject;

/**
 * Created by zjy on 17/5/25.
 */
public class Http {

    public static void invoke(Http h, JSONObject object){
        if(Objects.equal(h, HttpMethod.GET)){

        }else if(Objects.equal(h,HttpMethod.POST)){

        }
    }

}
