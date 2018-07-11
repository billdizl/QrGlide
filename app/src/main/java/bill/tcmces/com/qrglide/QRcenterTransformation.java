package bill.tcmces.com.qrglide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by liang
 * on 2018/7/11.
 */

public class QRcenterTransformation extends BitmapTransformation {
    private boolean isGif = false;
    private static Paint paint;
    private static Bitmap gifbmp;



    public QRcenterTransformation(Context context, boolean isGif , Bitmap bitmap) {
        super(context);
        this.isGif = isGif;
        this.gifbmp = bitmap;

    }

    static {


        paint = new Paint();
        paint.setColor(Color.parseColor("#469de6"));
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        if(isGif) return addGifIcon(toTransform);
        else return toTransform;
    }

    @Override
    public String getId() {
        return "xxxx.gif";//xxxxx为对应的包名，用做独立标识
    }

    private Bitmap addGifIcon(Bitmap oldbitmap) {

        int width = oldbitmap.getWidth();
        int height = oldbitmap.getHeight();

        int gifbmpWidth = gifbmp.getWidth();
        int gifbmpHeight = gifbmp.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(oldbitmap.getWidth(), oldbitmap.getHeight(), oldbitmap.getConfig());
        Canvas canvas = new Canvas(bitmap);
        Bitmap gifbitmap = zoomImg(gifbmp, 300, 300);
        canvas.drawBitmap(oldbitmap, new Matrix(), null);
        //canvas.drawRect(width - gifbmpWidth/2, height - gifbmpHeight/2, width-gifbmpWidth/2, height+gifbmpHeight/2, paint);
        canvas.drawBitmap(gifbitmap, width/2-gifbmpWidth/3,  height/2-gifbmpHeight/3, null);
        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.restore();
        oldbitmap.recycle();
        gifbitmap.recycle();

        return bitmap;
    }
    // 缩放图片
    public static Bitmap zoomImg(Bitmap bm, int newWidth, int newHeight) {
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }
}
