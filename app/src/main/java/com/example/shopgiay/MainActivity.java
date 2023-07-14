package com.example.shopgiay;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import Fragment.HomeFragment;
import ObjectClass.ProductDetails;
import database.DataBase;
import database.DataOfUser;

public class MainActivity extends AppCompatActivity {

    DataBase dataBase;
    SharedPreferences sharedPreferences;

//  mấy cái này dùng để insert hình ảnh khi chưa có trang admin

    Button select, previous, next;
    ImageView imageView, imgShow;
    int PICK_IMAGE_MULTIPLE = 1;
    EditText total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_them_hinh);
        dataBase = new DataBase(this, "shopgiay.sqlite", null, 1);
        sharedPreferences = getSharedPreferences("isLogin",MODE_PRIVATE);
        String idUserLogin = sharedPreferences.getString("idUser","");
        DataOfUser.idUser = idUserLogin;
        Toast.makeText(this,DataOfUser.idUser,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, MainFragActivity.class);
        startActivity(intent);


//  mấy cái này dùng để insert hình ảnh khi chưa có trang admin
        select = findViewById(R.id.select);
        total = findViewById(R.id.text);
        imageView = findViewById(R.id.image);
        previous = findViewById(R.id.previous);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, PICK_IMAGE_MULTIPLE);


            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) imageView.getDrawable();
                Bitmap bitmap = bitmapDrawable.getBitmap();
                ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
                byte[] img = byteArray.toByteArray();


                dataBase.insertImg(total.getText().toString().trim(),img );
                Toast.makeText(MainActivity.this, "Đã thêm", Toast.LENGTH_LONG).show();
            }
        });


        startActivity(intent);
/*
       dataBase = new DataBase(this, "shopgiay.sqlite", null, 1);

        Toast.makeText(this, getDatabasePath("shopgiay.sqlite").getPath(), Toast.LENGTH_LONG).show();

//       Tạo bảnggggggggggggg
        //  isAdmin 0 là false, isLogin 0 là chưa đăng nhập
       dataBase.queryData("CREATE TABLE IF NOT EXISTS Account(userName VARCHAR(10) PRIMARY KEY, password VARCHAR(50), isAdmin INTEGER)");
//        table san pham
        dataBase.queryData("CREATE TABLE IF NOT EXISTS Product(idProd VARCHAR(10) PRIMARY KEY, nameProd VARCHAR(50), brand VARCHAR(20), price INTEGER, desc NVARCHAR(200))");
       //quantity là số lượng hàng nhập
        dataBase.queryData("CREATE TABLE IF NOT EXISTS ProductDetails(idProdDetails VARCHAR(10), idProd VARCHAR(10), size INTEGER, color VARCHAR(10), quantity INTEGER, PRIMARY KEY (idProdDetails, idProd, size, color))");
        dataBase.queryData("CREATE TABLE IF NOT EXISTS LinkImg_Prod(idImg INTEGER PRIMARY KEY AUTOINCREMENT,idProd VARCHAR(10), img BLOB) ");

//        table thoong tin khach hàng
        dataBase.queryData("CREATE TABLE IF NOT EXISTS Customer(userName VARCHAR(10),linkAvatar VARCHAR(100), nameCus VARCHAR(200), numberPhone VARCHAR(10), email VARCHAR(100), address NVARCHAR(100))");

//        table giỏ hang các sản phẩm lúc chưa đặt hàng
        dataBase.queryData("CREATE TABLE IF NOT EXISTS Cart(userName VARCHAR(10), idProdDetails VARCHAR(10) , amountCart INTEGER)");

//        table danh sách yêu thích
        dataBase.queryData("CREATE TABLE IF NOT EXISTS Favorite(userName VARCHAR(10), idProd VARCHAR(10),  PRIMARY KEY (userName, idProd))");

//        table đơn hàng có trạng thái đơn hàng state[ xac nhan(admin), huy don, da nhan(user)]

//        dataBase.queryData("DROP TABLE Orders");
        dataBase.queryData("CREATE TABLE IF NOT EXISTS Orders(idOrder VARCHAR(10),userName VARCHAR(10), idProdDetails VARCHAR(10) , amountOrder INTEGER, totalCost DOUBLE, delivery NVARCHAR(200), state VARCHAR(20))");

//
        dataBase.queryData("INSERT INTO Account VALUES('truongdinh', '123', 0)");
        dataBase.queryData("INSERT INTO Account VALUES('truonggiang', '123', 0)");
        dataBase.queryData("INSERT INTO Account VALUES('hieudeptrai', '2704', 0)");
        dataBase.queryData("INSERT INTO Account VALUES('admin', '123', 1)");
        dataBase.queryData("INSERT INTO Product VALUES ('id1','1 Giày AF1','Nike','400000','test'),('id2','2 Giày AF1','Nike','400000','test'),('id3','3 Giày AF1','Nike','400000','test'), ('id4','4 Giày AF1','Adidas','400000','test'),  ('id5','5 Giày AF1','Mizuno','400000','test'), ('id6','6 Giày AF1','Puma','400000','test'); ");

        dataBase.queryData("INSERT INTO Product VALUES ('1','VANS AUTHENTIC CLASSIC BLACK/WHITE','VANS', 1450000, 'VANS CLASSIC AUTHENTIC BLACK/WHITE: Là phiên bản được ưa chuộng nhất trong bộ sưu tập Authentic của VANS với sự kết hợp 2 màu đen trắng dễ phối đồ và custom, đặc biệt là phiên bản cổ nhất có tuổi đời hơn 50 năm, dù vậy vẫn được fan hâm mộ săn đón và được sử dụng khá nhiều với những vận động viên trượt ván chuyên nghiệp.'), ('2','VANS CLASSIC SK8-HI BLACK/WHITE','VANS', 1950000, 'Phiên bản VANS Classic Sk8 Black/White là một trong style kinh điển của VANS và đã mang lại lợi nhuận khổng lồ cho hãng khi luôn nằm trong mục Best Seller của VANS. Tông màu đen đơn giản dễ phối đồ cùng cổ cao kinh điển sẽ là sản phẩm tuyệt vời cho các fan yêu thời trang.'), ('3','VANS SLIP-ON CLASSIC TRUE WHITE','VANS', 1450000, 'VANS CLASSIC SLIP-ON TRUE WHITE: Là phiên bản trắng tinh True White nằm trong mục Best Seller của VANS và nằm trong bộ 3 True White mang lại lợi nhuận khổng lồ cho hãng. Được các họa sĩ Custom lựa chọn để cho ra những tác phẩm độc đáo vì chất liệu vải bố, đồng thời toàn đôi giày đều có thể vẽ lên bất cứ đâu.'), ('4','VANS OLD SKOOL CLASSIC BLACK/WHITE','VANS', 1750000, 'VANS OLD SKOOL CLASSIC BLACK/WHITE: Được gọi vui một cách thân thuộc là giày VANS đen vốn là một sự phổ biến rất đặc biệt đối với các tín đồ của nhà VANS.')");
        dataBase.queryData("INSERT INTO Product VALUES ('idabc','VANS AUTHENTIC CLASSIC BLACK/WHITE','VANS', '1450000','test')");

        dataBase.queryData("INSERT INTO ProductDetails VALUES ('136w', 'id1', '36','White','10'),('136b', '1', '36','Black','8'),('137w', '1', '37','White','5'),('137b', '1', '37','Black','4'),('138w', '1', '38','White','5'),('138b', '1', '38','Black','4'),('139w', '1', '39','White','7'),('139b', '1', '39','Black','4'),('140w', '1', '40','White','5'),('140b', '1', '40','Black','4'),('141w', '1', '41','White','4'),('141b', '1', '41','Black','1'),('142w', '1', '42','White','7'),('142b', '1', '42','Black','4'),('143w', '1', '43','White','1'),('236w', '2', '36','White','10'),('236b', '2', '36','Black','8'),('237w', '2', '37','White','5'),('237b', '2', '37','Black','4'),('238w', '2', '38','White','5'),('238b', '2', '38','Black','4'),('239w', '2', '39','White','7'),('239b', '2', '39','Black','4'),('240w', '2', '40','White','5'),('240b', '2', '40','Black','4'),('241w', '2', '41','White','4'),('241b', '2', '41','Black','1'),('242w', '2', '42','White','7'),('242b', '2', '42','Black','4'),('243w', '2', '43','White','1'),('336w', '3', '36','White','4'),('337w', '3', '37','White','5'),('338w', '3', '38','White','5'),('339w', '3', '39','White','7'),('340w', '3', '40','White','5'),('341w', '3', '41','White','4'),('342w', '3', '42','White','7'),('343w', '3', '43','White','1'),('436w', '4', '36','White','10'),('436b', '4', '36','Black','8'),('437w', '4', '37','White','5'),('437b', '4', '37','Black','4'),('438w', '4', '38','White','5'),('438b', '4', '38','Black','4'),('439w', '4', '39','White','7'),('439b', '4', '39','Black','4'),('440w', '4', '40','White','5'),('440b', '4', '40','Black','4'),('441w', '4', '41','White','4'),('441b', '4', '41','Black','1'),('442w', '4', '42','White','7'),('442b', '4', '42','Black','4'),('443w', '4', '43','White','1');");
        dataBase.queryData("INSERT INTO ProductDetails VALUES ('id136w', 'id1', '36','White','10'),('id136b', 'id2', '36','Black','8'),('id137w', 'id3', '37','White','5'),('id137b', 'id4', '37','Black','4'),('id138w', 'id5', '38','White','5'),('id138b', 'id6', '38','Black','4'),('idabc38b', 'idabc', '38','Black','4'),('id1140b', 'id1', '40','Black','4')");
        Log.e("main", "done insert");

        dataBase.queryData("INSERT INTO ProductDetails VALUES ('136a1', 'id1', '36','Black','10')");
        dataBase.queryData("INSERT INTO ProductDetails VALUES ('136a2', 'id1', '36','Orange','10')");
        dataBase.queryData("INSERT INTO ProductDetails VALUES ('136a3', 'id1', '37','Pink','10')");
        dataBase.queryData("INSERT INTO ProductDetails VALUES ('136a4', 'id1', '37','Red','10')");


        dataBase.close();
 */
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_MULTIPLE && resultCode == RESULT_OK && null != data) {
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }
    }
}