package com.example.manager.managesportstore.retrofit;



import com.example.manager.managesportstore.model.DonHangModel;
import com.example.manager.managesportstore.model.LoaiSpModel;
import com.example.manager.managesportstore.model.MessageModel;
import com.example.manager.managesportstore.model.SanPhamMoiModel;
import com.example.manager.managesportstore.model.UserModel;

import io.reactivex.rxjava3.core.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiBanHang {
    //GET DATA
    @GET("getloaisp.php")
    Observable <LoaiSpModel> getLoaiSp();

    @GET("getspmoi.php")
    Observable <SanPhamMoiModel> getSpMoi();

    @POST("chitiet.php")
    @FormUrlEncoded
    Observable <SanPhamMoiModel> getSanPham(
            @Field("page") int page,
            @Field("loai") int loai
    );


    //POST DATA
    @POST("dangki.php")
    @FormUrlEncoded
    Observable <UserModel> dangKi(
            @Field("email") String email,
            @Field("pass") String pass,
            @Field("username") String username,
            @Field("mobile") String mobile
    );


    @POST("dangnhap.php")
    @FormUrlEncoded
    Observable <UserModel> dangNhap(
            @Field("email") String email,
            @Field("pass") String pass

    );


    @POST("donhang.php")
    @FormUrlEncoded
    Observable <UserModel> createOrder(
            @Field("email") String email,
            @Field("sdt") String sdt,
            @Field("tongtien") String tongtien,
            @Field("iduser") int id,
            @Field("diachi") String diachi,
            @Field("soluong") int soluong,
            @Field("chitiet") String chitiet





    );


    @POST("xemdonhang.php")
    @FormUrlEncoded
    Observable <DonHangModel> xemDonHang(
            @Field("iduser") int id





    );


    @POST("xoa.php")
    @FormUrlEncoded
    Observable <MessageModel> xoaSanPham(
            @Field("id") int id);


    @POST("timkiem.php")
    @FormUrlEncoded
    Observable <SanPhamMoiModel> search(
            @Field("search") String search);



    @POST("insertsp.php")
    @FormUrlEncoded
    Observable <MessageModel> insertSp(
            @Field("tensp") String tensp,
            @Field("gia") String gia,
            @Field("hinhanh") String hinhanh,
            @Field("mota") String mota,
            @Field("loai") int loai






    );

    @POST("updatesp.php")
    @FormUrlEncoded
    Observable <MessageModel> updatesp(
            @Field("tensp") String tensp,
            @Field("gia") String gia,
            @Field("hinhanh") String hinhanh,
            @Field("mota") String mota,
            @Field("loai") int loai,
            @Field("id") int id







    );



    @Multipart
    @POST("upload.php")
    Call<MessageModel> uploadFile(@Part MultipartBody.Part file);





}
