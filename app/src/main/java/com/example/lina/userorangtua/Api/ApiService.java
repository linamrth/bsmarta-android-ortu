package com.example.lina.userorangtua.Api;

import com.example.lina.userorangtua.Model.EditPassword.EditpasswordResultModel;
import com.example.lina.userorangtua.Model.Jadwal.DetailJadwalKursusResultModel;
import com.example.lina.userorangtua.Model.Jadwal.DetailJadwalTrialResultModel;
import com.example.lina.userorangtua.Model.Jadwal.JadwalKursusResultModel;
import com.example.lina.userorangtua.Model.Jadwal.JadwalTrialModel;
import com.example.lina.userorangtua.Model.Kuisioner.KuisionerIsiResultModel;
import com.example.lina.userorangtua.Model.Kuisioner.KuisionerLihatModel;
import com.example.lina.userorangtua.Model.Kuisioner.KuisionerResultModel;
import com.example.lina.userorangtua.Model.Kuisioner.KuisionerStatusResultModel;
import com.example.lina.userorangtua.Model.Login.ModelResultLogin;
import com.example.lina.userorangtua.Model.Pembayaran.DetailPembayaranResultModel;
import com.example.lina.userorangtua.Model.Pembayaran.PembayaranResultModel;
import com.example.lina.userorangtua.Model.Profil.ProfileResultModel;
import com.example.lina.userorangtua.Model.Rapot.DetailRapotKursusResultModel;
import com.example.lina.userorangtua.Model.Rapot.DetailRapotTrialResultModel;
import com.example.lina.userorangtua.Model.Rapot.GrafikPerkembanganModel;
import com.example.lina.userorangtua.Model.Rapot.RapotKursusModel;
import com.example.lina.userorangtua.Model.Rapot.RapotKursusStatusResultModel;
import com.example.lina.userorangtua.Model.Rapot.RapotTrialModel;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class ApiService {
    public static String BASE_URL = "http://lina.jagopesan.com/admin/api/";
    public static String BASE_URL_FOTO = "http://lina.jagopesan.com/admin/images/";

    public static PostServices services_post = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService.PostServices.class);

    public static GetServices services_get = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService.GetServices.class);

    public interface PostServices{
        @FormUrlEncoded
        @POST("login/login")
        Call<ModelResultLogin> login(
                @Field("username") String username,
                @Field("password") String password
        );

        @FormUrlEncoded
        @POST("ortukuisioner/inputkuisioner/{id}")
        Call<KuisionerIsiResultModel> kuisioner(
                @Field("penguasaanmateri") Integer penguasaanmateri,
                @Field("kemampuanmengajar") Integer kemampuanmengajar,
                @Field("kedisiplinan") Integer kedisiplinan,
                @Field("tanggungjawabdantingkahlaku") Integer tanggungjawabdantingkahlaku,
                @Field("kerjasama") Integer kerjasama,
                @Path("id") int id
        );

        @FormUrlEncoded
        @POST("editpassword/editpassword")
        Call<EditpasswordResultModel> editpassword(
                @Field("_id") Integer _id,
                @Field("password") String password,
                @Field("repeatedPassword") String repeatedPassword
        );
    }

    public interface GetServices{
        @GET("ortuprofil/{id}")
        Call<ProfileResultModel> getProfile(@Path("id") int id);

        @GET("ortujadwal/indexjadwaltrial/{id}")
        Call<DetailJadwalTrialResultModel> getDetailJadwalTrial(@Path("id") int id);

        @GET("ortujadwal/jadwaltrial/{id}")
        Call<JadwalTrialModel> getJadwalTrial(@Path("id") int id);

        @GET("ortujadwal/indexjadwalkursus/{id}")
        Call<DetailJadwalKursusResultModel> getDetailJadwalKursus(@Path("id") int id);

        @GET("ortujadwal/jadwalkursus/{id}")
        Call<JadwalKursusResultModel> getJadwalKursus(@Path("id") int id);

        @GET("orturapotsiswa/indexrapottrial/{id}")
        Call<DetailRapotTrialResultModel> getDetailRapotTrial(@Path("id") int id);

        @GET("orturapotsiswa/rapottrial/{id}")
        Call<RapotTrialModel> getRapotTrial(@Path("id") int id);

        @GET("orturapotsiswa/indexrapotkursus/{id}")
        Call<DetailRapotKursusResultModel> getDetailRapotKursus(@Path("id") int id);

        @GET("orturapotsiswa/viewrapotkursus/{id}")
        Call<RapotKursusStatusResultModel> getRapotKursusStatus(@Path("id") int id);

        @GET("orturapotsiswa/rapotkursus/{id}")
        Call<RapotKursusModel> getRapotKursus(@Path("id") int id);

        @GET("orturapotsiswa/grafikperkembangan/{id}")
        Call<GrafikPerkembanganModel> getGrafikPerkembangan(@Path("id") int id);

        @GET("ortupembayaran/index/{id}")
        Call<PembayaranResultModel> getPembayaran(@Path("id") int id);

        @GET("ortupembayaran/detailpembayaran/{id}")
        Call<DetailPembayaranResultModel> getDetailPembayaran(@Path("id")int id);

        @GET("ortukuisioner/index/{id}")
        Call<KuisionerResultModel> getKuisioner(@Path("id") int id);

        @GET("ortukuisioner/view/{id}")
        Call<KuisionerStatusResultModel> getKuisionerStatus(@Path("id") int id);

        @GET("ortukuisioner/lihatkuisioner/{id}")
        Call<KuisionerLihatModel> getKuisionerLihat(@Path("id") int id);
    }
}
