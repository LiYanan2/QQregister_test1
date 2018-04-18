package xyz.liyanan.qqregister_test1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class DrawActivity extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        paint = new Paint();
        paint.setStrokeWidth(3);
        paint.setColor(Color.BLUE);
        imageView = (ImageView) findViewById(R.id.canvas);
        imageView.setOnTouchListener(touch);
    }

    private View.OnTouchListener touch = new View.OnTouchListener() {
        // 定义手指开始触摸的坐标
        float startX;
        float startY;

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                // 用户按下动作
                case MotionEvent.ACTION_DOWN:
                    // 第一次绘图初始化内存图片，指定背景为白色
                    if (bitmap == null) {
                        bitmap = Bitmap.createBitmap(imageView.getWidth(),
                                imageView.getHeight(), Bitmap.Config.ARGB_8888);
                        canvas = new Canvas(bitmap);
                        canvas.drawColor(Color.WHITE);
                    }
                    // 记录开始触摸的点的坐标
                    startX = event.getX();
                    startY = event.getY();
                    break;
                // 用户手指在屏幕上移动的动作
                case MotionEvent.ACTION_MOVE:
                    // 记录移动位置的点的坐标
                    float stopX = event.getX();
                    float stopY = event.getY();

                    //根据两点坐标，绘制连线
                    canvas.drawLine(startX, startY, stopX, stopY, paint);

                    // 更新开始点的位置
                    startX = event.getX();
                    startY = event.getY();

                    // 把图片展示到ImageView中
                    imageView.setImageBitmap(bitmap);
                    break;
                case MotionEvent.ACTION_UP:

                    break;
                default:
                    break;
            }
            return true;
        }
    };

    protected void resumeCanvas(View view) {
        // 手动清除画板的绘图，重新创建一个画板
        canvas.drawColor(Color.WHITE);
        Toast.makeText(this, "清除画板成功", Toast.LENGTH_SHORT).show();

    }

    protected void redPaint(View view) {
        paint.setColor(Color.RED);
        Toast.makeText(this, "改为红色的笔", Toast.LENGTH_SHORT).show();
    }

    protected void biggerPaint(View view) {
        paint.setStrokeWidth(10);
        Toast.makeText(this, "画笔已加粗", Toast.LENGTH_SHORT).show();
    }


}
