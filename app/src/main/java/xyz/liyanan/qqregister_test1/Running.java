package xyz.liyanan.qqregister_test1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
//继承View类的running类
public class Running extends View{
    //定义相关变量，依次是金毛显示的位置的X，y坐标
    public float bitmapX;
    public float bitmapY;
    //构造函数初始化view的初始坐标
    public Running(Context context) {
        super(context);
        //设置图片的起始坐标
        bitmapX = 0;
        bitmapY = 200;
    }

    //重写View类的onDraw（）方法
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //创建并且实例化Paint的对象
        Paint paint = new Paint();
        //根据图片生成位图对象
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.img);
        //绘制金毛位图图像
        canvas.drawBitmap(bitmap, bitmapX, bitmapY, paint);
        //判断是否图片回收，没有回收则强制回收
        if (bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

}
