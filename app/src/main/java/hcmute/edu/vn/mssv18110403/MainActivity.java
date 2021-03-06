package hcmute.edu.vn.mssv18110403;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import hcmute.edu.vn.mssv18110403.adapter.AdvertisementAdapter;
import hcmute.edu.vn.mssv18110403.adapter.CategoryAdapter;
import hcmute.edu.vn.mssv18110403.adapter.HeroAdapter;
import hcmute.edu.vn.mssv18110403.adapter.ProductMainAdapter;
import hcmute.edu.vn.mssv18110403.databaseHandler.DatabaseHelper;
import hcmute.edu.vn.mssv18110403.model.Cart;
import hcmute.edu.vn.mssv18110403.model.Category2;
import hcmute.edu.vn.mssv18110403.model.Flag;
import hcmute.edu.vn.mssv18110403.model.Hero;
import hcmute.edu.vn.mssv18110403.model.Product2;

public class MainActivity extends AppCompatActivity {

    TextView btn_product;
    ImageButton cartButton;

    RecyclerView heroRecyclerView, categoryRecyclerView, productRecyclerView;

    ProductMainAdapter productMainAdapter;
    List<Product2> product2List;

    HeroAdapter heroAdapter;
    List<Hero> heroList;

    ViewPager viewPager;

    int[] images= {R.drawable.adv1,R.drawable.adv2,R.drawable.adv3,R.drawable.adv4,R.drawable.adv5};
    AdvertisementAdapter advertisementAdapter;


    CategoryAdapter categoryAdapter;
    public  static  ArrayList<Cart> arrayCart;
      DatabaseHelper db = new DatabaseHelper(this);
    private final static String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        productRecyclerView = findViewById(R.id.allproductRecycler);
        viewPager = (ViewPager)findViewById(R.id.imageSlider);

        advertisementAdapter = new AdvertisementAdapter(MainActivity.this, images);
        viewPager.setAdapter(advertisementAdapter);

       // Th??m s???n d??? li???u
        addData();
        // list c??c category
        List<Category2> cateList = new ArrayList<>();
        cateList = db.getAllCategory2();
        setCategoryRecycler(cateList);
        setCartRecycler();
        cartButton = (ImageButton)findViewById(R.id.cartButton);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Summary.class);
                startActivity(intent);
            }
        });

        product2List = new ArrayList<>();
        product2List = db.getAllProduct();
        setProductRecycler(product2List);

    }

    private void addData() {

        List<Flag> flagList = new ArrayList<>();
        flagList = db.getAllFlag();

        //Ham if der check da add data chua, chi add mot lan de tranh qua nhieu du lieu.
        if(flagList.size() > 0)
        {
            System.out.println("Data have created");
        }
        else {

            db.addFlag( new Flag("test"));


            byte[] traicay1 = imageHandling(R.drawable.traicay1);
            byte[] traicay2 = imageHandling(R.drawable.traicay2);
            byte[] traicay3 = imageHandling(R.drawable.traicay3);
            byte[] traicay4 = imageHandling(R.drawable.traicay4);
            byte[] traicay5 = imageHandling(R.drawable.traicay5);
            byte[] traicay6 = imageHandling(R.drawable.traicay6);
            byte[] traicay7 = imageHandling(R.drawable.traicay7);
            byte[] traicay8 = imageHandling(R.drawable.traicay8);
            byte[] traicay9 = imageHandling(R.drawable.traicay9);
            byte[] traicay10 = imageHandling(R.drawable.traicay10);

            byte[] banhkeo1 = imageHandling(R.drawable.banhkeo1);
            byte[] banhkeo2 = imageHandling(R.drawable.banhkeo2);
            byte[] banhkeo3 = imageHandling(R.drawable.banhkeo3);
            byte[] banhkeo4 = imageHandling(R.drawable.banhkeo4);
            byte[] banhkeo5 = imageHandling(R.drawable.banhkeo5);
            byte[] banhkeo6 = imageHandling(R.drawable.banhkeo6);
            byte[] banhkeo7 = imageHandling(R.drawable.banhkeo7);
            byte[] banhkeo8 = imageHandling(R.drawable.banhkeo8);
            byte[] banhkeo9 = imageHandling(R.drawable.banhkeo9);
            byte[] banhkeo10 = imageHandling(R.drawable.banhkeo10);

            byte[] nuoc1 = imageHandling(R.drawable.nuoc1);
            byte[] nuoc2 = imageHandling(R.drawable.nuoc2);
            byte[] nuoc3 = imageHandling(R.drawable.nuoc3);
            byte[] nuoc4 = imageHandling(R.drawable.nuoc4);
            byte[] nuoc5 = imageHandling(R.drawable.nuoc5);
            byte[] nuoc6 = imageHandling(R.drawable.nuoc6);
            byte[] nuoc7 = imageHandling(R.drawable.nuoc7);

            byte[] mut1 = imageHandling(R.drawable.mut1);
            byte[] mut2 = imageHandling(R.drawable.mut2);
            byte[] mut3 = imageHandling(R.drawable.mut3);
            byte[] mut4 = imageHandling(R.drawable.mut4);
            byte[] mut5 = imageHandling(R.drawable.mut5);


            db.addProduct(new Product2("B??", 1260, "B?? nh???p kh???u ???? L???t", 120, traicay1, "", 1));
            db.addProduct(new Product2("K???o d???o", 210, "K???o d???o Trung Qu???c", 320, banhkeo1, "", 2));
            db.addProduct(new Product2("Sting", 2310, "Ph???m t???t cho s???c kh???e", 3320, nuoc1, "", 3));
            db.addProduct(new Product2("M???t g???ng", 1350, "M???t g???ng m??? crush l??m", 30, mut1, "", 4));





            db.addProduct(new Product2("M??ng c???t", 4360, "M??ng c???t Campuchia", 190, traicay2, "", 1));
            db.addProduct(new Product2("OREO", 160, "B??nh Oreo Hong Kong", 1903, banhkeo2, "", 2));
            db.addProduct(new Product2("Number 1", 1630, "N?????c ng???t si??u t???t s???c kh???e", 19303, nuoc2, "", 3));
            db.addProduct(new Product2("M???t d???a", 1350, "M???t d???a B???n Tre", 230, mut2, "", 4));



            db.addProduct(new Product2("S???u ri??ng", 1260, "S???u ri??ng M???", 120, traicay3, "", 1));
            db.addProduct(new Product2("Chocopie", 160, "Chocopie Cai L???y", 1220, banhkeo3, "", 2));
            db.addProduct(new Product2("Coca cola", 160, "Si??u ng???t si??u ngon", 1903, nuoc3, "", 3));
            db.addProduct(new Product2("M???t khoai", 1350, "M???t khai to??n khoai", 2330, mut3, "", 4));



            db.addProduct(new Product2("Kiwi", 12360, "Kiwi Nam Phi", 100, traicay4, "", 1));
            db.addProduct(new Product2("B??nh k???p", 160, "B??nh k???p H???i Ph??ng", 1030, banhkeo4, "", 2));
            db.addProduct(new Product2("Kh??ng ?????", 160, "Qu???nh c??o l?? gi???i ?????c c?? th???", 1903, nuoc4, "", 3));
            db.addProduct(new Product2("M???t t??o", 1350, "M???t t??o c??ng ch??a", 210, mut4, "", 4));


            db.addProduct(new Product2("So??i", 12360, "So??i ??c", 3200, traicay5, "", 1));
            db.addProduct(new Product2("B??nh ?????u ?????", 12360, "B??nh ?????u Alice", 320, banhkeo5, "", 2));
            db.addProduct(new Product2("Cam ??p", 160, "Cam ch??? chi???m 0,001%", 1903, nuoc5, "", 3));
            db.addProduct(new Product2("M???t chu???i", 1350, "M???t chu???i Kon Tum", 25, mut5, "", 4));


            db.addProduct(new Product2("Chu???i", 1350, "Chu???i ???n ?????", 530, traicay6, "", 1));
            db.addProduct(new Product2("B??nh D???o", 1350, "B??nh d???o MaCau", 2330, banhkeo6, "", 2));
            db.addProduct(new Product2("Kho???ng Chanh", 1350, "Kho??ng chanh gi???i ?????c, say ", 2330, nuoc6, "", 3));



            db.addProduct(new Product2("Thanh Long", 1260, "Thanh long qu?? Crush", 1200, traicay7, "", 1));
            db.addProduct(new Product2("B??nh R??n", 13260, "B??nh R??n kh??ng Doraemon", 120, banhkeo7, "", 2));
            db.addProduct(new Product2("Pepsi", 1350, "Gi???i kh??t t???t ?????nh", 100, nuoc7, "", 3));



            db.addProduct(new Product2("B?????i", 1260, "B?????i H?? N???i", 1203, traicay8, "", 1));
            db.addProduct(new Product2("Custas", 1260, "Custas Dotimo", 32, banhkeo8, "", 2));


            db.addProduct(new Product2("Xam B?? Ch??", 1260, "Xam B?? Ch?? Th??i Lan", 120, traicay9, "", 1));
            db.addProduct(new Product2("B??nh Kem", 1260, "B??nh kem nh?? l??m", 1203, banhkeo9, "", 2));


            db.addProduct(new Product2("Nho", 1260, "Nho nh?? em", 10, traicay10, "", 1));
            db.addProduct(new Product2("B??nh Tr???ng", 120, "B??nh tr???ng kh??ng xu???t x???", 130, banhkeo10, "", 2));



            byte[] traicay = imageHandling(R.drawable.traicay);
            byte[] banhkeo = imageHandling(R.drawable.banhkeo);
            byte[] nuocuong = imageHandling(R.drawable.nuocuong);
            byte[] mut = imageHandling(R.drawable.mut);


            db.addCategory2(new Category2("Tr??i c??y", traicay));
            db.addCategory2(new Category2("B??nh k???o", banhkeo));
            db.addCategory2(new Category2("N?????c u???ng", nuocuong));
            db.addCategory2(new Category2("M???t", mut));
        }


    }
    private byte[] imageHandling(int i)
    {
        Bitmap bitmapmut = ((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), i, null)).getBitmap();
        ByteArrayOutputStream streammut = new ByteArrayOutputStream();
        bitmapmut.compress(Bitmap.CompressFormat.PNG, 100, streammut);
        byte[] mut = streammut.toByteArray();
        return  mut;
    }

    private void setProductRecycler(List<Product2> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        productRecyclerView.setLayoutManager(layoutManager);
        productMainAdapter = new ProductMainAdapter(this,dataList);
        productRecyclerView.setAdapter(productMainAdapter);
    }

    private void setHeroRecycler(List<Hero> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        heroRecyclerView.setLayoutManager(layoutManager);
        heroAdapter = new HeroAdapter(this,dataList);
        heroRecyclerView.setAdapter(heroAdapter);
    }
    private void setCategoryRecycler(List<Category2> dataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,dataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }
    private  void setCartRecycler()
    {
        if(arrayCart !=null)
        {
        }
        else
        {
            arrayCart  = new ArrayList<>();
        }

    }
}