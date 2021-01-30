package com.hengai.aicaringring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.chaquo.python.Kwarg;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
    }

    private void initData() {
        if (!Python.isStarted()){
            Python.start(new AndroidPlatform(this));
        }

        Python py = Python.getInstance();


        /**
         * PyObject obj1 = py.getModule("workFlow").callAttr("wav2picture",new Kwarg("wav_path", path),new Kwarg("pic_path", pic_path));
         * 其中"workFlow"为需要调用的Python文件名，"wav2picture"为需要调用的函数名，“new Kwarg(“wav_path”, path),new Kwarg(“pic_path”, pic_path)”
         * 表示函数的形参“wavp_path”传入path的值，形参“pic_path”传入pic_path的值，obj1表示调用函数之后的返回值，因为Python中的数据类型和Java中有些不一样，所以一般不能直接使用，需要进行转换，比如：
         *
         * 1.如果Python函数return(以上述obj1为例)为int类型，需要使用一下语句进行转换：
         * Integer result = obj1.toJava(Integer.class);
         *
         * 2.如果Python函数return为一维int的list类型，使用以下语句进行转换：
         * int[] result = obj1.toJava(int[].class);
         *
         * 3.如果Python函数return为二维int的list类型，使用以下语句进行转换：
         * int[][] result = obj1.toJava(int[][].class);
         *
         * Java数据类型 Java数据变量名 = obj1.toJava(Java数据类型.class)
         */
//        PyObject obj1 = py.getModule("test").callAttr("wav2picture",new Kwarg("wav_path", path),new Kwarg("pic_path", pic_path));

        tv = findViewById(R.id.tv);
        PyObject obj1 = py.getModule("test").callAttr("add",new Kwarg("a", 1),new Kwarg("b", 2));
        Integer result = obj1.toJava(Integer.class);
        tv.setText(String.valueOf(result));

        Log.e("TAG",String.valueOf(result));
    }
}