package com.cloversoft.ks.server.request;

import android.content.Context;

import com.cloversoft.ks.config.Keys;
import com.cloversoft.ks.data.model.api.SampleModel;
import com.cloversoft.ks.vendor.server.request.APIRequest;
import com.cloversoft.ks.vendor.server.request.APIResponse;
import com.cloversoft.ks.vendor.server.transformer.BaseTransformer;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;



public class Auth {

    public static Auth getDefault(){
        return new Auth();
    }

    public void login(Context context, String username, String password) {
        APIRequest apiRequest = new APIRequest<BaseTransformer>(context) {
            @Override
            public Call<BaseTransformer> onCreateCall() {
                return getRetrofit().create(RequestService.class).requestLogin(getMultipartBody());
            }

            @Override
            public void onResponse() {
                EventBus.getDefault().post(new LoginResponse(this));
            }
        };

        apiRequest
                .addParameter(Keys.USERNAME, username)
                .addParameter(Keys.PASSWORD, password)
                .showDefaultProgressDialog("Logging in...")
                .execute();

    }

    public static void logout(int id) {

    }

    public void signup(SampleModel userModel) {

    }

    public static void facebook(SampleModel userModel) {

    }


    public interface RequestService {
        @Multipart
        @POST("{p}")
        Call<BaseTransformer> requestLogin(@Part List<MultipartBody.Part> parts);

        @POST("url")
        Call<BaseTransformer> requestLogout(@Header("Authorization") String authorization);
    }


    public class LoginResponse extends APIResponse<BaseTransformer> {
        public LoginResponse(APIRequest apiRequest) {
            super(apiRequest);
        }
    }
}
