package bill.tcmces.com.qrglide;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private ImageView hecheng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hecheng = (ImageView) findViewById(R.id.iv_ivhsbe);
        Button btnhecheneg=(Button) findViewById(R.id.btnhecheneg);


//        btnhecheneg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.ic );
//                Glide.with(MainActivity.this).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1531282493149&di=119a6d4981a316ed9b97e7a3136b8150&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F15%2F23%2F09%2F74T58PICZjg_1024.jpg")                        .asBitmap()
//                        .fitCenter()
//                        .centerCrop()
//                        .transform(new CenterCrop(MainActivity.this),new QRcenterTransformation(MainActivity.this,true,bmp))
//                        //.skipMemoryCache(true) // 不使用内存缓存
//                        .diskCacheStrategy(DiskCacheStrategy.SOURCE) // 不使用磁盘缓存
//                        .into(hecheng);
//            }
//        });
    }
}
